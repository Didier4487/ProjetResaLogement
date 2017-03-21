package fr.resaLogement.bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBDD {
	
	String url = "jdbc:mysql://localhost:3306/bddresalogement"; 
	String login ="root";
	String password = "";
	
	protected Connection conec;
	protected Statement stmt; 

	public Statement seConnecter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conec = DriverManager.getConnection(url, login, password);			
			stmt = conec.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stmt;
	}
}

