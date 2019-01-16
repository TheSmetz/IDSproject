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
		if (carta.isVuoto() == true && plastica.isVuoto() == true && vetro.isVuoto() == true
				&& indifferenziato.isVuoto() == true) {
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
			//if(controlloVuoto()) {
			switch (p.collocazioneCestini.get(i)) {
			case carta:
				if (carta.isVuoto()) {
				carta.aumentaCapienza();
				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.carta);
				}else break;
			case plastica:
				if (plastica.isVuoto()) {
				plastica.aumentaCapienza();
				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.plastica);
				}else break;
			case vetro:
				if (vetro.isVuoto()) {
				vetro.aumentaCapienza();
				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.vetro);
				} else break;
			case indifferenziato:
				if (indifferenziato.isVuoto()) {
				indifferenziato.aumentaCapienza();
				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.indifferenziato);
				}else break;
			}
		//} else throw new IOException("Cestini Pieni");{
			
		}
		}
	}

//}