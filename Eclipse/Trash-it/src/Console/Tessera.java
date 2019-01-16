package Console;

import java.io.IOException;
import java.util.Date;

import dbConnection.CreateConnection;

public class Tessera implements GestoreTessera {
	private String idtessera;
	private String nome;
	private String cognome;
	private Date nascita;
	private int punti;	
	
	private CreateConnection tesseraConnection = new CreateConnection();
	
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public String getIdTessera() {
		return idtessera;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public Date getNascita() {
		return nascita;
	}
	
	public Tessera (String tessera) {
		this.idtessera = tessera;
	}
	
	public void connessioneDB() {
		String query = "SELECT * FROM tessera WHERE IDtessera = '" + this.idtessera + "'";
		tesseraConnection.executeQuery(query);
		
		try {
			if (tesseraConnection.getRsQuery().next()) {
				this.nome = tesseraConnection.getRsQuery().getString("nome");
				this.cognome = tesseraConnection.getRsQuery().getString("cognome");
				this.nascita = tesseraConnection.getRsQuery().getDate("nascita");
				this.punti = tesseraConnection.getRsQuery().getInt("punti");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean verificaPresenza() {
		//DA FARE
		return true;
	}
	@Override
	public void getDati() {
		System.out.println("--- " + this.idtessera + " ---"+
				 "\nNome: " + this.nome +
				"\nCognome: " + this.cognome +
				"\nNascita: " + this.nascita +
				"\nPunti: " + this.punti);
		
	}
	
	@Override
	public void aggiornaPunti() {
		String query = "UPDATE tessera SET punti = " + this.punti + 
				" WHERE IDtessera = '" + this.idtessera + "'";		
		tesseraConnection.executeUpdate(query);
		
	}
	
	@Override
	public void accreditoPunti(int acPunti, boolean utilizzoPunti) {
		System.out.println("UUU: "+utilizzoPunti);
		if(utilizzoPunti == true && (acPunti+this.punti) <= 9999999) {
			System.out.println("PPPPPPPP: "+acPunti+this.punti);
			this.punti += acPunti;	
			aggiornaPunti();
		}		
	}
	
	@Override
	public void addebitoPunti(int adPunti, boolean utilizzoPunti) throws IOException {
		if((this.punti - adPunti)<0) throw new IOException("Punti negativi");
		else {
		this.punti -= adPunti;	
		aggiornaPunti();
		}
	}
	


	public static void main(String[] args) throws IOException {

		Tessera t = new Tessera("GRRMTT97L08I156I");
		Prodotto p = new Prodotto("8410668111116");
		p.creaConnessione();
		t.connessioneDB();
		//p.getDati();
		Policy pol = new Policy("AP", p);
		pol.importaDB();
		//t.accreditoPunti(9999999, pol.isUtilizzoPunti());
		t.addebitoPunti(0, pol.isUtilizzoPunti());
		//z.addebitoPunti(11);
		t.getDati();
//		t.connessioneDB();
//		t.addebitoPunti(3);
//		t.accreditoPunti(10);
//		t.getDati();
	}

}
