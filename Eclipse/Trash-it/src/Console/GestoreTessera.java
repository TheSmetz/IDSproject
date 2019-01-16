package Console;

import java.io.IOException;

public interface GestoreTessera {
	
	public boolean verificaPresenza();
	public void getDati();
	public void accreditoPunti(int acPunti, boolean utilizzoPunti);
	public void addebitoPunti(int adPunti, boolean utilizzoPunti) throws IOException;
	public void aggiornaPunti();	

}
