package siaproweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import siaproweb.conexao.Conexao;
import siaproweb.model.Area;
import siaproweb.model.Categoria;
import siaproweb.model.Entidade;
import siaproweb.model.Evento;
import siaproweb.model.Projeto;

public class ProjetoDAO implements InterfaceDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	public ProjetoDAO() {
		this.conexao = new Conexao().getConexao();
	}

	@Override
	public Entidade salvar(Entidade entidade) {
		String sql = "INSERT INTO projeto (titulo, autores, ativo, idEvento, idCategoria, idArea) VALUES (?,?,?,?,?,?)";
		if (entidade instanceof Projeto) {
			Projeto projeto = (Projeto) entidade;
			try {
				stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, projeto.getTitulo());
				stmt.setString(2, projeto.getAutores());
				stmt.setBoolean(3, true);
				stmt.setLong(4, projeto.getEvento().getId());
				stmt.setLong(5, projeto.getCategoria().getId());
				stmt.setLong(6, projeto.getArea().getId());
				stmt.execute();
				ResultSet rs = stmt.getGeneratedKeys();
				rs.next();

				projeto.setId(rs.getInt(1));

				stmt.close();
				return (Entidade) projeto;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	@Override
	public Entidade editar(Entidade entidade) {
		String sql = "UPDATE projeto SET titulo = ?, autores = ?, ativo = ?, idEvento = ?, idCategoria = ?, idArea = ? WHERE id = ?";
		if (entidade instanceof Projeto) {
			Projeto projeto = (Projeto) entidade;
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
		if (entidade instanceof Evento) {
			Evento evento = (Evento) entidade;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setLong(1, evento.getId());
				ResultSet rs = stmt.executeQuery();
				ArrayList<Entidade> listaProjeto = new ArrayList<Entidade>();
				while (rs.next()) {
					Projeto projeto = new Projeto();
					projeto.setId(rs.getLong("id"));
					Area area = (Area) new AreaDAO().pesquisarId(rs.getLong("idArea"));
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
			Projeto projeto = new Projeto();
			if (rs.next()) {
				projeto.setId(rs.getLong("id"));
				Evento evento = (Evento) new EventoDAO().pesquisarId(rs.getLong("idEvento"));
				Area area = (Area) new AreaDAO().pesquisarId(rs.getLong("idArea"));
				Categoria categoria = (Categoria) new CategoriaDAO().pesquisarId(rs.getLong("idCategoria"));
				projeto.setTitulo(rs.getString("titulo"));
				projeto.setAutores(rs.getString("autores"));
				projeto.setCategoria(categoria);
				projeto.setArea(area);
				projeto.setEvento(evento);
				stmt.close();
				return (Entidade) projeto;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public List<Projeto> pesquisarTitulo(Projeto projeto) {
		String sql = "SELECT titulo FROM projeto WHERE idEvento = ? AND titulo LIKE ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, projeto.getEvento().getId());
			stmt.setString(2, "%" + projeto.getTitulo() + "%");
			ResultSet rs = stmt.executeQuery();
			List<Projeto> listaTitulo = new ArrayList<Projeto>();
			while (rs.next()) {
				Projeto pj = new Projeto();
				pj.setTitulo(rs.getString("titulo"));
				pj.setEvento(projeto.getEvento());
				listaTitulo.add(pj);
			}
			stmt.close();
			return listaTitulo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
