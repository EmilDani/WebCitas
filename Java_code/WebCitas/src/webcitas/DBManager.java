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
    	
    	System.out.println("\n\t[DBManager]:\n");
    	
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
	try(PreparedStatement stmt = connection.prepareStatement("SELECT Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Usuario INNER JOIN Gustos ON Usuario.id=Gustos.idUsuario")){
		// String query = "";
		ResultSet rs = stmt.executeQuery();
		User nodo;
		while (rs.next()){
			
			nodo = new User();
			
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
		System.out.println("\tusuarios Length: "+usuarios.size());
		if(usuarios.size()==0)
			usuarios=null;
	    }
        return usuarios;
    }
    
    public List<User> listRecommendedUsers(User usuario) throws SQLException {
        // TODO: program this method DONE
	List<User> usuarios = new ArrayList<User>();
	try(PreparedStatement stmt = connection.prepareStatement("SELECT Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Usuario INNER JOIN Gustos ON Usuario.id=Gustos.idUsuario WHERE Gustos.sexo=? AND Gustos.yearMax<? AND Gustos.yearMin>? AND ?=Usuario.sexo AND ?<Usuario.year AND ?>Usuario.year AND Usuario.id<>? ORDER BY RAND() LIMIT 5")){
		stmt.setString(1, usuario.getSex().toString());
		stmt.setDate(2, usuario.getYear());
		stmt.setDate(3, usuario.getYear());
		stmt.setString(4, usuario.getDesired_sex().toString());
		stmt.setDate(5, usuario.getDesired_year_max());
		stmt.setDate(6, usuario.getDesired_year_min());
		stmt.setInt(7, usuario.getId());
		System.out.println("\t"+stmt);
		ResultSet rs = stmt.executeQuery();
		User nodo;
		while (rs.next()){
			
			nodo = new User();
			
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
			
		    System.out.println("\t"+nodo.getNickname());
		    
		    if(!usuarios.add(nodo)){
		    	throw new SQLException();
		    }
		}
//		System.out.println("\tNombre del primer usuario: "+usuarios.get(0).getNickname());
//		System.out.println("\tNombre del segundo usuario: "+usuarios.get(1).getNickname());
		System.out.println("\tusuarios Length: "+usuarios.size());
		if(usuarios.size()==0)
			usuarios=null;
	    }
        return usuarios;
    }
  
    public DinnerDate idToDinnerDate (int id)  throws SQLException {
    	DinnerDate cita;
    	try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Citas INNER JOIN Usuario AS P ON P.id=Citas.idProp INNER JOIN Usuario AS R ON R.id=Citas.idRec INNER JOIN Gustos AS GP ON GP.idUsuario=P.id INNER JOIN Gustos AS GR ON GR.idUsuario=R.id WHERE idCita=?")){
    		
    		stmt.setInt(1, id);
    		ResultSet rs = stmt.executeQuery();
    		
    		if (rs.next()){
    			cita = new DinnerDate();
        		int idProp = rs.getInt("idProp");
        		int idRec = rs.getInt("idRec");
        		
        		User receiver = new User();
        		
        		String receiver_nickname = rs.getString("R.nombre");
    			Date receiver_year = rs.getDate("R.year");
    			String receiver_sexo = rs.getString("R.sexo");
    			String receiver_text = rs.getString("R.texto");
    			String receiver_desired_sex = rs.getString("GR.sexo");
    			Date receiver_yearMx = rs.getDate("GR.yearMax");
    			Date receiver_yearMn = rs.getDate("GR.yearMin");
    			String receiver_nickuser = rs.getString("R.nickUser");
    			String receiver_pass = rs.getString("R.pass");


    			receiver.setNickname(receiver_nickname);
    			receiver.setYear(receiver_year);
    			receiver.setSex(sex.valueOf(receiver_sexo));
    			receiver.setDtext(receiver_text);
    			receiver.setDesired_sex(sex.valueOf(receiver_desired_sex));
    			receiver.setDesired_year_max(receiver_yearMx);
    			receiver.setDesired_year_min(receiver_yearMn);
    			receiver.setId(idRec);
    			receiver.setNickuser(receiver_nickuser);
    			receiver.setPass(receiver_pass);

        		
        		User proposer = new User();
        		
        		String proposer_nickname = rs.getString("P.nombre");
    			Date proposer_year = rs.getDate("P.year");
    			String proposer_sexo = rs.getString("P.sexo");
    			String proposer_text = rs.getString("P.texto");
    			String proposer_desired_sex = rs.getString("GP.sexo");
    			Date proposer_yearMx = rs.getDate("GP.yearMax");
    			Date proposer_yearMn = rs.getDate("GP.yearMin");
    			String proposer_nickuser = rs.getString("P.nickUser");
    			String proposer_pass = rs.getString("P.pass");


    			proposer.setNickname(proposer_nickname);
    			proposer.setYear(proposer_year);
    			proposer.setSex(sex.valueOf(proposer_sexo));
    			proposer.setDtext(proposer_text);
    			proposer.setDesired_sex(sex.valueOf(proposer_desired_sex));
    			proposer.setDesired_year_max(proposer_yearMx);
    			proposer.setDesired_year_min(proposer_yearMn);
    			proposer.setId(idProp);
    			proposer.setNickuser(proposer_nickuser);
    			proposer.setPass(proposer_pass);

        		
        		String state = rs.getString("EstadoProp");
        		Date proposal_sello = rs.getDate("FechaProp");
        		Date response_sello = rs.getDate("FechaResp");
        		Date fecha = rs.getDate("fecha");
        		
        		cita.setState(meetState.valueOf(state));
        		cita.setProposer(proposer);
        		cita.setReceiver(receiver);
        		cita.setProposal_sello(proposal_sello);
        		cita.setResponse_sello(response_sello);
        		cita.setFecha(fecha);
        		cita.setId(id);
        		
    		} else {
    			cita = null;
    		}
    		
    		
    	}
    	return cita;
    	
    }
 
    public List<DinnerDate> listDatesPropOf(User user) throws SQLException {
    	
    	List<DinnerDate> citas; // Mejor no inicializar hasta estar seguro de que funciona
    	try(PreparedStatement stmt = connection.prepareStatement("SELECT idCita, EstadoProp, FechaProp, FechaResp, fecha, Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Usuario.texto, Usuario.nickUser, Usuario.pass, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Citas INNER JOIN Usuario INNER JOIN Gustos ON Usuario.id=idRec AND Usuario.id=Gustos.idUsuario WHERE idProp=?")){
    		// String query = "SELECT idCita, EstadoProp, FechaProp, FechaResp, fecha, Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Usuario.texto, Gustos.sexo, Gustos.yearMax, Gustos.yearMin FROM Citas INNER JOIN Usuario INNER JOIN Gustos ON Usuario.id=idRec AND Usuario.id=Gustos.idUsuario WHERE idProp='"+user.getId()+"'";
    		stmt.setInt(1, user.getId());
    		ResultSet rs = stmt.executeQuery();
    		citas = new ArrayList<DinnerDate>();
    		DinnerDate nodo;
    		User receiver;
    		while (rs.next()){
    			
    			nodo = new DinnerDate();
    			receiver = new User();
    			
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
    		System.out.println("\tcitas Length: "+citas.size());
    		if(citas.size()==0)
    			citas=null;
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
    		DinnerDate nodo;
    		User proposer;
    		while (rs.next()){
    			
    			nodo = new DinnerDate();
    			proposer = new User();
    			
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
    		System.out.println("\tcitas Length: "+citas.size());
    		if(citas.size()==0)
    			citas=null;
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
    	
    	try (PreparedStatement stmt = connection.prepareStatement("UPDATE Citas SET EstadoProp = ?, FechaResp = NOW() WHERE idCita = ?")) {
    		
    		// int changes = stmt.executeUpdate("UPDATE Citas SET EstadoProp="+date.getState().toString()+" WHERE idProp="+date.getId());
    		stmt.setString(1, date.getState().toString());
    		stmt.setInt(2, date.getId());
    		System.out.println(stmt.toString());
    		int changes = stmt.executeUpdate();
    		if (changes > 0)
    			achieved = true;
    		System.out.println(achieved);
    		
    	} finally {
    		if (achieved)
    			connection.commit();
    		else
    			connection.rollback();
    		
    	}
    	
    	connection.setAutoCommit(true);
    	
    	return achieved;
    }
    
    public boolean gustar(Like like) throws SQLException {

    	boolean achieved = false;

    	connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
    	connection.setAutoCommit(false);

    	try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO MeGusta (idPropMG, idRecMG, heart) VALUES (?, ?, '1')")) {

    		// int changes = stmt.executeUpdate("UPDATE Citas SET EstadoProp="+date.getState().toString()+" WHERE idProp="+date.getId());
    		stmt.setInt(1, like.getPropMG().getId());
    		stmt.setInt(2, like.getRecMG().getId());
    		stmt.executeUpdate();
    		System.out.println(stmt.toString());
    	} finally {

    		connection.commit();
    		achieved = true;

    	}
    	connection.setAutoCommit(true);

    	return achieved;

    }
    
  /*  public boolean toggleGustar(Like like) throws SQLException {

    	boolean achieved = false;
    	
    	

    	connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
    	connection.setAutoCommit(false);

    	try (PreparedStatement stmt = connection.prepareStatement("UPDATE MeGusta SET heart = ? WHERE idPropMG = ? AND idRecMG = ?")) {

    		// int changes = stmt.executeUpdate("UPDATE Citas SET EstadoProp="+date.getState().toString()+" WHERE idProp="+date.getId());
    		if(like.isHeart())
    			stmt.setString(1, "1");
    		else
    			stmt.setString(1, "0");
    		stmt.setInt(2, like.getPropMG().getId());
    		stmt.setInt(3, like.getRecMG().getId());
    		int changes = stmt.executeUpdate();
    		System.out.println(stmt.toString());
    	} finally {

    		connection.commit();
    		achieved = true;

    	}
    	connection.setAutoCommit(true);

    	return achieved;

    }*/
    
    public Like searchLike(Like like) throws SQLException {
    	
    	Like mg = new Like();
    	
    	try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MeGusta WHERE idRecMG=? AND idPropMG=?")) {
    		stmt.setInt(1, like.getRecMG().getId());
    		stmt.setInt(2, like.getPropMG().getId());
    		System.out.println("\t"+stmt);
    		ResultSet rs = stmt.executeQuery();
    		if(rs.next()){
    			
    			int idMG = rs.getInt("idMG");
    			int idPropMG = rs.getInt("idPropMG");
    			int idRecMG = rs.getInt("idRecMG");
    			String heart = rs.getString("heart");
    			System.out.println("\t"+heart);
    			boolean love=false;
    			if(heart.equals("1")) {
    				love=true;
    			}
    			
    			mg.setIdMG(idMG);
    			mg.setPropMG(searchId(idPropMG));
    			mg.setRecMG(searchId(idRecMG));
    			mg.setHeart(love);
    		} else {
//    			like.setHeart(false);
    			mg=like;
    			mg.setIdMG(0);
    		}
    	}
    	
    	return mg;
    }
    
    public List<User> amantes(User user) throws SQLException {
    	
    	List<User> usuarios = new ArrayList<User>();
    	try(PreparedStatement stmt = connection.prepareStatement("SELECT Usuario.id, Usuario.nombre, Usuario.year, Usuario.sexo, Gustos.sexo, Gustos.yearMax, Gustos.yearMin, MeGusta.idPropMG, MeGusta.heart FROM Usuario INNER JOIN Gustos ON Usuario.id=Gustos.idUsuario INNER JOIN MeGusta ON MeGusta.idPropMG = Usuario.id WHERE MeGusta.idRecMG = ? AND MeGusta.heart = '1'")){
    		stmt.setInt(1, user.getId());
    		System.out.println("\t"+stmt);
    		ResultSet rs = stmt.executeQuery();
    		User nodo;
    		while (rs.next()){
    			
    			nodo = new User();
    			
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
    			
    		    System.out.println("\t"+nodo.getNickname());
    		    
    		    if(!usuarios.add(nodo)){
    		    	throw new SQLException();
    		    }
    		}
//    		System.out.println("\tNombre del primer usuario: "+usuarios.get(0).getNickname());
//    		System.out.println("\tNombre del segundo usuario: "+usuarios.get(1).getNickname());
    		System.out.println("\tusuarios Length: "+usuarios.size());
    		if(usuarios.size()==0)
    			usuarios=null;
    	    }
            return usuarios;
    	
    	
    }
    
}
