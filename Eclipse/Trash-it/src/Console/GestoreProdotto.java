package Console;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

public interface GestoreProdotto{
	
	public void creaConnessione();
	
	public boolean verificaPresenza(String codiceABarre);
	
	public void getDatiProdotto();
	
	public String scansioneCodiceABarreProdotto();	

}
