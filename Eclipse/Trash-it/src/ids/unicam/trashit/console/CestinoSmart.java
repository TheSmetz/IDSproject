package ids.unicam.trashit.console;

import java.io.IOException;
import java.util.ArrayList;

public class CestinoSmart {

	Cestino carta = new Cestino("carta");
	Cestino plastica = new Cestino("plastica");
	Cestino vetro = new Cestino("vetro");
	Cestino indifferenziato = new Cestino("indifferenziato");
	private ArrayList<String> arrayConferimento=new ArrayList<String>();
	

	public String getArrayConferimento() {
		String conferimento = "";

		for (String s : arrayConferimento)
		{
		    conferimento += s + " ";
		}
		return conferimento;
	}
	
	public void svuotaTuttiCestini() {
		carta.svuotaCestino();
		plastica.svuotaCestino();
		vetro.svuotaCestino();
		indifferenziato.svuotaCestino();
	}
	
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
					arrayConferimento.add("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.carta+"\n");
					continue;
				case plastica:
					plastica.aumentaCapienza();
					arrayConferimento.add("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.plastica+"\n");
					continue;
				case vetro:
					vetro.aumentaCapienza();
					arrayConferimento.add("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.vetro+"\n");
					continue;
				case indifferenziato:
					indifferenziato.aumentaCapienza();
					arrayConferimento.add("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.indifferenziato+"\n");
					continue;
				}
			} else throw new IOException("Cestini Pieni");
		}		
		p.setDescrizione(getArrayConferimento());
	}
}
