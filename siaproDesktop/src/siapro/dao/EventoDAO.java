package siapro.dao;

import java.util.List;

import siapro.model.Categoria;
import siapro.model.Entidade;
import siapro.conexao.Conexao;
import siapro.model.Evento;
import siapro.model.Organizador;
import siapro.model.Projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EventoDAO implements InterfaceDAO {

	private Connection conexao;
	private PreparedStatement stmt;
	
	public EventoDAO() {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
	}
	public Entidade salvar(Entidade entidade) {
		String sql = "INSERT INTO evento (nome, informacoes, liberado, logotipo) VALUES (?,?,?,?)";
		try {
			Evento e = (Evento) entidade;
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getInformacoes());
			stmt.setBoolean(3, e.getLiberado());
			stmt.setString(4, e.getLogotipo());
			stmt.execute();
			stmt.close();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				e.setId(rs.getLong("id"));
			}
			this.stmt.close();
			return e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public Entidade editar(Entidade entidade) {
		Evento evento = (Evento) entidade;
		String sql = "UPDATE evento SET nome = ?, informacoes = ?, liberado = ?, logotipo = ?  WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, evento.getNome());
			stmt.setString(2, evento.getInformacoes());
			stmt.setBoolean(3, evento.getLiberado());
			stmt.setString(4, evento.getLogotipo());
			stmt.setLong(5, evento.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Entidade> listarTudo(Entidade entidade) {
		String sql = "select * from evento e inner join organizadorEvento oe on oe.idEvento = e.id where oe.idOrganizador = ?;";
		List<Entidade> resultadoConsulta = new ArrayList<Entidade>();
		try {
			Organizador organizador = (Organizador) entidade;
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1,organizador.getId());
			ResultSet rs = stmt.executeQuery();
			
			
			 while (rs.next()) {
				 Evento evento = new Evento(rs.getLong("id"), rs.getString("nome"), rs.getString("informacoes"), rs.getBoolean("liberado"), rs.getString("logotipo"));
				 resultadoConsulta.add(evento); 
			}
			stmt.close();
			return resultadoConsulta;
		}     
		catch (Exception ex) {
			throw new RuntimeException(ex); 
		}
	}
	
		public Entidade pesquisarId(long id) {
			String sql = "SELECT * FROM evento WHERE id = ?";
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();
				Evento evento = new Evento();
				if (rs.next()) {
					 evento = new Evento(rs.getLong("id"), rs.getString("nome"), rs.getString("informacoes"), rs.getBoolean("liberado"), rs.getString("logotipo"));
				}
				stmt.close();
				
				return evento;
			}     
			catch (Exception ex) {
				throw new RuntimeException(ex); 
			}
		}
		
		public Evento pesquisarPorCategoria(Categoria categoria) {
			String sql = "SELECT e.id FROM evento e INNER JOIN categoria c  ON e.id = c.idEvento WHERE c.id = ?";
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setLong(1, categoria.getId());
				ResultSet rs = stmt.executeQuery();
				long idEvento = 0;
				Evento evento =  new Evento();
				if(rs.next()) {
					idEvento = rs.getLong("id");
					evento = (Evento) this.pesquisarId(idEvento);
				}
				
				return evento;
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
