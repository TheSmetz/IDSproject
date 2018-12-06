package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Prodotto implements GestoreProdotto{
	
	//attributi
	private String codiceABarreProdotto;
	private String nomeProdotto;
	private String descrizioneProdotto;
	private boolean presenza = false;
	private boolean materialeCarta = false;
	private boolean materialePlastica = false;
	private boolean materialeVetro = false;
	private boolean materialeIndifferenziato = false;
	private byte[] imgProdotto;
	private int puntiProdotto;
	
	
	//costruttore, in input solo il codice a barre (scansione)
	public Prodotto(String codiceABarre) {
		this.codiceABarreProdotto = codiceABarre;
	}
	

	public void getCodiceABarre() {
		// return this.codiceABarre;
		System.out.println(this.codiceABarreProdotto);
	}
	
	public void getNomeProdotto() {
		// return nomeProdotto
		System.out.println(this.nomeProdotto);
	}

	public void getDescrizione() {
		// return descrizione;
		System.out.println(this.descrizioneProdotto);
	}

	@Override
	//imposto gli altri attibuti con i dati ottenuti dal database
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
				this.materialeCarta = rsProdotto.getBoolean("carta");
				this.materialePlastica = rsProdotto.getBoolean("plastica");
				this.materialeVetro = rsProdotto.getBoolean("vetro");
				this.materialeIndifferenziato = rsProdotto.getBoolean("indifferenziato");
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
		"\nCarta: " + this.materialeCarta +
		"\nPlastica: " + this.materialePlastica +
		"\nVetro: " + this.materialeVetro +
		"\nIndifferenziato: " + this.materialeIndifferenziato +
		"\nImmagine: " + this.imgProdotto +
		"\nPunti: " + this.puntiProdotto);
	}

	@Override
	public String scansioneCodiceABarreProdotto() {
		return null;
	}
	
	public static void main(String[] args) {
		
		//test
		Prodotto igieneplus = new Prodotto("8029241107035");
		igieneplus.creaConnessione();
		igieneplus.getDatiProdotto();
		System.out.println("\nPresenza: " + igieneplus.verificaPresenza());		
	}
	
}
