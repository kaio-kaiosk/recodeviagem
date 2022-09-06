package krturismo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestePacoteDAO {

	public static void main(String[] args) {
		// Testando a execução do Pacote DAO
		//Create
		Pacote pacote = new Pacote();
				
		pacote.setCod_Pacote(2258);
		pacote.setOrigem("MG");
		pacote.setDestino("SP");
		
		PacoteDAO dao = new PacoteDAO();
				
		dao.save(pacote);
				
		System.out.println("Pacote salvo");
		
		//Read
		try {
			ResultSet resultado = dao.getPacote();
			while (resultado.next()) {
				System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//Update
		pacote.setOrigem("SP");
		pacote.setDestino("MG");
		
		dao.update(pacote);;
		
		System.out.println("Cliente alterado");
		
		//Delete
		PacoteDAO dao1 = new PacoteDAO();
		dao1.removeByCod_Pacote(0);
		
		System.out.println("Pacote removido");

	}
}
