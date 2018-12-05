package Console;

import java.util.ArrayList;

public class Prodotto implements GestoreProdotto{
	private String codiceABarre;
	private String nomeProdotto;
	private String descrizione;
	private boolean materialeCarta = false;
	private boolean materialePlastica = false;
	private boolean materialeVetro = false;
	private boolean materialeIndifferenziato = false;
	private ArrayList<String> materiali = new ArrayList<>(); // lista di materiali del prodotto inserito

	public Prodotto(String codiceABarre, String nomeProdotto, String descrizione, boolean materialeCarta,
			boolean materialePlastica, boolean materialeVetro, boolean materialeIndifferenziato) {
		this.codiceABarre = codiceABarre;
		this.nomeProdotto = nomeProdotto;
		this.descrizione = descrizione;
		this.materialeCarta = materialeCarta;
		this.materialePlastica = materialePlastica;
		this.materialeVetro = materialeVetro;
		this.materialeIndifferenziato = materialeIndifferenziato;
	} // costruttore

	public void getCodiceABarre() {
		// return this.codiceABarre;
		System.out.println(this.codiceABarre);
	}
	
	public void getNomeProdotto() {
		// return nomeProdotto
		System.out.println(this.nomeProdotto);
	}

	public void getDescrizione() {
		// return descrizione;
		System.out.println(this.descrizione);
	}

	public void getMateriale() { // da controllare efficienza
		if (this.materialeCarta) {
			materiali.add("Carta");
		}
		if (this.materialeIndifferenziato) {
			materiali.add("Indifferenziato");
		}
		if (this.materialePlastica) {
			materiali.add("Plastica");
		}
		if (this.materialeVetro) {
			materiali.add("Vetro");
		}
		System.out.println(materiali);
		;
	} // specifica i/il tipo/i di materiale/i del prodotto

	
}
