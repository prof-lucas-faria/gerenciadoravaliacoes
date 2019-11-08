package siapro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import siapro.conexao.Conexao;
import siapro.model.Entidade;

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
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt (1, entidade.getAvaliador().getIdAvaliador());
            stmt.setInt(2, entidade.getProjeto().getIdProjeto());
            stmt.setDouble(3, entidade.getNota());
            stmt.setBoolean(4, entidade.getAvaliado());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }	
	}

	@Override
	public Entidade editar(Entidade entidade) {
		// TODO Auto-generated method stub
		String sql = "UPDATE avaliacao SET idAvaliador = ? WHERE idProjeto = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt (1, entidade.getAvaliador().getIdAvaliador());
            stmt.setInt(2, entidade.getProjeto().getIdProjeto());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Entidade> listarTudo() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM avaliacao";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
			while (rs.next()) {
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getInt("id"));
				avaliacao.setIdAvaliador(rs.getInt("idAvaliador"));
				avaliacao.setIdProjeto(rs.getInt("idProjeto"));
				avaliacao.setNota(rs.getDouble("nota"));
				avaliacao.setAvaliado(rs.getBoolean("avaliado"));
				lista.add(avaliacao);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Entidade pesquisarId(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM avaliacao WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idAvaliacao);
			ResultSet rs = stmt.executeQuery();
			Avaliacao avaliacao = new Avaliacao();
			if (rs.next()) {
				avaliacao.setIdAvaliacao(rs.getInt("id"));
				avaliacao.setAvaliado(rs.getBoolean("avaliado"));
			}
			return avaliacao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
