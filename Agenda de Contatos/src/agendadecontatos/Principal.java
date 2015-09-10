package agendadecontatos;

import java.sql.SQLException;


import logica.Contato;
import dao.ContatoDAO;

public class Principal {

	public static void main(String[] args) throws SQLException {
		
	
	
	
	
		
	Contato contato = new Contato();
	contato.setId(Long.valueOf(6));
	
	ContatoDAO dao = new ContatoDAO();
	dao.remove(contato);
	System.out.println("Dados removido com sucesso");
	
	
	
	
	
	}

}
