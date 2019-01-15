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
	
	public void importaDB() {
		String host = "jdbc:mysql://localhost:3306/dbtrash-it";
		String username = "root";
		String password = "";

		try {
			Connection dbCon = DriverManager.getConnection(host, username, password); // connessione
			Statement stmtProdotto = dbCon.createStatement();
			String query = "SELECT policy.descrizione, componente.descrizione "
					+ "FROM (( prodotto INNER JOIN componente ON prodotto.IDprodotto = componente.prodottoID )"
					+ "INNER JOIN policy ON componente.IDcomponente = policy.componenteID ) "
					+ "INNER JOIN area ON area.IDarea = policy.areaID WHERE policy.areaID = '"+this.zona+ "'"
					+ "AND prodotto.IDprodotto = "+this.prodotto.getcodiceABarre()+" GROUP BY componente.IDcomponente";

			ResultSet rsProdotto = stmtProdotto.executeQuery(query);
			while(rsProdotto.next()) {
				this.descrizione = rsProdotto.getString("policy.descrizione");
				prodotto.collocazioneCestini.add(Materiale.valueOf(this.descrizione));
				//System.out.println("prima"+this.descrizione);
				this.descrizione = rsProdotto.getString("componente.descrizione");
				prodotto.arrayParti.add(this.descrizione);
				//System.out.println("dopo"+this.descrizione);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Prodotto p = new Prodotto("8410668111116");
		Policy pol = new Policy("AP", p);
		p.creaConnessione();
		p.getDati();
		pol.importaDB();
		p.getComponenti();
		p.getDescrizioni();
		System.exit(0);
	}

}