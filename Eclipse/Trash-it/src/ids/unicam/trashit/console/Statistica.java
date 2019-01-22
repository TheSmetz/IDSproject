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
		System.out.println(this.prodottoID + this.tesseraID);
	}
	
	private String tempoAttuale () {
		 Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	      System.out.println("Current Date: " + ft.format(dNow));
		return ft.format(dNow);
	}
}