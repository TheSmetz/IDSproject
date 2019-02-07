package ids.unicam.trashit.console;

import java.text.SimpleDateFormat;
import java.util.Date;

import ids.unicam.trashit.database.CreateConnection;

public class Statistica {
	
	private String prodottoID;
	private String tesseraID;
	private String orario;
	private CreateConnection statisticaConnection = new CreateConnection();
	
	public Statistica (String prodotto, String tessera) {
		this.prodottoID = prodotto;
		this.tesseraID = tessera;
		this.orario = tempoAttuale();
		
		String queryStatistica = "INSERT INTO statistica (prodottoID, tesseraID, orario) "
				+ "VALUE ('" + this.prodottoID + "','" + this.tesseraID + "','" + this.orario + "')";		
		statisticaConnection.executeUpdate(queryStatistica);
	}
	
	private String tempoAttuale () {
		 Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		return ft.format(dNow);
	}
}
