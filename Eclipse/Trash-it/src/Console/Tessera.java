package Console;

import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tessera implements GestoreTessera {
	protected int idTessera;
	protected String codiceFiscale;
	protected String nome;
	protected String cognome;
	protected String citta;
	protected Date scadenza ;	//Date firstDate1 = new Date(int year, int month, int date);
	protected int punti;
	
	
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public int getIdTessera() {
		return idTessera;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getCitta() {
		return citta;
	}
	public Date getScadenza() {
		return scadenza;
	}
	
	@Override
	public boolean verificaValidita() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime localDate = LocalDateTime.now();
		System.out.println(dtf.format(localDate));
		System.out.println();
		return false;
	}
	@Override
	public boolean verificaPresenza() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void getDati() {
		//connessione database e estrazione dati
		
	}
	@Override
	public void accreditoPunti(int acPunti) {
		int puntiAttuali = getPunti();
		setPunti(puntiAttuali + acPunti);		
	}
	@Override
	public void addebitoPunti(int adPunti) {
		int puntiAttuali = getPunti();
		setPunti(puntiAttuali - adPunti);		
	}
	


	public static void main(String[] args) {
		Tessera t = new Tessera();
		t.verificaValidita();
	}

}
