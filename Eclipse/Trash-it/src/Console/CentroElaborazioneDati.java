package Console;

public class CentroElaborazioneDati {
	private String nomeProdotto;
	private String codiceABarre;
	private boolean materialeCarta = false;
	private boolean materialePlastica = false;
	private boolean materialeVetro = false;
	private boolean materialeIndifferenziato = false;
	private int etaMedia;
	private int numeroProdotti;

	public CentroElaborazioneDati() {
	} // costruttore

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public String getCodiceABarre() {
		return codiceABarre;
	}

	public void getMateriale() {
	}

	public int getEtaMedia() {
		return etaMedia;
	}

	public int getNumeroProdotti() {
		return numeroProdotti;
	}
}
