package Console;

import java.sql.SQLException;

import dbConnection.CreateConnection;

public class Policy {

	private Prodotto prodotto;
	private String descrizione;
	private String zona;
	private boolean utilizzoPunti;
	
	private CreateConnection policyConnection = new CreateConnection();

	// costruttore
	public Policy(String z, Prodotto p) {
		this.zona = z;
		this.prodotto = p;
	}
	
//	public boolean utilizzoPunti() {
//		
//		
//		
//		return false;
//		
//	}

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
		String query = "SELECT policy.descrizione, componente.descrizione "
				+ "FROM (( prodotto INNER JOIN componente ON prodotto.IDprodotto = componente.prodottoID )"
				+ "INNER JOIN policy ON componente.IDcomponente = policy.componenteID ) "
				+ "INNER JOIN area ON area.IDarea = policy.areaID WHERE policy.areaID = '"+this.zona+ "'"
				+ "AND prodotto.IDprodotto = "+this.prodotto.getcodiceABarre()+"AND area.raccoltaPunti="+" GROUP BY componente.IDcomponente";
		policyConnection.executeQuery(query);

		try {
			while(policyConnection.getRsQuery().next()) {
				this.descrizione = policyConnection.getRsQuery().getString("policy.descrizione");
				prodotto.collocazioneCestini.add(Materiale.valueOf(this.descrizione));
				//System.out.println("prima"+this.descrizione);
				this.descrizione = policyConnection.getRsQuery().getString("componente.descrizione");
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