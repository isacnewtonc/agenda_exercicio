package dao;

import isac.bancodedados.CriaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Contato;



public class ContatoDAO {

	
	private Connection conexao;
	
	public ContatoDAO() throws SQLException {
	
		this.conexao = CriaConexao.getConexao();
		
	}
	
	public void adiciona(Contato contato) throws SQLException{
		
		
String sql = "insert into contato(nome, endereco, telefone, email, sexo) values (?,?,?,?,?)";
		

		//seta os valores
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEndereco());
		stmt.setString(3, contato.getTelefone());
		stmt.setString(4, contato.getEmail());
		stmt.setString(5, contato.getSexo());
		
		
		//executa o código sql
		stmt.execute();
		stmt.close();
		
	}
	
	public List<Contato> getLista() throws SQLException {
		
		String sql = "select * from contato";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		ResultSet resultado = stmt.executeQuery();
		List<Contato> minhaLista = new ArrayList<Contato>();
		
		while(resultado.next()){
			Contato cl = new Contato();
			cl.setNome(resultado.getString("nome"));
			cl.setEndereco(resultado.getString("endereco"));
			cl.setTelefone(resultado.getString("telefone"));
			cl.setEmail(resultado.getString("email"));
			cl.setSexo(resultado.getString("sexo"));
			minhaLista.add(cl);
			
			
			
		}
		
		resultado.close();
		stmt.close();
		return minhaLista;
		
	}
	
	public void altera(Contato contato) throws SQLException{
		
		
		String sql = "update contato set nome=?, endereco=?, telefone=?, email=? , sexo=? where id=?" ;
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		
		
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEndereco());
		stmt.setString(3, contato.getTelefone());
		stmt.setString(4, contato.getEmail());
		stmt.setString(5, contato.getSexo());
		stmt.setLong(6, contato.getId());
		
		
		//executa o código sql
		stmt.execute();
		stmt.close();
		
		
	}
	
	
	public void remove(Contato contato) throws SQLException{
		
		
		String sql = "delete from contato where id=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		
		stmt.setLong(1, contato.getId());
		stmt.execute();
		stmt.close();
		
		
		
	}
	
	
}
