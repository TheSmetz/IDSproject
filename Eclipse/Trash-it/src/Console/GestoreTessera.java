package Console;

public interface GestoreTessera {
	
	public boolean verificaValidita();
	public boolean verificaPresenza();
	public void getDati();
	public void accreditoPunti(int acPunti);
	public void addebitoPunti(int adPunti);	

}
