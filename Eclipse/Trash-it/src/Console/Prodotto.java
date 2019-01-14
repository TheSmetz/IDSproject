package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prodotto implements GestoreProdotto{
	
	//attributi
	private String nomeProdotto;
	private String codiceABarreProdotto;
	private String  descrizioneProdotto;
	private boolean carta;
	private boolean plastica;
	private boolean vetro;
	private boolean indifferenziato;
	private byte[] imgProdotto;
	private int puntiProdotto;
	private boolean presenza;
	
	
	public String getNome() {
		return nomeProdotto;
	}
	public boolean isCarta() {
		return carta;
	}
	public boolean isPlastica() {
		return plastica;
	}
	public boolean isVetro() {
		return vetro;
	}
	public boolean isIndifferenziato() {
		return indifferenziato;
	}
	
	public Prodotto (String codice) {
		this.codiceABarreProdotto = codice;
	}
	

	@Override
	public void creaConnessione() {
		
		String host = "jdbc:mysql://localhost:3306/trash-it";
		String username = "root";
		String password = "";
		
		try {
			Connection dbCon = DriverManager.getConnection(host, username, password);	//connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query = "SELECT * FROM prodotto WHERE barcode = " + codiceABarreProdotto;
			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			
			if (rsProdotto.next()) {	
				//this.codiceABarre = rsProdotto.getString("barcode");
				this.nomeProdotto = rsProdotto.getString("nome");
				this.descrizioneProdotto = rsProdotto.getString("descrizione");
				this.carta = rsProdotto.getBoolean("carta");
				this.plastica = rsProdotto.getBoolean("plastica");
				this.vetro = rsProdotto.getBoolean("vetro");
				this.indifferenziato = rsProdotto.getBoolean("indifferenziato");
				this.imgProdotto = rsProdotto.getBytes("immagine");
				this.puntiProdotto = rsProdotto.getInt("punti");				
				this.presenza = true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean verificaPresenza() {
		return this.presenza;
	}
	@Override
	public void getDatiProdotto() {
		System.out.println("--- " + this.nomeProdotto + " ---"+
				 "\nCodice a barre: " + this.codiceABarreProdotto +
				"\nDescrizione: " + this.descrizioneProdotto +
				"\nCarta: " + this.carta +
				"\nPlastica: " + this.plastica +
				"\nVetro: " + this.vetro +
				"\nIndifferenziato: " + this.indifferenziato +
				"\nImmagine: " + this.imgProdotto +
				"\nPunti: " + this.puntiProdotto);
	}
	@Override
	public String scansioneCodiceABarreProdotto() {
		return null;
	}
	
	
	public static void main(String[] args) {
		Prodotto p = new Prodotto("4006381115575");
		p.creaConnessione();		
		p.getDatiProdotto();		
	}	

}
