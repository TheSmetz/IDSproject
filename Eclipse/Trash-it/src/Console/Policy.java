package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Policy {
	
	private Prodotto prodotto;
	private String descrizioneUno;
	private String descrizioneDue;
	private String descrizioneTre;
	private String descrizioneQuattro;
	private String zona;
	
	//costruttore
	public Policy(String z, Prodotto p) {
		this.zona=z;
		this.prodotto = p;
		
		//String query = "SELECT * FROM policy WHERE area = " + area;
		//metodo Controllo zona (politiche fisse? o le creo al momento?)
	}

	
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public void stampaNome() {
		System.out.println(prodotto.getNomeProdotto());
	}
	
	
	public void convertiComponenti() {
		
		//provvisori		
				
		String host = "jdbc:mysql://localhost:3306/dbtrash-it";
		String username = "root";
		String password = "";
		
		try {
			Connection dbCon = DriverManager.getConnection(host, username, password);	//connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query1 = "SELECT * FROM ((`policy` INNER JOIN `area` ON policy.IDArea = area.IDArea) "
							+ "INNER JOIN `componente` ON policy.IDComponente = componente.IDComponente) "
							+ "WHERE policy.IDArea = '" + this.zona + "' AND policy.IDComponente = '" + prodotto.getPrimoComponente() + "'";
			
//			String query2 = "SELECT * FROM policy WHERE IDComponente = '" + prodotto.getSecondoComponente() + "'";
//			String query3 = "SELECT * FROM policy WHERE IDComponente = '" + prodotto.getTerzoComponente() + "'";
//			String query4 = "SELECT * FROM policy WHERE IDComponente = '" + prodotto.getQuartoComponente() + "'";
			
			ResultSet rsProdotto1 = stmtProdotto.executeQuery(query1);
//			ResultSet rsProdotto2 = stmtProdotto.executeQuery(query2);
//			ResultSet rsProdotto3 = stmtProdotto.executeQuery(query3);
//			ResultSet rsProdotto4 = stmtProdotto.executeQuery(query4);
			
			if (rsProdotto1.next()) {	
				this.descrizioneUno = rsProdotto1.getString("Descrizione");
			}	
//			if (rsProdotto2.next()) {	
//				this.descrizioneDue = rsProdotto2.getString("Descrizione");
//			}
//			if (rsProdotto3.next()) {	
//				this.descrizioneTre = rsProdotto3.getString("Descrizione");
//			}
//			if (rsProdotto4.next()) {	
//				this.descrizioneQuattro = rsProdotto4.getString("Descrizione");
//			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
			
		
		
//		
//		
//		//finali
//		public Componente getPlastica() {
//			return Plastica;
//		}
//
//		public void setPlastica(Componente plastica) {
//			Plastica = plastica;
//		}
//
//		public Componente getCarta() {
//			return Carta;
//		}
//
//		public void setCarta(Componente carta) {
//			Carta = carta;
//		}
//
//		public Componente getIndifferenziato() {
//			return Indifferenziato;
//		}
//
//		public void setIndifferenziato(Componente indifferenziato) {
//			Indifferenziato = indifferenziato;
//		}
//
//		public Componente getVetro() {
//			return Vetro;
//		}
//
//		public void setVetro(Componente vetro) {
//			Vetro = vetro;
//		}
//	}
	
	
	public Materiale setEnum(String comp) {
		if (comp == "Carta") {
			return Materiale.Carta;
		}
		if (comp == "Plastica") {
			return Materiale.Plastica;
		}
		if (comp == "Vetro") {
			return Materiale.Vetro;
		}
		if (comp == "Indifferenziato") {
			return Materiale.Indifferenziato;
		}
		return null;
	}
	

	
	public static void main(String[] args) {
		Prodotto p = new Prodotto("123456");
		p.creaConnessione();		
		p.getDatiProdotto();	
		
		Policy pol = new Policy("AP", p);
		pol.stampaNome();
		pol.convertiComponenti();
		System.out.println("\n" + pol.zona);
		System.out.println(pol.descrizioneUno);
		
		Componente c = new Componente(pol.setEnum(pol.descrizioneUno), "aaa");
		
		p.setComponenti(c);
		System.out.println(p.toString());
	}

}