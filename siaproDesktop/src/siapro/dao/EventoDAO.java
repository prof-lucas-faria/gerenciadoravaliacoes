package siapro.dao;

import java.util.List;


import siapro.model.Entidade;
import siapro.conexao.Conexao;
import siapro.model.Evento;
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
		String sql = "UPDATE evento SET nome = ?, informacoes = ?, liberado = ?, logotipo = ?  WHERE id = ?";
		try {
			Evento e = (Evento) entidade;
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getInformacoes());
			stmt.setBoolean(3, e.getLiberado());
			stmt.setString(4, e.getLogotipo());
			stmt.execute();
			stmt.close();
			return entidade;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Entidade> listarTudo(Entidade entidade) {
		String sql = "select * from evento e INNER JOIN organizadorEvento oe ON oe.idEvento = e.id INNER JOIN organizador o ON oe.idOrganizador = o.id;";
		ArrayList<Evento> resultadoConsulta = new ArrayList<Evento>();
			try {
				stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				 while (rs.next()) {
					 Evento evento = new Evento (rs.getString("nome"), rs.getString("informacoes"), rs.getBoolean("liberado"), rs.getString("logotipo"));
					 resultadoConsulta.add(evento); }
		stmt.close();
	  } catch (Exception ex) {
			throw new RuntimeException(ex); };
			return null;
	}
	
	public Entidade pesquisarId(long id) {
		return null;
	
	
	}

}