package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Policy {

	private Prodotto prodotto;
	private String descrizione;
	private String zona;

	// costruttore
	public Policy(String z, Prodotto p) {
		this.zona = z;
		this.prodotto = p;

		// String query = "SELECT * FROM policy WHERE area = " + area;
		// metodo Controllo zona (politiche fisse? o le creo al momento?)
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public void stampaNome() {
		System.out.println(prodotto.getNome());
	}

	public Materiale setEnum(String comp) { // controllo errore
		if (comp.equals("carta")) {
			return Materiale.Carta;
		} else if (comp.equals("plastica")) {
			return Materiale.Plastica;
		} else if (comp.equals("vetro")) {
			return Materiale.Vetro;
		} else if (comp.equals("indifferenziato")) {
			return Materiale.Indifferenziato;
		} else
			return null;
	}
	
	public void importaDB() {
		// provvisori
		String host = "jdbc:mysql://localhost:3306/dbtrash-it";
		String username = "root";
		String password = "";

		try {
			Connection dbCon = DriverManager.getConnection(host, username, password); // connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query = "SELECT policy.descrizione "
					+ "FROM (( prodotto INNER JOIN componente ON prodotto.IDprodotto = componente.prodottoID )"
					+ "INNER JOIN policy ON componente.IDcomponente = policy.componenteID ) "
					+ "INNER JOIN area ON area.IDarea = policy.areaID WHERE policy.areaID = '"+this.zona+ "'"
					+ "AND prodotto.IDprodotto = "+this.prodotto.getcodiceABarre()+" GROUP BY componente.IDcomponente";

			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			while(rsProdotto.next()) {
				this.descrizione = rsProdotto.getString("policy.descrizione");
				prodotto.componenti.add(setEnum(this.descrizione));
				//System.out.println(this.descrizione);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		Prodotto p = new Prodotto();
//		Policy pol = new Policy("AP", p);
//		p.scansioneCodiceABarre();
//		p.creaConnessione();
//		p.getDati();
//		pol.importaDB();
//		
//
//		p.setComponenti(pol.setEnum(pol.descrizione));
//		p.stampaComponenti();
//		System.exit(0);
	}

}