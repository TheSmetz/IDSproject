package Console;

import java.io.IOException;

//import Console.Cestino;

public class CestinoSmart {

	Cestino carta = new Cestino("carta");
	Cestino plastica = new Cestino("plastica");
	Cestino vetro = new Cestino("vetro");
	Cestino indifferenziato = new Cestino("indifferenziato");

	public boolean controlloIntegrita() {
		if (carta.isIntegrita() == true && plastica.isIntegrita() == true && vetro.isIntegrita() == true
				&& indifferenziato.isIntegrita() == true) {
			return true;
		} else
			return false;
	}

	public boolean controlloVuoto() {
		if (carta.isPieno() == false && plastica.isPieno() == false && vetro.isPieno() == false
				&& indifferenziato.isPieno() == false) {
			return true;
		} else
			return false;
	}

	public boolean controlloCestini() { //controllo generale sia vuoto sia integrità
		if (controlloIntegrita() == true && controlloVuoto() == true) {
			return true;
		} else
			return false;
	}

	public void conferimentoProdotto(Prodotto p) throws IOException {
		for (int i = 0 ; i < p.collocazioneCestini.size(); i++) {
			if(controlloCestini()) {
				
				
				if (p.collocazioneCestini.get(i) == Materiale.carta) {
					carta.aumentaCapienza();
					System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.carta);
				}
				
				if (p.collocazioneCestini.get(i) == Materiale.plastica) {
					plastica.aumentaCapienza();
					System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.plastica);
				}
				
				
//			switch (p.collocazioneCestini.get(i)) {
//			case carta:
//				carta.aumentaCapienza();
//				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.carta);
//				continue;
//			case plastica:
//				plastica.aumentaCapienza();
//				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.plastica);
//				continue;
//			case vetro:
//				vetro.aumentaCapienza();
//				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.vetro);
//				continue;
//			case indifferenziato:
//				indifferenziato.aumentaCapienza();
//				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.indifferenziato);
//				continue;
//			}
		} else throw new IOException("Cestini Pieni");{
			
		}
		}
	}

}