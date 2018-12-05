package Console;

public interface GestoreProdotto {
	
	public boolean verificaPresenza(String codiceABarre);
	
	public void getDatiProdotto(String codiceABarre);
	
	public String scansioneCodiceABarreProdotto();	

}
