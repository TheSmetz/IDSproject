package ids.unicam.trashit.console;

import java.sql.SQLException;
import java.util.ArrayList;

import ids.unicam.trashit.database.CreateConnection;

public class Prodotto{
	
	//attributi
	private String codiceABarre; //id
	private String nome;
	//collocazione finali
	private ArrayList<Materiale> collocazioneCestini=new ArrayList<Materiale>(); //Gestisce uno o piu componenti di un prodotto
	private ArrayList<String> arrayParti=new ArrayList<String>(); //Gestisce uno o piu parti del prodotto
	private byte[] immagine;
	private int punti;
	private boolean presenza;
	private String descrizione;
	private CreateConnection prodottoConnection = new CreateConnection();
	
	public String getDescrizione() {
		return descrizione;
	}

	protected void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	protected ArrayList<Materiale> getCollocazioneCestini() {
		return collocazioneCestini;
	}

	protected void setCollocazioneCestini(ArrayList<Materiale> collocazioneCestini) {
		this.collocazioneCestini = collocazioneCestini;
	}

	protected void setComponenti(Materiale m) {
		if(!collocazioneCestini.contains(m))
		collocazioneCestini.add(m);
	}
	
	protected ArrayList<String> getArrayParti() {
		return arrayParti;
	}

	protected void setArrayParti(ArrayList<String> arrayParti) {
		this.arrayParti = arrayParti;
	}
	
	protected int contaComponenti() {
		return collocazioneCestini.size();	
	}
	
	public String getcodiceABarre() {
		return this.codiceABarre;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getPunti() {
		return this.punti;
	}

	protected void setPunti(int punti) {
		this.punti = punti;
	}

	public byte[] getImmagine() {
		return this.immagine;
	}
	
	public boolean isPresenza() {
		return presenza;
	}

	protected void setPresenza(boolean presenza) {
		this.presenza = presenza;
	}
	
	public void getComponenti() {
		collocazioneCestini.forEach((c) -> System.out.println(c)); //Lambda expression
	}
	
	public void getDescrizioni() {
		arrayParti.forEach((p) -> System.out.println(p)); //Lambda expression
	}
	
	//costruttore
	public Prodotto(String codice) {
		this.codiceABarre = codice;
		creaConnessione();
	}	
	

	protected void creaConnessione() {
		String query = "SELECT * FROM prodotto WHERE IDProdotto = '" + this.codiceABarre + "'";		
		prodottoConnection.executeQuery(query);		
		try {
			if (prodottoConnection.getRsQuery().next()) {	
				this.codiceABarre = prodottoConnection.getRsQuery().getString("IDprodotto");
				this.nome = prodottoConnection.getRsQuery().getString("nome");
				this.immagine = prodottoConnection.getRsQuery().getBytes("immagine");
				this.punti = prodottoConnection.getRsQuery().getInt("punti");	
				this.presenza = true;
			}
		} catch (SQLException e) {
			this.presenza = false;
			e.printStackTrace();
		}					
	}
	
	protected void getDati() {
		System.out.println("--- " + this.nome + " ---"+
				 "\nCodice a barre: " + this.codiceABarre +
				"\nPunti: " + this.punti +
				"\nDescrizione: " + descrizione);
	}
	
	
	
	
}
