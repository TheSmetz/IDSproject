package Console;

public interface GestoreTessera {
	public boolean verificaValidita(int ID);
	
	public boolean verificaPresenza(int ID);
	
	public void getDatiTessera(int ID);
	
	public void accreditaPunti(int ID, int amountPunti);
	
	public String ScansioneIDTessera();		
	
}
