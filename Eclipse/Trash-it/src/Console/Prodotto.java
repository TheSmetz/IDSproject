package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Prodotto implements GestoreProdotto{
	
	//attributi
	private String codiceABarreProdotto; //id
	private String nomeProdotto;
	
	//componenti da convertire
	private String primoComponente;
	private String secondoComponente;
	private String terzoComponente;
	private String quartoComponente;
	
	//componenti finali
	ArrayList<Materiale> componenti=new ArrayList<Materiale>(); //Gestisce uno o piu componenti di un prodotto
		
	private byte[] imgProdotto;
	private int puntiProdotto;
	
	private boolean presenza;
	
	public void setComponenti(Materiale m) {
		if(!componenti.contains(m))
		componenti.add(m);
	}
	
	public String getCodiceABarreProdotto() {
		return codiceABarreProdotto;
	}
	
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	
	//provvisori
	public String getPrimoComponente() {
		return primoComponente;
	}

	public String getSecondoComponente() {
		return secondoComponente;
	}

	public String getTerzoComponente() {
		return terzoComponente;
	}

	public String getQuartoComponente() {
		return quartoComponente;
	}
	
	public int getPuntiProdotto() {
		return puntiProdotto;
	}

	public void setPuntiProdotto(int puntiProdotto) {
		this.puntiProdotto = puntiProdotto;
	}

	public byte[] getImgProdotto() {
		return imgProdotto;
	}

	public Prodotto (String codice) {
		this.codiceABarreProdotto = codice;
	}
	

	@Override
	public void creaConnessione() {
		
		String host = "jdbc:mysql://localhost:3306/dbtrash-it";
		String username = "root";
		String password = "";
		
		try {
			Connection dbCon = DriverManager.getConnection(host, username, password);	//connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query = "SELECT * FROM prodotto WHERE IDProdotto = " + codiceABarreProdotto;
			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			
			if (rsProdotto.next()) {	
				//this.codiceABarre = rsProdotto.getString("barcode");
				this.nomeProdotto = rsProdotto.getString("Nome");
				this.primoComponente = rsProdotto.getString("PrimoComponente");
				this.secondoComponente = rsProdotto.getString("SecondoComponente");
				this.terzoComponente = rsProdotto.getString("TerzoComponente");
				this.quartoComponente = rsProdotto.getString("QuartoComponente");
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
				"\nPrimo: " + this.primoComponente +
				"\nSecondo: " + this.secondoComponente +
				"\nTerzo: " + this.terzoComponente +
				"\nQuarto: " + this.quartoComponente +
				"\nImmagine: " + this.imgProdotto +
				"\nPunti: " + this.puntiProdotto);
	}
	
	public void stampaComponenti() {
		System.out.println(this.codiceABarreProdotto + " " + this.componenti);
	}
	
	@Override
	public String scansioneCodiceABarreProdotto() {
		return null;
	}
	
	
	public static void main(String[] args) {
		Prodotto p = new Prodotto("123456");
		p.creaConnessione();		
		p.getDatiProdotto();
		
		p.setComponenti(Materiale.Carta);	
		p.stampaComponenti();
	}	

}
