package ids.unicam.trashit.database;

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
	
	private ResultSet rsQuery;
	private int rsUpdate;
	
	private Connection dbCon;
	private Statement stmtProdotto;	
	
	public ResultSet getRsQuery() {
		return rsQuery;
	}

	public void setRsQuery(ResultSet rsQuery) {
		this.rsQuery = rsQuery;
	}

	public int getRsUpdate() {
		return rsUpdate;
	}

	public void setRsUpdate(int rsUpdate) {
		this.rsUpdate = rsUpdate;
	}

	public Statement getStmtProdotto() {
		return stmtProdotto;
	}

	public void setStmtProdotto(Statement stmtProdotto) {
		this.stmtProdotto = stmtProdotto;
	}

	public CreateConnection() {
		
		this.host = "jdbc:mysql://localhost:3306/dbtrash-it";
		this.username = "root";
		this.password = "";			
	}	
	
	public void executeQuery(String query) {
		
		try {
			dbCon = DriverManager.getConnection(host, username, password);	//connessione
			
			stmtProdotto = dbCon.createStatement();
			rsQuery = stmtProdotto.executeQuery(query);
			
		} catch (SQLException e) {
			System.out.println("\nIMPOSSIBILE CONNETTERSI AL DATABASE \n");
			e.printStackTrace();
		}
	}	
	
	public void executeUpdate(String query) {
		
		try {
			dbCon = DriverManager.getConnection(host, username, password);	//connessione
			
			stmtProdotto = dbCon.createStatement();
			rsUpdate = stmtProdotto.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public static void main(String[] args) throws SQLException {
		
//		CreateConnection trash = new CreateConnection("dbtrash-it", "SELECT * FROM tessera");
//		
//		String cf;
//		
//		while (trash.rsQuery.next()) {	
//			cf = trash.rsQuery.getString("IDtessera");
//			System.out.println(cf);
//		}		
	}

}
