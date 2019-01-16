package Console;

import java.io.IOException;

public interface GestoreTessera {
	
	public boolean verificaPresenza();
	public void getDati();
	public void accreditoPunti(int acPunti);
	public void addebitoPunti(int adPunti) throws IOException;
	public void aggiornaPunti();	

}
