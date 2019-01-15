package Console;

import java.util.ArrayList;

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
	
	public void conferimentoProdotto(Prodotto p) {
		int size = p.componenti.size();
		
		for (int i=0; i<size; i++) {
//			
			switch (p.componenti.get(i)) {
			
			case carta: System.out.println("Gettare nomeComponente in " + Materiale.carta);
			break;
			
			case plastica: System.out.println("Gettare nomeComponente in " + Materiale.plastica);
			break;

			case vetro: System.out.println("Gettare nomeComponente in " + Materiale.vetro);
			break;
			
			case indifferenziato: System.out.println("Gettare nomeComponente in " + Materiale.indifferenziato);
			break;
			
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Prodotto p = new Prodotto("8410668111116");
		p.creaConnessione();		
		p.getDati();
		p.setComponenti(Materiale.indifferenziato);
		p.setComponenti(Materiale.carta);	
		p.setComponenti(Materiale.plastica);
		p.stampaComponenti();
		//System.out.println(p.componenti.contains(Materiale.Carta)); //CONTROLLO CHE P SIA DI CARTA
		//System.out.println(p.componenti.contains(Materiale.Plastica));
		//System.out.println(p.contaComponenti());
		
		CestinoSmart c = new CestinoSmart();
		c.conferimentoProdotto(p);
	}	


}
