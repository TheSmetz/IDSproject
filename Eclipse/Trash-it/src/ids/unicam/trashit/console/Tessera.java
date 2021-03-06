package ids.unicam.trashit.console;

import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;

import ids.unicam.trashit.database.CreateConnection;
import ids.unicam.trashit.grafica.GestoreGrafica;

public class Tessera {
	private String idtessera;
	private String nome;
	private String cognome;
	private Date nascita;
	private int punti;
	private boolean presenza;
	private CreateConnection tesseraConnection = new CreateConnection();

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public String getIdTessera() {
		return idtessera;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Date getNascita() {
		return nascita;
	}

	public Tessera(String tessera) {
		this.idtessera = tessera;
		connessioneDB();
	}

	public void connessioneDB() {
		String query = "SELECT * FROM tessera WHERE IDtessera = '" + this.idtessera + "'";
		tesseraConnection.executeQuery(query);
		try {
			if (tesseraConnection.getRsQuery().next()) {
				this.nome = tesseraConnection.getRsQuery().getString("nome");
				this.cognome = tesseraConnection.getRsQuery().getString("cognome");
				this.nascita = tesseraConnection.getRsQuery().getDate("nascita");
				this.punti = tesseraConnection.getRsQuery().getInt("punti");
				this.presenza = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.presenza = false;
		}
	}

	public boolean verificaPresenza() {
		return presenza;
	}

	public String getDati() {
		return ("--- " + this.idtessera + " ---" + "\nPunti: " + this.punti);
	}

	public void aggiornaPunti() {
		String query = "UPDATE tessera SET punti = " + this.punti + " WHERE IDtessera = '" + this.idtessera + "'";
		tesseraConnection.executeUpdate(query);

	}

	public void accreditoPunti(int acPunti, boolean utilizzoPunti) throws IOException {
		if (utilizzoPunti && ((acPunti + this.punti) <= 9999999)) {
			this.punti += acPunti;
			aggiornaPunti();
		} else
			throw new IOException("Punti sopra la soglia massima");
	}

	public boolean addebitoPunti(int adPunti, boolean utilizzoPunti) throws IOException {
		if ((this.punti - adPunti) < 0) {
			JOptionPane.showMessageDialog(GestoreGrafica.ritiroPremio.getJPanelRitiroPremio(), "Punti Insufficenti");
		return false;
		} else {
			this.punti -= adPunti;
			aggiornaPunti();
			return true;
		}
	}

	public void ritiroPremio(int puntiPremio) throws IOException {
		addebitoPunti(puntiPremio, true);
		System.out.println("premio stampato");
		}

}
