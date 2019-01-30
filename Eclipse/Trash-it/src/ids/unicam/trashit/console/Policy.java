package ids.unicam.trashit.console;

import java.sql.SQLException;

import ids.unicam.trashit.database.CreateConnection;

public class Policy {

	private Prodotto prodotto;
	private String descrizione;
	private String zona;
	private boolean utilizzoPunti;
	
	private CreateConnection policyConnection = new CreateConnection();
	private CreateConnection policyPunti = new CreateConnection();

	// costruttore
	public Policy(String z) {
		this.zona = z;
		zonaDB();
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
	
	public boolean isUtilizzoPunti() {
		return utilizzoPunti;
	}

	public void datiProdotto(Prodotto p) {
		this.prodotto = p;
		String query = "SELECT policy.descrizione, componente.descrizione "
				+ "FROM (( prodotto INNER JOIN componente ON prodotto.IDprodotto = componente.prodottoID )"
				+ "INNER JOIN policy ON componente.IDcomponente = policy.componenteID ) "
				+ "INNER JOIN area ON area.IDarea = policy.areaID WHERE policy.areaID = '"+this.zona+ "'"
				+ "AND prodotto.IDprodotto = '"+this.prodotto.getcodiceABarre()+"' GROUP BY componente.IDcomponente";
		policyConnection.executeQuery(query);

		try {
			while(policyConnection.getRsQuery().next()) {
				this.descrizione = policyConnection.getRsQuery().getString("policy.descrizione").toLowerCase();
				prodotto.getCollocazioneCestini().add(Materiale.valueOf(this.descrizione));
				//System.out.println("prima"+this.descrizione);
				this.descrizione = policyConnection.getRsQuery().getString("componente.descrizione").toLowerCase();
				prodotto.getArrayParti().add(this.descrizione);
				//System.out.println("dopo"+this.descrizione);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void zonaDB() {		
		String queryPunti = "SELECT raccoltaPunti FROM area WHERE IDarea = '" + this.zona + "'";
		policyPunti.executeQuery(queryPunti);
		
		try {			
			if (policyPunti.getRsQuery().next()) {
				this.utilizzoPunti = policyPunti.getRsQuery().getBoolean("raccoltaPunti");			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}