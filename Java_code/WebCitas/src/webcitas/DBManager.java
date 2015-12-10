package webcitas;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBManager implements AutoCloseable {

    private Connection connection;

    public DBManager() throws SQLException ,NamingException {
        connect();
    }

    private void connect() throws SQLException , NamingException {
        // TODO: program this method
    	
    	Context initCtx = new InitialContext();
    	Context envCtx = (Context) initCtx.lookup("java:comp/env");
    	DataSource ds = (DataSource) envCtx.lookup("jdbc/BaseDatos");
    	connection = ds.getConnection();
    	
    	//String url = "jdbc:mysql://mysql.lab.it.uc3m.es/16_compweb_24c";
        //connection = DriverManager.getConnection(url, "16_compweb_24","FTgv7f2B");
		    
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

    public User searchUser(String nickUser, String password) throws SQLException {
    	// TODO: program this method DONE
    	User user;
    	try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Usuario INNER JOIN Gustos ON id=idUsuario WHERE nickUser = ? AND pass = ?")){
    		
    		// String query="SELECT * FROM Usuario INNER JOIN Gustos ON id=idUsuario WHERE nickUser='"+nickUser+"' AND pass='"+password+"'";
		stmt.setString(1, nickUser);
		stmt.setString(2, password);

		ResultSet rs = stmt.executeQuery();

    		// Se podría considerar mayor complejidad comprobando que rs, efectivamente, no sea una lista si no una
    		// única fila

    		if (rs.next()){ //Tenemos que recordar que el primer valor inicial que devuelve executeQuery no es válido
    			user = new User();

    			String nickname = rs.getString("Usuario.nombre");
    			Date year = rs.getDate("Usuario.year");
    			String sexo = rs.getString("Usuario.sexo");
    			String text = rs.getString("Usuario.texto");
    			//String pic = rs.getString("Usuario.foto");
    			String desired_sex = rs.getString("Gustos.sexo");
    			Date yearMx = rs.getDate("Gustos.yearMax");
    			Date yearMn = rs.getDate("yearMin");
    			int id = rs.getInt("id");
    			String nickuser = rs.getString("nickUser");
    			String pass = rs.getString("pass");


    			user.setNickname(nickname);
    			user.setYear(year);
    			user.setSex(sex.valueOf(sexo));
    			user.setDtext(text);
    			//user.setPic(pic);
    			user.setDesired_sex(sex.valueOf(desired_sex));
    			user.setDesired_year_max(yearMx);
    			user.setDesired_year_min(yearMn);
    			user.setId(id);
    			user.setNickuser(nickuser);
    			user.setPass(pass);
    		} else {
    			user = null;
    		}
    	}
    	return user;
    }
    
    public User searchId(int id) throws SQLException {
    	// TODO: program this method DONE
    	User user;
    	try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Usuario INNER JOIN Gustos ON id=idUsuario WHERE id = ?")){
    		
    		// String query="SELECT * FROM Usuario INNER JOIN Gustos ON id=idUsuario WHERE nickUser='"+nickUser+"' AND pass='"+password+"'";
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

    		// Se podría considerar mayor complejidad comprobando que rs, efectivamente, no sea una lista si no una
    		// única fila

    		if (rs.next()){ //Tenemos que recordar que el primer valor inicial que devuelve executeQuery no es válido
    			user = new User();

    			String nickname = rs.getString("Usuario.nombre");
    			Date year = rs.getDate("Usuario.year");
    			String sexo = rs.getString("Usuario.sexo");
    			String text = rs.getString("Usuario.texto");
    			//String pic = rs.getString("Usuario.foto");
    			String desired_sex = rs.getString("Gustos.sexo");
    			Date yearMx = rs.getDate("Gustos.yearMax");
    			Date yearMn = rs.getDate("yearMin");
    			String nickuser = rs.getString("nickUser");
    			String pass = rs.getString("pass");


    			user.setNickname(nickname);
    			user.setYear(year);
    			user.setSex(sex.valueOf(sexo));
    			user.setDtext(text);
    			//user.setPic(pic);
    			user.setDesired_sex(sex.valueOf(desired_sex));
    			user.setDesired_year_max(yearMx);
    			user.setDesired_year_min(yearMn);
    			user.setId(id);
    			user.setNickuser(nickuser);
    			user.setPass(pass);
    		} else {
    			user = null;
    		}
    	}
    	return user;
    }

    public List<User> listUsers() throws SQLException {
        // TODO: program this method DONE
	List<User> usuarios = new ArrayList<User>();
	try(PreparedStatement stmt = connection.prepareStatement("")){
		// String query = "";
		ResultSet rs = stmt.executeQuery();
		User nodo = new User();
		while (rs.next()){
			
			//int id = rs.getInt("id"); Le metemos al objeto usuario la ID que genera la base de datos
			//o es inseguro?
			
		    String nickname = rs.getString("Usuario.nombre");
		    Date year = rs.getDate("Usuario.year");
		    String sexo = rs.getString("Usuario.sexo");
		    String text = rs.getString("Usuario.texto");
		    //String pic = rs.getString("Usuario.foto");
		    String desired_sex = rs.getString("Gustos.sexo");
		    Date yearMx = rs.getDate("Gustos.yearMax");
		    Date yearMn = rs.getDate("yearMin");
		    int id = rs.getInt("id");
		    String nickuser = rs.getString("nickUser");
		    String pass = rs.getString("pass");
		    
		    
		    nodo.setNickname(nickname);
		    nodo.setYear(year);
		    nodo.setSex(sex.valueOf(sexo));
		    nodo.setDtext(text);
		    //nodo.setPic(pic);
		    nodo.setDesired_sex(sex.valueOf(desired_sex));
		    nodo.setDesired_year_max(yearMx);
		    nodo.setDesired_year_min(yearMn);
		    nodo.setId(id);
		    nodo.setNickuser(nickuser);
		    nodo.setPass(pass);
			
		    if(!usuarios.add(nodo)){
		    	throw new SQLException();
		    }
		}
	    }
        return usuarios;
    }
    
    public List<User> listRecommendedUsers(User usuario) throws SQLException {
        // TODO: program this method DONE
	List<User> usuarios = new ArrayList<User>();
	try(PreparedStatement stmt = connection.prepareStatement("SELECT Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Usuario INNER JOIN Gustos ON Usuario.id=Gustos.idUsuario WHERE Gustos.sexo=? AND Gustos.yearMax<? AND Gustos.yearMin>? AND ?=Usuario.sexo AND ?<Usuario.year AND ?>Usuario.year ORDER BY RAND() LIMIT 5")){
		stmt.setString(1, usuario.getSex().toString());
		stmt.setDate(2, usuario.getYear());
		stmt.setDate(3, usuario.getYear());
		stmt.setString(4, usuario.getDesired_sex().toString());
		stmt.setDate(5, usuario.getDesired_year_max());
		stmt.setDate(6, usuario.getDesired_year_min());
		ResultSet rs = stmt.executeQuery();
		User nodo = new User();
		while (rs.next()){
			
			//int id = rs.getInt("id"); Le metemos al objeto usuario la ID que genera la base de datos
			//o es inseguro?
			
		    String nickname = rs.getString("Usuario.nombre");
		    Date year = rs.getDate("Usuario.year");
		    String sexo = rs.getString("Usuario.sexo");
		    //String pic = rs.getString("Usuario.foto");
		    String desired_sex = rs.getString("Gustos.sexo");
		    Date yearMx = rs.getDate("Gustos.yearMax");
		    Date yearMn = rs.getDate("yearMin");
		    int id = rs.getInt("id");
		    
		    
		    nodo.setNickname(nickname);
		    nodo.setYear(year);
		    nodo.setSex(sex.valueOf(sexo));
		    //nodo.setPic(pic);
		    nodo.setDesired_sex(sex.valueOf(desired_sex));
		    nodo.setDesired_year_max(yearMx);
		    nodo.setDesired_year_min(yearMn);
		    nodo.setId(id);
			
		    if(!usuarios.add(nodo)){
		    	throw new SQLException();
		    }
		}
	    }
        return usuarios;
    }
    
    public DinnerDate idToDinnerDate (int id)  throws SQLException {
    	DinnerDate cita;
    	
    	return cita;
    	
    }
    
    public List<DinnerDate> listDatesPropOf(User user) throws SQLException {
    	
    	List<DinnerDate> citas; // Mejor no inicializar hasta estar seguro de que funciona
    	try(PreparedStatement stmt = connection.prepareStatement("SELECT idCita, EstadoProp, FechaProp, FechaResp, fecha, Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Usuario.texto, Usuario.nickUser, Usuario.pass, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Citas INNER JOIN Usuario INNER JOIN Gustos ON Usuario.id=idRec AND Usuario.id=Gustos.idUsuario WHERE idProp=?")){
    		// String query = "SELECT idCita, EstadoProp, FechaProp, FechaResp, fecha, Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Usuario.texto, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Citas INNER JOIN Usuario INNER JOIN Gustos ON Usuario.id=idRec AND Usuario.id=Gustos.idUsuario WHERE idProp='"+user.getId()+"'";
    		stmt.setInt(1, user.getId());
    		ResultSet rs = stmt.executeQuery();
    		citas = new ArrayList<DinnerDate>();
    		DinnerDate nodo = new DinnerDate();
    		User receiver = new User();
    		while (rs.next()){
    			
    			String state = rs.getString("EstadoProp");
    			Date proposal_sello = rs.getDate("FechaProp");
    			Date response_sello = rs.getDate("FechaResp");
    			int id_cita = rs.getInt("idCita");
    			Date fecha = rs.getDate("fecha");
    			
    			String nickname = rs.getString("Usuario.nombre");
    		    Date year = rs.getDate("Usuario.year");
    		    String sexo = rs.getString("Usuario.sexo");
    		    String text = rs.getString("Usuario.texto");
    		    //String pic = rs.getString("Usuario.foto");
    		    String desired_sex = rs.getString("Gustos.sexo");
    		    Date yearMx = rs.getDate("Gustos.yearMax");
    		    Date yearMn = rs.getDate("Gustos.yearMin");
    		    int id = rs.getInt("Usuario.id"); 
    		    String nickuser = rs.getString("Usuario.nickUser");
    		    String pass = rs.getString("Usuario.pass");
    		    
    		    // Generamos al usuario que recibe la cita
    			
    		    receiver.setNickname(nickname);
    		    receiver.setYear(year);
    		    receiver.setSex(sex.valueOf(sexo));
    		    receiver.setDtext(text);
    		    //receiver.setPic(pic);
    		    receiver.setDesired_sex(sex.valueOf(desired_sex));
    		    receiver.setDesired_year_max(yearMx);
    		    receiver.setDesired_year_min(yearMn);
    		    receiver.setId(id);
    		    receiver.setNickuser(nickuser);
    		    receiver.setPass(pass);
    		    
    		    // Construimos la cita
    		    
    		    nodo.setState(meetState.valueOf(state));
    		    nodo.setProposer(user);
    		    nodo.setReceiver(receiver);
    		    nodo.setProposal_sello(proposal_sello);
    		    nodo.setResponse_sello(response_sello);
    		    nodo.setId(id_cita);
    		    nodo.setFecha(fecha);
    			
    		    if(!citas.add(nodo)){
    		    	throw new SQLException();
    		    }
    		}
    	}
    	
    	return citas;
    
    }
    
    public List<DinnerDate> listDatesRecOf(User user) throws SQLException {
    	
    	List<DinnerDate> citas; // Mejor no inicializar hasta estar seguro de que funciona
    	try(PreparedStatement stmt = connection.prepareStatement("SELECT idCita, EstadoProp, FechaProp, FechaResp, fecha, Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Usuario.texto, Usuario.nickUser, Usuario.pass, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Citas INNER JOIN Usuario INNER JOIN Gustos ON Usuario.id=idProp AND Usuario.id=Gustos.idUsuario WHERE idRec=?")){
    		// String query = "SELECT idCita, EstadoProp, FechaProp, FechaResp, fecha, Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Usuario.texto, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Citas INNER JOIN Usuario INNER JOIN Gustos ON Usuario.id=idProp AND Usuario.id=Gustos.idUsuario WHERE idRec='"+user.getId()+"'";
    		stmt.setInt(1, user.getId());

    		ResultSet rs = stmt.executeQuery();
    		citas = new ArrayList<DinnerDate>();
    		DinnerDate nodo = new DinnerDate();
    		User proposer = new User();
    		while (rs.next()){
    			
    			String state = rs.getString("EstadoProp");
    			Date proposal_sello = rs.getDate("FechaProp");
    			Date response_sello = rs.getDate("FechaResp");
    			int id_cita = rs.getInt("idCita");
    			Date fecha = rs.getDate("fecha");
    			
    			String nickname = rs.getString("Usuario.nombre");
    		    Date year = rs.getDate("Usuario.year");
    		    String sexo = rs.getString("Usuario.sexo");
    		    String text = rs.getString("Usuario.texto");
    		    //String pic = rs.getString("Usuario.foto");
    		    String desired_sex = rs.getString("Gustos.sexo");
    		    Date yearMx = rs.getDate("Gustos.yearMax");
    		    Date yearMn = rs.getDate("Gustos.yearMin");
    		    int id = rs.getInt("Usuario.id");
    		    String nickuser = rs.getString("Usuario.nickUser");
    		    String pass = rs.getString("Usuario.pass");
    		    
    		    // Generamos al usuario que propone la cita
    			
    		    proposer.setNickname(nickname);
    		    proposer.setYear(year);
    		    proposer.setSex(sex.valueOf(sexo));
    		    proposer.setDtext(text);
    		    //proposer.setPic(pic);
    		    proposer.setDesired_sex(sex.valueOf(desired_sex));
    		    proposer.setDesired_year_max(yearMx);
    		    proposer.setDesired_year_min(yearMn);
    		    proposer.setId(id);
    		    proposer.setNickuser(nickuser);
    		    proposer.setPass(pass);
    		    
    		    // Construimos la cita
    		    
    		    nodo.setState(meetState.valueOf(state));
    		    nodo.setProposer(proposer);
    		    nodo.setReceiver(user);
    		    nodo.setProposal_sello(proposal_sello);
    		    nodo.setResponse_sello(response_sello);
    		    nodo.setId(id_cita);
    		    nodo.setFecha(fecha);
    			
    		    if(!citas.add(nodo)){
    		    	throw new SQLException();
    		    }
    		}
    	}
    	
    	return citas;
    
    }
    
    
    public boolean setDate(DinnerDate date) throws SQLException {
    	boolean achieved = false;
    	connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
    	connection.setAutoCommit(false);
//    	try (PreparedStatement stmt = connection.prepareStatement()){
//    		stmt.executeUpdate("INSERT INTO Citas (idProp, idRec, FechaProp) VALUES ("+date.getProposer().getId()+", "+date.getReceiver().getId()+", NOW())");	
//    	 
    	try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO Citas (idProp, idRec, FechaProp, fecha) VALUES (?, ?, NOW(), ?)")){
    		stmt.setInt(1, date.getProposer().getId());
    		stmt.setInt(2, date.getReceiver().getId());
    		stmt.setDate(3, date.getFecha());
    		stmt.executeUpdate();
    	} finally {
    		
    		connection.commit();
    		achieved = true;
    		
    	}
    	connection.setAutoCommit(true);
    	
    	return achieved;
    	
    }

    public boolean answerDate(DinnerDate date) throws SQLException{
    	boolean achieved = false;
    	
    	connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
    	connection.setAutoCommit(false);
    	
    	try (PreparedStatement stmt = connection.prepareStatement("UPDATE Citas SET EstadoProp = ?, FechaResp = NOW() WHERE idProp = ?")) {
    		
    		// int changes = stmt.executeUpdate("UPDATE Citas SET EstadoProp="+date.getState().toString()+" WHERE idProp="+date.getId());
    		stmt.setString(1, date.getState().toString());
    		stmt.setInt(2, date.getId());
    		int changes = stmt.executeUpdate();
    		if (changes > 0)
    			achieved = true;
    		
    	} finally {
    		if (achieved)
    			connection.commit();
    		else
    			connection.rollback();
    		
    	}
    	
    	connection.setAutoCommit(true);
    	
    	return achieved;
    }
    
}
