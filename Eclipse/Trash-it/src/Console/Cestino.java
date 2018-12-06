package Console;

public class Cestino extends CestinoSmart {
	private double capienza; // mostra percentuale di riempimento del cestino
	private boolean sensore = false; // controlla se è stato gettato un rifiuto

	public Cestino() {
	} // costruttore

	public double getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public boolean isSensore() {
		return sensore;
	}

	public void setSensore(boolean sensore) {
		this.sensore = sensore;
	}
}
