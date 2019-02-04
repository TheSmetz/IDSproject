package ids.unicam.trashit.start;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ids.unicam.trashit.database.CreateConnection;

public class Provincia {
	
	private ArrayList<String> arrayProvincia=new ArrayList<String>();	//options	
	CreateConnection provinciaConnection = new CreateConnection();
	private String provinciaCestino;
	
	public Provincia () {
		getDBOptions();
		setProvincia();
	}
	
	private void getDBOptions() {
		String query = "SELECT nome FROM area";		
		provinciaConnection.executeQuery(query);
		
		try {
			while (provinciaConnection.getRsQuery().next()) {
				this.arrayProvincia.add(provinciaConnection.getRsQuery().getString("nome"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	  }
	
	private void setProvincia() {
		Object[] options = arrayProvincia.toArray();
		Object value = JOptionPane.showInputDialog(null, 
                "Seleziona una provincia", 
                "Provincia", 
                 JOptionPane.INFORMATION_MESSAGE, 
                 null,
                 options, 
                 options[0]);
		getProvincia((String) value);
	}
	
	private void getProvincia(String cittaNome) {
		String query = "SELECT IDarea FROM area WHERE nome = '"+cittaNome+"'";		
		provinciaConnection.executeQuery(query);
		
		try {
			while (provinciaConnection.getRsQuery().next()) {
				this.provinciaCestino = provinciaConnection.getRsQuery().getString("IDarea");	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getProvinciaCestino () {
		return this.provinciaCestino;
	}
}
