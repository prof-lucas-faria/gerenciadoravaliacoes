package siapro.dao;

import java.awt.geom.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import siapro.conexao.Conexao;
import siapro.model.Avaliador;
import siapro.model.Entidade;
import siapro.model.Evento;

public class AvaliadorDAO implements InterfaceDAO {
	
	private Connection conexao;
	private PreparedStatement stmt;
	
	public AvaliadorDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	
	@Override
	public Entidade salvar(Entidade entidade) {
		String sql = "insert into avaliador(nome,login,senha) values (?,?,?)";
		Avaliador avaliador = (Avaliador) entidade;
		
		try {
			stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, avaliador.getNome());
			stmt.setString(2,avaliador.getLogin());
			stmt.setString(3, avaliador.getSenha());
			stmt.execute(); 
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			
			avaliador.setId(rs.getInt(1));
			
			
			for(siapro.model.Area area: avaliador.getArea()) {
				String sql2 = "insert into avaliadorArea(idAvaliador,idArea) values (?,?)";
				stmt = conexao.prepareStatement(sql2);
				stmt.setLong(1, avaliador.getId());
				stmt.setLong(2, area.getId());
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return null ;
	}

	@Override
	public Entidade editar(Entidade entidade) {
		String sql = "update avaliador set nome = ?, login = ?, senha = ? where id = ?";
		
		try {
			Avaliador avaliador = (Avaliador) entidade;
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, avaliador.getNome());
			stmt.setString(2, avaliador.getLogin());
			stmt.setString(3, avaliador.getSenha());
			stmt.execute();
			stmt.close();
			
			
			// Preciso do ID do avaliador.
			for(siapro.model.Area area: avaliador.getArea()) {
				String sql2 = "update avaliadorArea(idAvaliador,idArea) values (?,?) where idAvalaidor = ?";
				stmt = conexao.prepareStatement(sql2);
				stmt.setLong(1, avaliador.getId());
				stmt.setLong(2, area.getId());
				stmt.setLong(3, avaliador.getId());
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return entidade;
	}

	@Override
	public List<Entidade> listarTudo(Entidade entidade) {
		String sql = "select * from avaliador a inner join eventoAvaliador ea a.id = ae.idAvaliador where ae.idEvento = ?"; // Selecionar avaliadores de um evento..
		
		try {
			Evento evento = (Evento) entidade;
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1,evento.getId());
			ResultSet rs = stmt.executeQuery();
			
			
			List<Entidade> avaliadores = new ArrayList<Entidade>();
		
			while(rs.next()) {
				Avaliador avaliador = new Avaliador();
				avaliador.setId(rs.getLong("id"));
				avaliador.setNome(rs.getString("nome"));
				avaliador.setLogin(rs.getString("login"));
				avaliador.setSenha(rs.getString("senha"));
				
				Area area = new Area();
				AreaDAO areaDAO = new AreaDAO();
				
				avaliador.setArea(areaDAO.listarTudo(avaliador)); // O metodo areaDAO.listarTudo() pesquisa por avalaidor ou por evento?
				
				
				
				// Depois de pesquisar as área de um avaliador eu tenho que dar set no list o avalaidor
				// Vou precisar de um metódo que pesquise area por avaliador?
				// Adicionar também as áreas que o avalaidor tem.
				
			
				avaliadores.add(avaliador); 
			}
			stmt.close();
			return avaliadores;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Entidade pesquisarId(long id) {
		String sql = "select * from avaliador where id = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Avaliador avaliador = new Avaliador();
			if(rs.next()) {
				avaliador.setId(rs.getLong("id"));
				avaliador.setNome(rs.getString("nome"));
				avaliador.setLogin(rs.getString("login"));
				avaliador.setSenha(rs.getString("senha"));
				
				Area area = new Area();
				AreaDAO areaDAO = new AreaDAO();
				avaliador.setArea(areaDAO.listarTudo(entidade));  // O metodo areaDAO.listarTudo() pesquisa por avalaidor ou por evento?
				
				
				// Depois de pesquisar as área de um avaliador eu tenho que dar set no list o avalaidor
				// Vou precisar de um metódo que pesquise area por avaliador?
				// Adicionar também as áreas que o avalaidor tem.
				
			}
			stmt.close();
			return avaliador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	
	public Entidade pesquisar(Entidade entidade) {
		String sql = "select * from avaliador a inner join eventoAvaliador ae where nome like '%?%' and ae.idEvento = ?; ";
		Avaliador avaliador = (Avaliador) entidade;
		try {
			
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, avaliador.getNome());
			stmt.setLong(2, evento.getId()); // Pegar o evento.
			ResultSet rs = stmt.executeQuery();
			
			Avaliador avaliador = new Avaliador();
			if(rs.next()) {
				avaliador.setId(rs.getLong("id"));
				avaliador.setNome(rs.getString("nome"));
				avaliador.setLogin(rs.getString("login"));
				avaliador.setSenha(rs.getString("senha"));
				
				Area area = new Area();
				AreaDAO areaDAO = new AreaDAO();
				areaDAO.pesquisaArea(nome);
				avaliador.setArea(areaDAO.pesquisaArea()); // Metodo que retorna a area de acordo com o avaliador
				
				
				// Usar metodo pesquisa Area por nome para pesquisar a area e setar junto;
				
			}
			stmt.close();

			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return entidade;
		
	}

	}
