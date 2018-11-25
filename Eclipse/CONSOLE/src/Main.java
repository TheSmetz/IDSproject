

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prodotto Birra = new Prodotto("g313v12g3", "Heineken", "Tappo indifferenziato, bottiglia vetro", false, false,
				true, true);
		Prodotto Giornale = new Prodotto("hwgyue23", "Gazzetta", "Giornale carta", true, false, false, false);
		
		System.out.println("\n Stampa prodotto : Birra\n");
		Birra.getMateriale();
		Birra.getNomeProdotto();
		Birra.getCodiceABarre();
		Birra.getDescrizione();
		
		System.out.println("\n Stampa prodotto : Giornale\n");
		Giornale.getMateriale();
		Giornale.getNomeProdotto();
		Giornale.getCodiceABarre();
		Giornale.getDescrizione();
	}

}
