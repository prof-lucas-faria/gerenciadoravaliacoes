package siapro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import siapro.conexao.Conexao;
import siapro.model.Avaliador;
import siapro.model.Entidade;

public class AvaliadorDAO implements InterfaceDAO {
	
	private Connection conexao;
	private PreparedStatement stmt;
	
	public AvaliadorDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	@Override
	public Entidade salvar(Entidade entidade) {
		String sql = "inser into avaliador(nome,login,senha) values (?,?,?)";
		Avaliador avaliador = (Avaliador) entidade;

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, avaliador.getNome());
			stmt.setString(2,avaliador.getLogin());
			stmt.setString(3, avaliador.getSenha());
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null ;
	}

	@Override
	public Entidade editar(Entidade entidade) {
		
		return null;
	}

	@Override
	public List<Entidade> listarTudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade pesquisarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
