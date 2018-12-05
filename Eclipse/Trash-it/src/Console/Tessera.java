package Console;

import java.util.Date;

public class Tessera implements GestoreTessera {
	private String nome;
	private String cognome;
	private String ID;
	private Date validita;
	private String residenzaAttuale;
	private Date dataNascita;
	private int punti;
	
	//costruttore
	public Tessera() {
	}
	
	////getters and setters
	public Date getValidita() {
		return validita;
	}

	public void setValidita(Date validita) {
		this.validita = validita;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setResidenzaAttuale(String residenzaAttuale) {
		this.residenzaAttuale = residenzaAttuale;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getID() {
		return ID;
	}

	public String getResidenzaAttuale() {
		return residenzaAttuale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public int getPunti() {
		return punti;
	}
	
	//override metodi

	@Override
	public boolean verificaValidita(int ID) {
		
		//if tessera valida
		return false;
	}

	@Override
	public boolean verificaPresenza(int ID) {
		
		//if tessera nel db = true
		return false;
	}

	@Override
	public void getDatiTessera(int ID) {
		
	}

	@Override
	public int accreditaPunti(int ID) {
		return 0;
	}

	@Override
	public String ScansioneIDTessera() {
		return ID;
		
	}
}
