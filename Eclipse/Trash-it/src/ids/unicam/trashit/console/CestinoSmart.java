package ids.unicam.trashit.console;

import java.io.IOException;
import java.util.ArrayList;

public class CestinoSmart {

	Cestino carta = new Cestino("carta");
	Cestino plastica = new Cestino("plastica");
	Cestino vetro = new Cestino("vetro");
	Cestino indifferenziato = new Cestino("indifferenziato");
	private ArrayList<String> arrayConferimento=new ArrayList<String>();
	

	protected String getArrayConferimento() {
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
	
	protected boolean controlloIntegrita() {
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

	protected boolean controlloCestini() { // controllo generale sia vuoto sia integrità
		if (controlloIntegrita() == true && controlloVuoto() == false) {
			return true;
		} else
			return false;
	}
	
	public void chiudiBocchette() {
		carta.chiudiBocchetta();
		plastica.chiudiBocchetta();
		indifferenziato.chiudiBocchetta();
		vetro.chiudiBocchetta();
	}

	public void conferimentoProdotto(Prodotto p) throws IOException {
		for (int i = 0; i < p.getCollocazioneCestini().size(); i++) {
			if (controlloVuoto()) {
				switch (p.getCollocazioneCestini().get(i)) {
				case carta:
					carta.apriBocchetta();
					arrayConferimento.add("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.carta+"\n");
					carta.aumentaCapienza();
					continue;
				case plastica:
					plastica.apriBocchetta();
					arrayConferimento.add("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.plastica+"\n");
					plastica.aumentaCapienza();
					continue;
				case vetro:
					vetro.apriBocchetta();
					arrayConferimento.add("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.vetro+"\n");
					vetro.aumentaCapienza();
					continue;
				case indifferenziato:
					indifferenziato.apriBocchetta();
					arrayConferimento.add("Gettare " + p.getArrayParti().get(i) + " in " + Materiale.indifferenziato+"\n");
					indifferenziato.aumentaCapienza();
					continue;
				}
			} else throw new IOException("Cestini Pieni");
		}		
		p.setDescrizione(getArrayConferimento());
		arrayConferimento.clear();
	}
}
