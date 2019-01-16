package Console;

public interface GestoreTessera {
	
	public boolean verificaPresenza();
	public void getDati();
	public void accreditoPunti(int acPunti);
	public void addebitoPunti(int adPunti);
	public void aggiornaPunti();	

}
