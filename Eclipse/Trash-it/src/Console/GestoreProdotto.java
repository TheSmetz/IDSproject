package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbConnection.db_Connection;

public class GestoreProdotto implements db_Connection{
	
	//attributi
//	private String host;
//	private String username;
//	private String password;
	
	private Connection dbCon;
	private Statement stmtProdotto;
	private ResultSet rsProdotto;
	
	public void CreateConnection(String barcode) {
		
		String host = "jdbc:mysql://localhost:3306/trash-it";
		String username = "root";
		String password = "";
		
		try {
			Connection dbCon = DriverManager.getConnection(host, username, password);	//connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query = "SELECT * FROM prodotto WHERE barcode = " + barcode;
			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			
			while (rsProdotto.next()) {
				String barcodee = rsProdotto.getString("barcode");
				System.out.println(barcodee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  void executeQuery(String query) {
		
		try {
			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			
			while (rsProdotto.next()) {
				String barcode = rsProdotto.getString("barcode");
				System.out.println(barcode);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return rsProdotto;
	}
	
	//public boolean verificaPresenza(String codiceABarre);
	
	//public void getDatiProdotto(String codiceABarre);
	
	//public String scansioneCodiceABarreProdotto();	

}
