package Console;

import java.io.IOException;

public class SessioneMain {
	
	private int puntiSessione = 0;
	private int barcode;
	
	
	
	
	/*
	 * 1. Avvio sessione (timer)
	 * 
	 * 		2. scansione tessera: -GestoreTessera (anche RitiroPremio)
	 * 		
	 * 		2.1 Autenticazione
	 * 
	 * 		3. scansione prodotto: -GestoreProdotto
	 * TODO:statistiche
	 * TODO:ritiropremio
	 * 
	 * ?.Chiusura sessione
	 * 
	 * */
	
	
	
	

	public static void main(String[] args) throws IOException {
		
		//prodotto		
		Prodotto p = new Prodotto("8410668111116");
		p.creaConnessione();
		p.getDati();
		p.getComponenti();
		p.getDescrizioni();
		
		//policy
		Policy pol = new Policy("AP", p);
		pol.importaDB();
		
		//tessera
		Tessera t = new Tessera("GRRMTT97L08I156I");
		t.connessioneDB();
		t.accreditoPunti(p.getPunti(), pol.isUtilizzoPunti());
		t.getDati();
		
		//cestino smart
		CestinoSmart c = new CestinoSmart();
		for (int i=0; i <100; i++)
		c.conferimentoProdotto(p);
		
		c.conferimentoProdotto(p);
		c.conferimentoProdotto(p);
	}
	
	

}
