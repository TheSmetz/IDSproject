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

	public void convertiComponenti() {

		// provvisori

		String host = "jdbc:mysql://localhost:3306/dbtrash-it";
		String username = "root";
		String password = "";

		try {
			Connection dbCon = DriverManager.getConnection(host, username, password); // connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query = "SELECT componente.IDcomponente, policy.descrizione FROM ((`prodotto` INNER JOIN `componente` ON prodotto.IDprodotto = componente.prodottoID) "
					+ "INNER JOIN `policy` ON componente.IDcomponente = policy.componenteID) "
					+ "INNER JOIN `area` ON area.IDarea = policy.areaID) " + "WHERE policy.areaID = '" + this.zona
					+ "'AND prodotto.IDprodotto='" + prodotto.getcodiceABarre() + "GROUP BY componente.IDcomponente";

			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			if (rsProdotto.next()) {
				this.descrizione = rsProdotto.getString("policy.descrizione");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Materiale setEnum(String comp) { // controllo errore
		if (comp.equals("CA")) {
			return Materiale.Carta;
		}
		if (comp.equals("PL")) {
			return Materiale.Plastica;
		}
		if (comp.equals("VE")) {
			return Materiale.Vetro;
		}
		if (comp.equals("IN")) {
			return Materiale.Indifferenziato;
		}
		return null;
	}

	public static void main(String[] args) {
		Prodotto p = new Prodotto();
		p.scansioneCodiceABarre();
		p.creaConnessione();
		p.getDati();

		Policy pol = new Policy("AP", p);
		pol.stampaNome();
		pol.convertiComponenti();
		System.out.println("\n" + pol.zona);
		System.out.println(pol.descrizione);

		p.setComponenti(pol.setEnum(pol.descrizione));
		p.stampaComponenti();
	}

}