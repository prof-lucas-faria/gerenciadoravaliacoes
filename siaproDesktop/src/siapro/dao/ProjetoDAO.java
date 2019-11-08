package siapro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import siapro.conexao.Conexao;
import siapro.model.Area;
import siapro.model.Avaliacao;
import siapro.model.Categoria;
import siapro.model.Entidade;
import siapro.model.Evento;
import siapro.model.Projeto;

public class ProjetoDAO implements InterfaceDAO{
	private Connection conexao;
	private PreparedStatement stmt;

	public ProjetoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	@Override
	public Entidade salvar(Entidade entidade) {
		String sql = "INSERT INTO contato (titulo, autores, ativo, idEvento, idCategoria, idArea) VALUES (?,?,?,?,?,?)";
		if(entidade instanceof Projeto) {
			Projeto projeto = (Projeto)entidade;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, projeto.getTitulo());
				stmt.setString(2, projeto.getAutores());
				stmt.setBoolean(3, true);
				stmt.setLong(4, projeto.getEvento().getId());
				stmt.setLong(5, projeto.getCategoria().getId());
				stmt.setLong(6, projeto.getArea().getId());
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
		String sql = "UPDATE contato SET titulo = ?, autores = ?, ativo = ?, idEvento = ?, idCategoria = ?, idArea = ? WHERE id = ?";
		if(entidade instanceof Projeto) {
			Projeto projeto = (Projeto)entidade;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, projeto.getTitulo());
				stmt.setString(2, projeto.getAutores());
				stmt.setBoolean(3, true);
				stmt.setLong(4, projeto.getEvento().getId());
				stmt.setLong(5, projeto.getCategoria().getId());
				stmt.setLong(6, projeto.getArea().getId());
				stmt.setLong(7, projeto.getId());
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
		String sql = "SELECT * FROM projeto WHERE idEvento = ?";
		if(entidade instanceof Evento) {
			Evento evento = (Evento)entidade;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setLong(1, evento.getId());
				ResultSet rs = stmt.executeQuery();
				Projeto projeto = new Projeto();
				List<Entidade> listaProjeto = new ArrayList<Entidade>();
				while (rs.next()) {
					projeto.setId(rs.getLong("id"));
					Area area = (Area)new AreaDAO().pesquisarId(rs.getLong("idArea"));
					Categoria categoria = (Categoria) new CategoriaDAO().pesquisarId(rs.getLong("idCategoria"));
					projeto.setTitulo(rs.getString("titulo"));
					projeto.setAutores(rs.getString("autores"));
					projeto.setCategoria(categoria);
					projeto.setArea(area);
					projeto.setEvento(evento);
					listaProjeto.add((Entidade) projeto);
				}
				stmt.close();
				return listaProjeto;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	@Override
	public Entidade pesquisarId(long id) {
		String sql = "SELECT * FROM projeto WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Projeto projeto;
			List<Entidade> listaProjeto = new ArrayList<Entidade>();
			if (rs.next()) {
				projeto.setId(rs.getLong("id"));
				Evento evento = (Evento)new EventoDAO().pesquisarId(rs.getLong("idEvento"));
				Area area = (Area)new AreaDAO().pesquisarId(rs.getLong("idArea"));
				Categoria categoria = (Categoria) new CategoriaDAO().pesquisarId(rs.getLong("idCategoria"));
				projeto.setTitulo(rs.getString("titulo"));
				projeto.setAutores(rs.getString("autores"));
				projeto.setCategoria(categoria);
				projeto.setArea(area);
				projeto.setEvento(evento);
				listaProjeto.add((Entidade) projeto);
			}
			stmt.close();
			return (Entidade) projeto;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	public Projeto carregarAvaliacao(Projeto projeto) {
		List<Avaliacao> avaliacoes = new AvaliacaoDAO().pesquisarPorProjeto(projeto);
		projeto.setAvaliacoes(avaliacoes);
		return projeto;
	}
}
