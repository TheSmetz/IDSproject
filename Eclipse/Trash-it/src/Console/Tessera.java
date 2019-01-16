package Console;

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
		// TODO Auto-generated method stub
		return false;
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
	public void accreditoPunti(int acPunti) {
		this.punti += acPunti;	
		aggiornaPunti();
	}
	
	@Override
	public void aggiornaPunti() {
		String query = "UPDATE tessera SET punti = " + this.punti + 
				" WHERE IDtessera = '" + this.idtessera + "'";		
		tesseraConnection.executeUpdate(query);
		
	}
	@Override
	public void addebitoPunti(int adPunti) {
		this.punti -= adPunti;	
		aggiornaPunti();
	}
	


	public static void main(String[] args) {
		Tessera t = new Tessera("FLSNDR97D17B474W");
		Tessera z = new Tessera("GRRMTT97L08I156I");
		z.connessioneDB();
		z.accreditoPunti(10);
		z.addebitoPunti(2);
		z.getDati();
		t.connessioneDB();
		t.addebitoPunti(3);
		t.accreditoPunti(10);
		t.getDati();
	}

}
