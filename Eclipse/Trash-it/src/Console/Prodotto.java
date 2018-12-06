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
	
	
	//costruttore
	public Prodotto(String codiceABarre) {
		this.codiceABarreProdotto = codiceABarre;
		//this.nomeProdotto = nomeProdotto;
		//this.descrizioneProdotto = descrizione;
		//this.materialeCarta = materialeCarta;
		//this.materialePlastica = materialePlastica;
		//this.materialeVetro = materialeVetro;
		//this.materialeIndifferenziato = materialeIndifferenziato;
	}
	
	// costruttore

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
	public void creaConnessione() {
		
		String host = "jdbc:mysql://localhost:3306/trash-it";
		String username = "root";
		String password = "";
		
		try {
			Connection dbCon = DriverManager.getConnection(host, username, password);	//connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query = "SELECT * FROM prodotto WHERE barcode = " + codiceABarreProdotto;
			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			
			//System.out.println(rsProdotto.next());
			
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
	public boolean verificaPresenza(String codiceABarre) {
		return this.presenza;
	}

	@Override
	public void getDatiProdotto() {
		System.out.println(this.codiceABarreProdotto);
		System.out.println(this.nomeProdotto);
		System.out.println(this.descrizioneProdotto);
		System.out.println(this.materialeCarta);
		System.out.println(this.materialePlastica);
		System.out.println(this.materialeVetro);
		System.out.println(this.materialeIndifferenziato);
		//System.out.println(this.imgProdotto);
		System.out.println(this.puntiProdotto);				
		System.out.println(this.presenza);
	}

	@Override
	public String scansioneCodiceABarreProdotto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		Prodotto igieneplus = new Prodotto("8029241107035");
		igieneplus.creaConnessione();
		igieneplus.getDatiProdotto();
		
	}
	
}
