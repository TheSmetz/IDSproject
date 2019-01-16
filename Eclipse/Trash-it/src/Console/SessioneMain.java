package Console;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dbConnection.CreateConnection;

public class SessioneMain {
	
	private int puntiSessione = 0;
	private int barcode;
	
	public static void registrazione(String CF,String nome,String cognome,String nascita) {
		CreateConnection tConnection = new CreateConnection();
		String queryAggiunta = "INSERT INTO tessera (IDtessera,nome,cognome,nascita,punti) "
				+ "VALUES ('"+CF+"','"+nome+"','"+cognome+"','"+nascita+"',0)";
		tConnection.executeUpdate(queryAggiunta);
		
	}
	
	
	/*
	 * 1. Avvio sessione (timer)
	 * 
	 * 		2. scansione tessera: -GestoreTessera (anche RitiroPremio)
	 * 		
	 * 		2.1 Autenticazione
	 * 
	 * 		3. scansione prodotto: -GestoreProdotto
	 * TODO:statistiche
	 * TODO:ritiropremio -- su tessera
	 * TODO:timer
	 * TODO:aggiunta prodotto al db DA FARE
	 * TODO:chiama tecnico
	 * TODO:collegare main con cio fatto
	 * TODO:BUG
	 * ?.Chiusura sessione
	 * 
	 * */
	
	
	
	

	public static void main(String[] args) throws IOException {
		
		registrazione("RSSMRA70A01H501S", "mario", "rossi","1970-01-01");
//		//prodotto		
//		Prodotto p = new Prodotto("8410668111116");
//		p.creaConnessione();
//		p.getDati();
//		p.getComponenti();
//		p.getDescrizioni();
//		
//		//policy
//		Policy pol = new Policy("AP", p);
//		pol.importaDB();
//		
//		//tessera
//		Tessera t = new Tessera("GRRMTT97L08I156I");
//		t.connessioneDB();
//		t.accreditoPunti(p.getPunti(), pol.isUtilizzoPunti());
//		t.getDati();
//		
//		//cestino smart
//		CestinoSmart c = new CestinoSmart();
//		c.conferimentoProdotto(p);
	}
	
	

}
