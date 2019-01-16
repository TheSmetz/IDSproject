package Console;

import java.io.IOException;

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
		if (carta.isVuoto() == true && plastica.isVuoto() == true && vetro.isVuoto() == true
				&& indifferenziato.isVuoto() == true) {
			return true;
		} else
			return false;
	}

	public boolean controlloCestini() { // controllo generale sia vuoto sia integrità
		if (controlloIntegrita() == true && controlloVuoto() == false) {
			return true;
		} else
			return false;
	}

	public void conferimentoProdotto(Prodotto p) throws IOException {
		for (int i = 0; i < p.getCollocazioneCestini().size(); i++) {
			if (controlloVuoto()) {
				switch (p.getCollocazioneCestini().get(i)) {
				case carta:
					carta.aumentaCapienza();
					System.out.println("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.carta);
					continue;
				case plastica:
					plastica.aumentaCapienza();
					System.out.println("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.plastica);
					continue;
				case vetro:
					vetro.aumentaCapienza();
					System.out.println("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.vetro);
					continue;
				case indifferenziato:
					indifferenziato.aumentaCapienza();
					System.out.println("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.indifferenziato);
					continue;
				}
			} else throw new IOException("Cestini Pieni");
		}
	}
}
