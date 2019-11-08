package siapro.dao;

import java.util.ArrayList;
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
		
        String sql = "UPDATE organizador SET nome = ?,  email = ?, senha = ?";
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
	public List<Entidade> listarTudo(Entidade e) {
		String sql = "SELECT * FROM organizador";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Entidade> lista = new ArrayList<Entidade>();
			while (rs.next()) {
				Organizador o = new Organizador(rs.getString("email"));
				o.setId(rs.getInt("id"));
				o.setNome(rs.getString("nome"));
				o.setSenha(rs.getString("senha"));
				lista.add(o);
			}
			stmt.close();
			return lista;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Entidade pesquisarId(long id) {
		String sql = "SELECT * FROM organizador WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Organizador o = new Organizador(rs.getString("email"));
				o.setId(rs.getInt("id"));
				o.setNome(rs.getString("nome"));
				o.setSenha(rs.getString("senha"));
				return o;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
