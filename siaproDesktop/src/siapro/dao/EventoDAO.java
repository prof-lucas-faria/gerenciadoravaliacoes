package siapro.dao;

import java.util.List;

import siapro.model.Avaliacao;
import siapro.model.Categoria;
import siapro.model.Entidade;
import siapro.conexao.Conexao;
import siapro.model.Evento;
import siapro.model.Organizador;

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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Entidade> listarTudo(Entidade entidade) {
		Evento e = (Evento)entidade;
		String sql = "SELECT * FROM evento WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1,e.getId());
			ResultSet rs = stmt.executeQuery();
			List<Entidade> lista = new ArrayList<Entidade>();
			while (rs.next()) {
				e.setId(rs.getLong("id"));
				e.setNome(rs.getString("nome"));
				e.setInformacoes(rs.getString("informacoes"));
				e.setLiberado(rs.getBoolean("liberado"));
				e.setLogotipo(rs.getString("logotipo"));
				lista.add(e);
			}
			stmt.close();
			return lista;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public Entidade pesquisarId(long id) {
		String sql = "SELECT * FROM evento WHERE id = ?";
		ArrayList<Evento> resultadoConsulta = new ArrayList<Evento>();
		try {
		
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
	
	while (rs.next()) {
		Evento evento = new Evento (rs.getString("nome"), rs.getString("informacoes"), rs.getBoolean("liberado"), rs.getString("logotipo"));
		resultadoConsulta.add(evento);
	}
	stmt.close();
	} catch (Exception ex) {
		throw new RuntimeException(ex);
	}
		
	}}


