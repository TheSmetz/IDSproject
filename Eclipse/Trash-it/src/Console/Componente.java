package Console;

public class Componente {
private Materiale IDCompontente; //PER ID posso anche mettere una sigla (PL,VE,IN,CA)=(plastica,vetro,indifferenziato,carta) -> da modificare Tipo
private String nomeComponente;


public Componente(Materiale a,String nome) {
	//metodo controllo duplicazione componenti sia per ID sia per nome
	this.IDCompontente=a;
	this.nomeComponente=nome;
}



public Materiale getIDCompontente() {
	return IDCompontente;
}

public void setIDCompontente(Materiale iDCompontente) {
	IDCompontente = iDCompontente;
}

public String getNomeComponente() {
	return nomeComponente;
}

public void setNomeComponente(String nomeComponente) {
	this.nomeComponente = nomeComponente;
}





}