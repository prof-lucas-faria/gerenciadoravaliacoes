package siapro.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import siapro.model.Entidade;
import siapro.conexao.Conexao;
import siapro.model.Categoria;
import siapro.model.Evento;


public class CategoriaDAO implements InterfaceDAO {
	
	private Connection conexao;
	private PreparedStatement stmt;
	
	public  CategoriaDAO() {
		 this.conexao = new Conexao().getConexao();
	 }
	
	
	@Override
	public Entidade salvar(Entidade entidade) {
		Categoria c = (Categoria)entidade;
		
		String sql = "INSERT INTO categoria (nome, idEvento,qntMinAvalProjeto, qntMaxAvalProjeto) VALUES (?, ?, ?, ?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setLong(2, c.getEvento().getId());
			stmt.setInt(3, c.getQntMinAvalProjeto());
			stmt.setInt(4, c.getQntMaxAvalProjeto());
			stmt.execute();
			stmt.close();
			return c;
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}

	@Override
	public Entidade editar(Entidade entidade) {
		Categoria c = (Categoria)entidade;
		
		String sql = "UPDATE categoria SET nome = ?, qntMinAvalProjeto = ?, qntMaxAvalProjeto = ? WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getQntMinAvalProjeto());
			stmt.setInt(3, c.getQntMaxAvalProjeto());
			stmt.setLong(4, c.getId());
			stmt.execute();
			stmt.close();
			return c;
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Entidade> listarTudo(Entidade entidade) {
		Evento e = (Evento)entidade;
		String sql = "SELECT * FROM categoria WHERE idEvento = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1,e.getId());
			ResultSet rs = stmt.executeQuery();
			List<Entidade> lista = new ArrayList<Entidade>();
			while (rs.next()) {
				Categoria c = new Categoria(rs.getString("nome"));
				c.setId(rs.getInt("id"));
				c.setEvento(e);
				c.setQntMinAvalProjeto(rs.getInt("QntMinAvalProjeto"));
				c.setQntMaxAvalProjeto(rs.getInt("QntMaxAvalProjeto"));
				lista.add(c);
			}
			stmt.close();
			return lista;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Entidade pesquisarId(long id) {
		String sql = "SELECT * FROM categoria WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Categoria c = new Categoria(rs.getString("nome"));
				c.setId(rs.getInt("id"));
				c.setQntMinAvalProjeto(rs.getInt("QntMinAvalProjeto"));
				c.setQntMaxAvalProjeto(rs.getInt("QntMaxAvalProjeto"));
				return c;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void deletar(Categoria categoria) {
		String sql = "DELETE FROM categoria WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, categoria.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
	}
}
