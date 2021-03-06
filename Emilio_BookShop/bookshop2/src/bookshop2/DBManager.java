package bookshop2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class DBManager implements AutoCloseable {

    private Connection connection;

    public DBManager() throws SQLException, NamingException {
        connect();
    }

    private void connect() throws SQLException, NamingException {
	Context initCtx = new InitialContext();
	Context envCtx = (Context) initCtx.lookup("java:comp/env");
	DataSource ds = (DataSource) envCtx.lookup("jdbc/Libros");
	connection = ds.getConnection();
    }

    /**
     * Close the connection to the database if it is still open.
     *
     */
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }

    /**
     * Return the number of units in stock of the given book.
     *
     * @param book The book object.
     * @return The number of units in stock, or 0 if the book does not
     *         exist in the database.
     * @throws SQLException If somthing fails with the DB.
     */
    public int getStock(Book book) throws SQLException {
        return getStock(book.getId());
    }

    /**
     * Return the number of units in stock of the given book.
     *
     * @param bookId The book identifier in the database.
     * @return The number of units in stock, or 0 if the book does not
     *         exist in the database.
     */
    public int getStock(int bookId) throws SQLException {
        int stock;
        try (Statement stmt = connection.createStatement()) {
            String query = "SELECT stock FROM Stock WHERE book=" + bookId;
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                stock = rs.getInt("stock");
            } else {
                stock = 0;
            }
        }
        return stock;
    }

    /**
     * Search book by ISBN.
     *
     * @param isbn The ISBN of the book.
     * @return The Book object, or null if not found.
     * @throws SQLException If somthing fails with the DB.
     */
    public Book searchBook(String isbn) throws SQLException {
        Book book;
        try (Statement stmt = connection.createStatement()) {
            String query = "SELECT id, title, isbn, year "
                           + "FROM Books WHERE isbn='" + isbn + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setIsbn(isbn);
                book.setYear(rs.getInt("year"));
            } else {
                book = null;
            }
        }
        return book;
    }

    /**
     * Sell a book.
     *
     * @param book The book.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If somthing fails with the DB.
     */
    public boolean sellBook(Book book, int units) throws SQLException {
        return sellBook(book.getId(), units);
    }

    /**
     * Sell a book.
     *
     * @param book The book's identifier.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If something fails with the DB.
     */
    public boolean sellBook(int book, int units) throws SQLException {
        boolean success = false;
        connection.setTransactionIsolation(
                               Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);
        try (Statement stmt = connection.createStatement()) {
            String query = "INSERT INTO Transactions (date, book, units) "
                           + "VALUES (NOW(), " + book + ", " + units + ")";
            stmt.executeUpdate(query);
            query = "UPDATE Stock SET stock = stock - " + units +
                    " WHERE book=" + book + " AND stock >= " + units;
            int numRows = stmt.executeUpdate(query);
            if (numRows > 0) {
                success = true;
            }
        } finally {
            if (success) {
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.setAutoCommit(true);
        }
        return success;
    }

    /**
     * Return a list with all the books in the database.
     *
     * @return List with all the books.
     * @throws SQLException If something fails with the DB.
     */
    public List<Book> listBooks() throws SQLException {
        List<Book> books = new ArrayList<Book>();
        try (Statement stmt = connection.createStatement()) {
            String query = "SELECT id, title, isbn, year FROM Books";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getString("isbn"));
                book.setYear(rs.getInt("year"));
                books.add(book);
            }
        }
        return books;
    }
}
