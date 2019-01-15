package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CreateConnection {
	
	//attributi
	private String host;
	private String username;
	private String password;
	
	private String nomeDatabase;
	private String queryDatabase;
	private ResultSet rsQuery;
	
	private Connection dbCon;
	private Statement stmtProdotto;
	
	public CreateConnection(String nomeDB, String queryDB) {
		
		this.nomeDatabase = nomeDB;
		this.queryDatabase = queryDB;
		
		this.host = "jdbc:mysql://localhost:3306/"+this.nomeDatabase;
		this.username = "root";
		this.password = "";		
		
		executeQuery(this.nomeDatabase, this.queryDatabase);
	}
	
	public void executeQuery(String nome, String query) {
		
		try {
			dbCon = DriverManager.getConnection(host, username, password);	//connessione
			
			stmtProdotto = dbCon.createStatement();
			rsQuery = stmtProdotto.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) throws SQLException {
		
		CreateConnection trash = new CreateConnection("dbtrash-it", "SELECT * FROM tessera");
		
		String cf;
		
		while (trash.rsQuery.next()) {	
			cf = trash.rsQuery.getString("IDtessera");
			System.out.println(cf);
		}		
	}

}
