package Console;

import java.util.ArrayList;

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

	public boolean controlloCestino() {
		if (controlloIntegrita() == true && controlloVuoto() == true) {
			return true;
		} else
			return false;
	}

	public void conferimentoProdotto(Prodotto p) {
		for (int i = 0 ; i < p.collocazioneCestini.size(); i++) {	
			switch (p.collocazioneCestini.get(i)) {
			case carta:
				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.carta);
				continue;
			case plastica:
				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.plastica);
				continue;
			case vetro:
				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.vetro);
				continue;
			case indifferenziato:
				System.out.println("Gettare "+p.arrayParti.get(i)+" in " + Materiale.indifferenziato);
				continue;

			}
		}

	}

	public static void main(String[] args) {
		Prodotto p = new Prodotto("8410668111116");
		Policy pol = new Policy("AP", p);
		p.creaConnessione();
		p.getDati();
		pol.importaDB();
		p.getComponenti();
		//p.getDescrizioni();
		
		// System.out.println(p.componenti.contains(Materiale.Carta)); //CONTROLLO CHE P
		// SIA DI CARTA
		// System.out.println(p.componenti.contains(Materiale.Plastica));
		// System.out.println(p.contaComponenti());

		CestinoSmart c = new CestinoSmart();
		c.conferimentoProdotto(p);
	}

}
