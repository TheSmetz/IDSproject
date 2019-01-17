package Console;

import dbConnection.CreateConnection;

public class AggiuntaDB {
	private CreateConnection tConnection = new CreateConnection();
	private String queryAggiuntaTessera;
	private String queryAggiuntaProdotto;
	
	public void registrazioneTessera(String CF,String nomeTessera,String cognome,String nascita) {
		queryAggiuntaTessera = "INSERT INTO tessera (IDtessera,nome,cognome,nascita,punti) "
				+ "VALUES ('"+CF+"','"+nomeTessera+"','"+cognome+"','"+nascita+"',0)";
		tConnection.executeUpdate(queryAggiuntaTessera);
		System.out.println("tessera aggiunta correttamente");
	}
	public void aggiungiProdotto(String IDprodotto,String nomeProdotto,int punti,byte[] img) {
		queryAggiuntaProdotto = "INSERT INTO prodotto (IDprodotto,nome,punti,immagine) "
				+ "VALUES ('"+IDprodotto+"','"+nomeProdotto+"','"+punti+"','"+img+"')";
		tConnection.executeUpdate(queryAggiuntaProdotto);
		System.out.println("prodotto aggiunto correttamente");
	}
	
	
}
