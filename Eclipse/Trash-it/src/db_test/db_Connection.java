package db_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class db_Connection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String host = "jdbc:mysql://localhost:3306/trash-it";	//database name
			String password = "";
			String username = "root";
			Connection con = DriverManager.getConnection(host, username, password);		//connessione

			Statement stmtProdotto = con.createStatement();
			Statement stmtPersona = con.createStatement();
			
			//query inserimento
			//Statement stmtInserimento = con.createStatement();
			//Statement stmtInserimento2 = con.createStatement();
			//stmtInserimento.executeUpdate("INSERT INTO persone " + "VALUES (5, 'Cristiano', 'Zampa')");
			//stmtInserimento2.executeUpdate("INSERT INTO prodotti " + "VALUES(505, 'Portatile, indifferenziato')");
			
			//query select
			String SQLPersona = "SELECT * FROM persona";
			String SQLProdotto = "SELECT * FROM prodotto";
			ResultSet rsPersona = stmtProdotto.executeQuery(SQLPersona);
			ResultSet rsProdotto = stmtPersona.executeQuery(SQLProdotto);
			
			//output
			System.out.println("\n----- PRODOTTI -----\n");
			while (rsProdotto.next()) {
				String id_col = rsProdotto.getString("barcode");
				String descrizione_col = rsProdotto.getString("descrizione");
				System.out.println(id_col + " -> " + descrizione_col);
			}
			
			System.out.println("\n----- PERSONE -----\n");
			while (rsPersona.next()) {
				String id_col = rsPersona.getString("codicefiscale");
				String first_name = rsPersona.getString("nome");
				String last_name = rsPersona.getString("cognome");
				System.out.println(id_col + " -> " + first_name + " " + last_name);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
