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
			String host = "jdbc:mysql://localhost:3306/trashit";	//database name
			String password = "";
			String username = "root";
			Connection con = DriverManager.getConnection(host, username, password);		//connessione

			Statement stmtProdotti = con.createStatement();
			Statement stmtPersone = con.createStatement();
			
			//query inserimento
			//Statement stmtInserimento = con.createStatement();
			//Statement stmtInserimento2 = con.createStatement();
			//stmtInserimento.executeUpdate("INSERT INTO persone " + "VALUES (5, 'Cristiano', 'Zampa')");
			//stmtInserimento2.executeUpdate("INSERT INTO prodotti " + "VALUES(505, 'Portatile, indifferenziato')");
			
			//query select
			String SQLPersone = "SELECT * FROM persone";
			String SQLProdotti = "SELECT * FROM prodotti";
			ResultSet rsPersone = stmtProdotti.executeQuery(SQLPersone);
			ResultSet rsProdotti = stmtPersone.executeQuery(SQLProdotti);
			
			//output
			System.out.println("\n----- PRODOTTI -----\n");
			while (rsProdotti.next()) {
				int id_col = rsProdotti.getInt("codiceABarre");
				String descrizione_col = rsProdotti.getString("descrizione");
				System.out.println(id_col + " " + descrizione_col);
			}
			
			System.out.println("\n----- PERSONE -----\n");
			while (rsPersone.next()) {
				int id_col = rsPersone.getInt("id");
				String first_name = rsPersone.getString("nome");
				String last_name = rsPersone.getString("cognome");
				System.out.println(id_col + " " + first_name + " " + last_name);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
