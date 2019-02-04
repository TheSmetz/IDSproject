package ids.unicam.trashit.console;

public class Cestino {

	@SuppressWarnings("unused")
	private String tipo;
	private boolean vuoto = true; // capienza = 100;
	private int capienza;
	private boolean integrita = true;
	@SuppressWarnings("unused")
	private boolean bocchetta;

	public void aumentaCapienza() {
		if (this.capienza < 100 && this.capienza >= 0) {
			this.capienza += 1;
		} else {
			this.vuoto = false;
		}
	}
	
	public void svuotaCestino() { //TECNICO
		this.capienza=0;
	}
	
	public void riparaCestino() { //TECNICO
		this.integrita=true;
	}

	public int getCapienza() {
		return this.capienza;
	}

	public boolean isVuoto() {
		return this.vuoto;
	}

	public boolean isIntegrita() {
		return this.integrita;
	}

	public void setIntegrita(boolean integrita) {
		this.integrita = integrita;
	}

	public void apriBocchetta() {
		this.bocchetta = true;
	}

	public void chiudiBocchetta() {
		this.bocchetta = false;
	}

	// costruttore
	public Cestino(String tipo) {
		this.tipo = tipo;
	}

}