package siaproweb.dao;

import java.util.List;

import siaproweb.conexao.Conexao;
import siaproweb.model.Entidade;
import siaproweb.model.Evento;
import siaproweb.model.Area;
import siaproweb.model.Avaliador;
import siaproweb.model.Categoria;
import siaproweb.dao.AreaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AreaDAO implements InterfaceDAO{
	private Connection conexao;
	private PreparedStatement stmt;
	
	public AreaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	@Override
	public Entidade salvar(Entidade entidade) {
		if (entidade instanceof Area) {
			Area area = (Area) entidade;
			String sql = "INSERT INTO area (nome, idEvento, descricao) VALUES (?,?,?)";
	        try {
	            stmt = conexao.prepareStatement(sql);
				stmt.setString(1, area.getNome());
				stmt.setLong(2, area.getEvento().getId());
				stmt.setString(3, area.getDescricao());
	            stmt.execute();
	            stmt.close();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
		}
		return entidade;
	}
	
	@Override
	public Entidade editar(Entidade entidade) {
		if (entidade instanceof Area) {
			Area area = (Area) entidade;	
	        String sql = "UPDATE area SET nome = ?, idEvento = ?, descricao = ? WHERE id = ?";
	        try {
	            stmt = conexao.prepareStatement(sql);
	            stmt.setString(1, area.getNome());
	            stmt.setLong(2, area.getEvento().getId());
	            stmt.setString(3,area.getDescricao());
	            stmt.setLong(4, area.getId());
	            stmt.execute();
	            stmt.close();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
		}
		return entidade;
	}

	@Override
	public List<Entidade> listarTudo(Entidade entidade) {
		Evento evento = (Evento)entidade;
		String sql = "SELECT * FROM area where idEvento = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, evento.getId());
			ResultSet rs = stmt.executeQuery();
			ArrayList<Entidade> lista = new ArrayList<Entidade>();
			while (rs.next()) {
	            Area areas = new Area();
				areas.setId(rs.getInt("id"));
				areas.setNome(rs.getString("nome"));
				areas.setEvento(evento);
				areas.setDescricao(rs.getString("descricao"));
				lista.add(areas);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Entidade> pesquisarAvaliador(Entidade entidade){
		Avaliador avaliador = (Avaliador) entidade;
		String sql = "select a.id, a.nome, a.descricao from avaliadorArea aa inner join area a on a.id = aa.idArea where aa.idAvaliador = ?;";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1,avaliador.getId()); 
			ResultSet rs = stmt.executeQuery();
			ArrayList<Entidade> areas = new ArrayList<Entidade>();
			Area area = new Area();
			while (rs.next()) {
				area.setId(rs.getInt("id"));
				area.setNome(rs.getString("nome"));
				area.setDescricao(rs.getString("descricao"));
				areas.add(area);
			}
			stmt.close();
			return areas;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Entidade pesquisarId(long id) {
		String sql = "SELECT * FROM area WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Area area = new Area();
				area.setId(rs.getLong("id"));
				area.setNome(rs.getString("nome"));
				EventoDAO eventoDAO = new EventoDAO();
				area.setEvento((Evento) eventoDAO.pesquisarId(rs.getLong("idEvento")));
				area.setDescricao(rs.getString("descricao"));
				 return area;
			}
			  stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	     
	 public ArrayList<Area>pesquisaNomeArea(String nome) {
	        String sql = "SELECT * FROM area WHERE nome LIKE ?";
	        try {
	            stmt = conexao.prepareStatement(sql);
	            stmt.setString(1, "%"+ nome +"%");
	            ResultSet rs = stmt.executeQuery();
	            ArrayList<Area> areas = new ArrayList<Area>();
	            while (rs.next()) {
	            	Area area = new Area();
	            	area.setId(rs.getLong("id"));
	            	area.setNome(rs.getString("nome"));
	            	EventoDAO eventoDAO = new EventoDAO();
					area.setEvento((Evento) eventoDAO.pesquisarId(rs.getLong("idEvento")));
	            	area.setDescricao(rs.getString("descricao"));
	            	areas.add(area);
	            }
	            stmt.close();
	            return areas;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	 public Area pesquisaArea(String nome) {
		 String sql = "SELECT * FROM area WHERE nome = ?";
	        try {
	            stmt = conexao.prepareStatement(sql);
	            stmt.setString(1, nome);
	            ResultSet rs = stmt.executeQuery();
	            Area area = new Area();
	            if (rs.next()) {
	            	area.setId(rs.getLong("id"));
	            	area.setNome(rs.getString("nome"));
	            	EventoDAO eventoDAO = new EventoDAO();
					area.setEvento((Evento) eventoDAO.pesquisarId(rs.getLong("idEvento")));
	            	area.setDescricao(rs.getString("descricao"));
	            }
	            stmt.close();
	            return area;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
