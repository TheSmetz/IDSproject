package Console;

//import Console.Cestino;

public class CestinoSmart {
	
	Cestino carta = new Cestino("carta");
	Cestino plastica = new Cestino("plastica");
	Cestino vetro = new Cestino("vetro");
	Cestino indifferenziato = new Cestino("indifferenziato");
	
	
	public boolean controlloIntegrita() {
		if (carta.isIntegrita() == true && 
			plastica.isIntegrita() == true && 
			vetro.isIntegrita() == true && 
			indifferenziato.isIntegrita() == true) {
			return true;
		}else return false;
	}
	
	public boolean controlloVuoto() {
		if (carta.isPieno() == false && 
			plastica.isPieno() == false && 
			vetro.isPieno() == false && 
			indifferenziato.isPieno() == false) {
			return true;
		}else return false;
	}
	
	public boolean controlloCestino() {
		if (controlloIntegrita() == true && controlloVuoto() == true) {
			return true;
		}else return false;
	}
	
	public void conferimentoProdotto() {
		//cestino scelto
		//se è pieno
		//apri bocchetta
	}


}
