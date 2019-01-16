package Console;

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
	 * 
	 * 
	 * ?.Chiusura sessione
	 * 
	 * */
	
	
	
	

	public static void main(String[] args) {
		Prodotto p = new Prodotto("8410668111116");
		Policy pol = new Policy("AP", p);
		p.creaConnessione();
		p.getDati();
		pol.importaDB();
		p.getComponenti();
		p.getDescrizioni();
	}

}
