package Console;

public class Cestino {
	
	public String tipo;
	public boolean pieno = false; //capienza = 100;
	public boolean integrita = true;
	public boolean bocchetta;
	
	public boolean isPieno() {
		return pieno;
	}
	public void setPieno(boolean pieno) {
		this.pieno = pieno;
	}
	public boolean isIntegrita() {
		return integrita;
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
	
	//costruttore
	public Cestino(String tipo) {
		this.tipo = tipo;
	}

}
