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
	
	private Connection dbCon;
	private Statement stmtProdotto;
	//private ResultSet rsProdotto;
	
	public CreateConnection() {
		this.host = "jdbc:mysql://localhost:3306/trash-it";
		this.username = "root";
		this.password = "";
		
		try {
			dbCon = DriverManager.getConnection(host, username, password);	//connessione
			stmtProdotto = dbCon.createStatement();
			String query = "SELECT * FROM prodotto WHERE nome = 'igieneplus'";
			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			
			
			
			//Connection con = DriverManager.getConnection(host, username, password); // connessione

			//Statement stmtProdotto = con.createStatement();
			//String SQLProdotto = "SELECT * FROM prodotto WHERE barcode = " + barcode; // "SELECT * FROM prodotto WHERE nome = 'igieneplus'"
			//ResultSet rsProdotto = stmtProdotto.executeQuery(SQLProdotto);
			
			while (rsProdotto.next()) {
				String barcode = rsProdotto.getString("barcode");
				System.out.println(barcode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public void executeQuery(String query) {
//		try {
//			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
//			
//			while (rsProdotto.next()) {
//				String barcode = rsProdotto.getString("barcode");
//				System.out.println(barcode);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//return rsProdotto;
//	}
	
	//getters & setters
		public Connection getDbCon() {
			return dbCon;
		}

		public void setDbCon(Connection dbCon) {
			this.dbCon = dbCon;
		}
	
//	public void searchDBProduct(String barcode) {
//		
//		try {
//			
//			Connection con = DriverManager.getConnection(host, username, password); // connessione
//
//			Statement stmtProdotto = con.createStatement();
//			String SQLProdotto = "SELECT * FROM prodotto WHERE barcode = " + barcode; // "SELECT * FROM prodotto WHERE nome = 'igieneplus'"
//			ResultSet rsProdotto = stmtProdotto.executeQuery(SQLProdotto);
//
//			// output
//			while (rsProdotto.next()) {
//				barcodeProdotto = rsProdotto.getString("barcode");
//				nomeProdotto = rsProdotto.getString("nome");
//				descrizioneProdotto = rsProdotto.getString("descrizione");
//				imgProdotto = rsProdotto.getBytes("immagine");
//				puntiProdotto = rsProdotto.getInt("punti");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			connectionFail = true; // se la connessione non funziona
//			System.out.println(e.getMessage());
//			System.out.println("\nFailed to Connect to Trash-it DataBase");
//
//		}
//	}

	public static void main(String[] args) {
		
		CreateConnection trash = new CreateConnection();
		
		//trash.executeQuery("SELECT barcode FROM prodotto WHERE nome = 'igieneplus'");
		
		
//		try {
//			String host = "jdbc:mysql://localhost:3306/trash-it";	//database name
//			String password = "";
//			String username = "root";
//			Connection con = DriverManager.getConnection(host, username, password);		//connessione
//
//			Statement stmtProdotto = con.createStatement();
//			Statement stmtPersona = con.createStatement();
//			
//			//query inserimento
//			//Statement stmtInserimento = con.createStatement();
//			//Statement stmtInserimento2 = con.createStatement();
//			//stmtInserimento.executeUpdate("INSERT INTO persone " + "VALUES (5, 'Cristiano', 'Zampa')");
//			//stmtInserimento2.executeUpdate("INSERT INTO prodotti " + "VALUES(505, 'Portatile, indifferenziato')");
//			
//			//query select
//			String SQLPersona = "SELECT * FROM persona";
//			String SQLProdotto = "SELECT * FROM prodotto";
//			ResultSet rsPersona = stmtProdotto.executeQuery(SQLPersona);
//			ResultSet rsProdotto = stmtPersona.executeQuery(SQLProdotto);
//			
//			//output
//			System.out.println("\n----- PRODOTTI -----\n");
//			while (rsProdotto.next()) {
//				String id_col = rsProdotto.getString("barcode");
//				String descrizione_col = rsProdotto.getString("descrizione");
//				System.out.println(id_col + " -> " + descrizione_col);
//			}
//			
//			System.out.println("\n----- PERSONE -----\n");
//			while (rsPersona.next()) {
//				String id_col = rsPersona.getString("codicefiscale");
//				String first_name = rsPersona.getString("nome");
//				String last_name = rsPersona.getString("cognome");
//				System.out.println(id_col + " -> " + first_name + " " + last_name);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
	}


	

}
