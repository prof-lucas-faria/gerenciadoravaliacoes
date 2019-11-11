package siapro.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import siapro.conexao.Conexao;
import siapro.model.Area;
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
		
			AreaDAO areaDAO = new AreaDAO();
			
			
			for(int i = 0;  i < avaliador.getArea().size(); i++) {
				String sql2 = "insert into avaliadorArea(idAvaliador,idArea) values (?,?)";
				stmt = conexao.prepareStatement(sql2);
				stmt.setLong(1, avaliador.getId());
				stmt.setLong(2, areaDAO.pesquisaArea(avaliador.getArea().get(i).getNome()).getId());
				stmt.execute();
				stmt.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return avaliador ;
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
			stmt.setLong(4, avaliador.getId());
			stmt.execute();
			stmt.close();
			
			
			for(int i = 0;  i < avaliador.getArea().size(); i++) {
				String sql2 = "update avaliadorArea set idAvaliador = ?, idArea = ? where idAvaliador = ?";
				stmt = conexao.prepareStatement(sql2);
				stmt.setLong(1, avaliador.getId());
				stmt.setLong(2, avaliador.getArea().get(i).getId());
				stmt.setLong(3, avaliador.getId());
				stmt.execute();
				stmt.close();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return entidade;
	}

	@Override
	public List<Entidade> listarTudo(Entidade entidade) {
		String sql = "select * from avaliador a inner join eventoAvaliador ea on ea.idAvaliador =  a.id  where ea.idEvento = ?;"; 
		
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
				
				
				AreaDAO areaDAO = new AreaDAO();
				Area area = null;
				ArrayList<Area> lista_area = new ArrayList<Area>();
				List<Entidade> area_entidade = areaDAO.pesquisarAvaliador(avaliador);
				
				for(int x = 0; x < area_entidade.size(); x++) {
					area = (Area) area_entidade.get(x);
					lista_area.add(area);
					
				}
				
				avaliador.setArea(lista_area);
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
				
				AreaDAO areaDAO = new AreaDAO();
				Area area = null;
				ArrayList<Area> lista_area = new ArrayList<Area>();
				List<Entidade> area_entidade = areaDAO.pesquisarAvaliador(avaliador);
				
				for(int x = 0; x < area_entidade.size(); x++) {
					area = (Area) area_entidade.get(x);
					lista_area.add(area);
					
				}
				avaliador.setArea(lista_area);
			}
			stmt.close();
			return avaliador;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Entidade pesquisar(Entidade entidade) {
		String sql = "select * from avaliador a inner join eventoAvaliador ae where nome like '%?%' and ae.idEvento = ?; ";
		Avaliador avaliador = (Avaliador) entidade;
		try {
			
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, avaliador.getNome());
			stmt.setLong(2, evento.getId()); // Pegar o evento.
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				avaliador.setId(rs.getLong("id"));
				avaliador.setNome(rs.getString("nome"));
				avaliador.setLogin(rs.getString("login"));
				avaliador.setSenha(rs.getString("senha"));
				
				AreaDAO areaDAO = new AreaDAO();
				Area area = null;
				ArrayList<Area> lista_area = new ArrayList<Area>();
				List<Entidade> area_entidade = areaDAO.pesquisarAvaliador(avaliador);
				
				for(int x = 0; x < area_entidade.size(); x++) {
					area = (Area) area_entidade.get(x);
					lista_area.add(area);
					
				}
				avaliador.setArea(lista_area);
				
			}
			stmt.close();

			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return entidade;
		
	}

	}
