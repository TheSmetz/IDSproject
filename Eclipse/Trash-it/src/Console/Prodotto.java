package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		
		String host = "jdbc:mysql://localhost:3306/dbtrash-it";
		String username = "root";
		String password = "";
		
		try {
			Connection dbCon = DriverManager.getConnection(host, username, password);	//connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query = "SELECT * FROM prodotto WHERE IDProdotto = " + codiceABarre;
			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			
			if (rsProdotto.next()) {	
				this.codiceABarre = rsProdotto.getString("IDprodotto");
				this.nome = rsProdotto.getString("nome");
				this.img = rsProdotto.getBytes("immagine");
				this.punti = rsProdotto.getInt("punti");				
				this.presenza = true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
//	public static void main(String[] args) {
//		Prodotto p = new Prodotto("8410668111116");
//		p.creaConnessione();		
//		p.getDati();
//		p.setComponenti(Materiale.Indifferenziato);
//		p.setComponenti(Materiale.Carta);	
//		p.setComponenti(Materiale.Plastica);
//		p.stampaComponenti();
//		//System.out.println(p.collocazioneCestini.contains(Materiale.Carta)); //CONTROLLO CHE P SIA DI CARTA
//		//System.out.println(p.collocazioneCestini.contains(Materiale.Plastica));
//		//System.out.println(p.contaComponenti());
//		System.out.println(p.getcodiceABarre());
//		System.exit(0);
//	}

	

}
