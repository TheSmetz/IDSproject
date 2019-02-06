package ids.unicam.trashit.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;

public class AggiuntaDB {
	private CreateConnection tConnection = new CreateConnection();
	private String queryAggiuntaTessera;
	private String queryAggiuntaProdotto;

	public void registrazioneTessera(String CF, String nomeTessera, String cognome, String nascita) {
		queryAggiuntaTessera = "INSERT INTO tessera (IDtessera,nome,cognome,nascita,punti) " + "VALUES ('" + CF + "','"
				+ nomeTessera + "','" + cognome + "','" + nascita + "',0)";
		tConnection.executeUpdate(queryAggiuntaTessera);
		System.out.println("tessera aggiunta correttamente");
	}

	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtrash-it", "root", "");
		} catch (Exception e) {
			System.out.println("Error Occured While Getting the Connection: - " + e);
		}
		return connection;
	}

	public void aggiungiProdotto(String IDprodotto, String nomeProdotto, int punti) {

		Connection connection = null;
		PreparedStatement statement = null;
		FileInputStream fis = null;

		try {
			File file = new File("src\\Gui\\images\\beanboozled.jpeg");
			fis = new FileInputStream(file);

			queryAggiuntaProdotto = "INSERT INTO prodotto (IDprodotto, nome, punti, immagine) VALUES (?,?,?,?)";

			connection = getConnection();
			statement = connection.prepareStatement(queryAggiuntaProdotto);
			statement.setString(1, IDprodotto);
			statement.setString(2, nomeProdotto);
			statement.setInt(3, punti);
			statement.setBinaryStream(4, (InputStream) fis, (int) (file.length()));
			statement.executeUpdate();
			System.out.println("prodotto aggiunto correttamente");

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: - " + e);
		} catch (SQLException e) {
			System.out.println("SQLException: - " + e);
		} finally {

			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("SQLException Finally: - " + e);

			}
		}
	}

}
