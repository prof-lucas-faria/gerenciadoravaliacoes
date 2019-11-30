package siaproweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import siaproweb.conexao.Conexao;
import siaproweb.model.Entidade;
import siaproweb.model.Projeto;
import siaproweb.model.Avaliacao;
import siaproweb.model.Criterio;
import siaproweb.dao.CriterioDAO;

public class AvaliacaoDAO implements InterfaceDAO {
	 private Connection conexao;
	 private PreparedStatement stmt;
	 
	 public AvaliacaoDAO() {
		// TODO Auto-generated constructor stub
		this.conexao = new Conexao().getConexao();				
	}

	@Override
	public Entidade salvar(Entidade entidade) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO avaliacao (idAvaliador, idProjeto, nota, avaliado) VALUES (?,?,?,?)";
		Avaliacao avaliacao = (Avaliacao) entidade;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, avaliacao.getAvaliador().getId());
            stmt.setLong(2, avaliacao.getProjeto().getId());
            stmt.setDouble(3, avaliacao.getNota());
            stmt.setBoolean(4, avaliacao.isAvaliacao());
            stmt.execute();
            stmt.close();
            
            
            for(Criterio criterio: avaliacao.getCriterios()) {
            	String sql2 = "INSERT INTO avaliacaoCriterio VALUES (?,?)";
                
                stmt = conexao.prepareStatement(sql2);
                stmt.setLong(1, avaliacao.getId());
            	stmt.setLong(2, criterio.getId());
            }
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		return avaliacao;	
	}

	@Override
	public Entidade editar(Entidade entidade) {
		// TODO Auto-generated method stub
		String sql = "UPDATE avaliacao SET idAvaliador = ?, idProjeto = ?, nota = ?, avaliado = ? WHERE id = ?";
		Avaliacao avaliacao = (Avaliacao) entidade;
		try {
			stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, avaliacao.getAvaliador().getId());
            stmt.setLong(2, avaliacao.getProjeto().getId());
            stmt.setDouble(3, avaliacao.getNota());
            stmt.setBoolean(4, avaliacao.isAvaliacao());
            stmt.execute();
            stmt.close();
            
           
            for(Criterio criterio: avaliacao.getCriterios()) {
            	 String sql2 = "UPDATE avaliadcaoCriterio(idAvaliacao,idACriterio,nota) values (?,?,?) where idAvaliacao = ?";
                 
                 stmt = conexao.prepareStatement(sql2);
                 stmt.setLong(1, avaliacao.getId());
            	 stmt.setLong(2, criterio.getId());
            }
            stmt.execute();
            stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return avaliacao;
	}

	@Override
	public List<Entidade> listarTudo(Entidade entidade) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM avaliacao";
		
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Entidade> lista = new ArrayList<Entidade>();
			while (rs.next()) {
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setId(rs.getLong("id"));
				avaliacao.getAvaliador().setId(rs.getLong("idAvaliador"));
				avaliacao.getProjeto().setId(rs.getInt("idProjeto"));
				avaliacao.setNota(rs.getDouble("nota"));
				avaliacao.setAvaliacao(rs.getBoolean("avaliado"));
				
				CriterioDAO criterioDAO = new CriterioDAO();
				
				avaliacao.setCriterios(criterioDAO.pesquisarPorAvalicao(avaliacao));
				lista.add(avaliacao);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Entidade pesquisarId(long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM avaliacao WHERE id = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Avaliacao avaliacao = new Avaliacao();
			if (rs.next()) {
				avaliacao.setId(rs.getInt("id"));
				avaliacao.setAvaliacao(rs.getBoolean("avaliado"));
			}
			return avaliacao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Avaliacao> pesquisarPorProjeto(Projeto projeto) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM avaliacao WHERE idProjeto = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, projeto.getId());
			ResultSet rs = stmt.executeQuery();
			ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
			while (rs.next()) {
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setId(rs.getLong("id"));
				avaliacao.getAvaliador().setId(rs.getLong("idAvaliador"));
				avaliacao.getProjeto().setId(rs.getInt("idProjeto"));
				avaliacao.setNota(rs.getDouble("nota"));
				avaliacao.setAvaliacao(rs.getBoolean("avaliado"));
				lista.add(avaliacao);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
