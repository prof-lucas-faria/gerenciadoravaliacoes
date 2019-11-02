package siapro.dao;

import java.util.List;

import siapro.model.Entidade;
import siapro.model.Organizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import siapro.conexao.Conexao;

public class OrganizadorDAO implements InterfaceDAO {
	 private Connection conexao;
	 private PreparedStatement stmt;
	 
	 public  OrganizadorDAO() {
		 this.conexao = new Conexao().getConexao();
	 }
	 
	@Override
	public Entidade salvar(Entidade entidade) {
			Organizador o = (Organizador)entidade;
			
	        String sql = "INSERT INTO organizador (nome, email, senha) VALUES (?,?,?)";
	        try {
	            stmt = conexao.prepareStatement(sql);
	            stmt.setString(1, o.getNome());
	            stmt.setString(2,o.getEmail());
	            stmt.setString(3, o.getSenha());
	            stmt.execute();
	            stmt.close();
	            return o;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public Entidade editar(Entidade entidade) {
		Organizador o = (Organizador)entidade;
		
        String sql = "UPDATE organizador SET nome = ?,  email = ?, senha = ?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, o.getNome());
            stmt.setString(2,o.getEmail());
            stmt.setString(3, o.getSenha());
            stmt.execute();
            stmt.close();
            return o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public List<Entidade> listarTudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade pesquisarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
