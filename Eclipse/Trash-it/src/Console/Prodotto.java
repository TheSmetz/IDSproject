package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dbConnection.CreateConnection;

public class Prodotto implements GestoreProdotto{
	
	//attributi
	private String codiceABarre; //id
	private String nome;
	//collocazione finali
	ArrayList<Materiale> collocazioneCestini=new ArrayList<Materiale>(); //Gestisce uno o piu componenti di un prodotto
	ArrayList<String> arrayParti=new ArrayList<String>(); //Gestisce uno o piu parti del prodotto
	private byte[] img;
	private int punti;
	private boolean presenza;
	
	
	public void setComponenti(Materiale m) {
		if(!collocazioneCestini.contains(m))
		collocazioneCestini.add(m);
	}
	
	public ArrayList<String> getArrayParti() {
		return arrayParti;
	}

	public void setArrayParti(ArrayList<String> arrayParti) {
		this.arrayParti = arrayParti;
	}
	
	public int contaComponenti() {
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

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public byte[] getImg() {
		return this.img;
	}
	
	@Override
	public boolean verificaPresenza() {
		return this.presenza;
	}
	
	@Override
	public void getDati() {
		System.out.println("--- " + this.nome + " ---"+
				 "\nCodice a barre: " + this.codiceABarre +
				"\nPunti: " + this.punti);
	}
	
	public void getComponenti() {
		collocazioneCestini.forEach((c) -> System.out.println(c)); //Lambda expression
	}
	
	public void getDescrizioni() {
		arrayParti.forEach((p) -> System.out.println(p)); //Lambda expression
	}	
	
	public Prodotto(String codice) {
		this.codiceABarre = codice;
	}
	
	@Override
	public void creaConnessione() {

		String query = "SELECT * FROM prodotto WHERE IDProdotto = " + this.codiceABarre;		
		CreateConnection prodottoConnection = new CreateConnection("dbtrash-it", query);		
		try {
			if (prodottoConnection.getRsQuery().next()) {	
				this.codiceABarre = prodottoConnection.getRsQuery().getString("IDprodotto");
				this.nome = prodottoConnection.getRsQuery().getString("nome");
				this.img = prodottoConnection.getRsQuery().getBytes("immagine");
				this.punti = prodottoConnection.getRsQuery().getInt("punti");				
				this.presenza = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}
	
	public static void main(String[] args) {
		Prodotto p = new Prodotto("8410668111116");
		p.creaConnessione();		
		p.getDati();
		//System.out.println(p.collocazioneCestini.contains(Materiale.Carta)); //CONTROLLO CHE P SIA DI CARTA
		//System.out.println(p.collocazioneCestini.contains(Materiale.Plastica));
		//System.out.println(p.contaComponenti());
		System.out.println(p.getcodiceABarre());
	}

	

}
