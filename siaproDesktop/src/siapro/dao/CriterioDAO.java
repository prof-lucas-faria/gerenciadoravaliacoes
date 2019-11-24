package siapro.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import siapro.conexao.Conexao;
import siapro.model.Avaliacao;
import siapro.model.Categoria;
import siapro.model.Criterio;
import siapro.model.Entidade;

public class CriterioDAO implements InterfaceDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public CriterioDAO() {
		Conexao conn = new Conexao();
		this.conexao = conn.getConexao();
	}
	@Override
	public Entidade salvar(Entidade entidade) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO criterio(descricao,notaMinima,NotaMaxima,idCategoria, nome) VALUES(?,?,?,?,?)";
		try {
			Criterio c = (Criterio) entidade;
			this.stmt = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			this.stmt.setString(1, c.getDescricao());
			this.stmt.setDouble(2, c.getNotaMinima());
			this.stmt.setDouble(3, c.getNotaMaxima());
			this.stmt.setLong(4, c.getCategoria().getId());
			this.stmt.setString(5, c.getNome());
			this.stmt.execute();
			
			ResultSet rs = this.stmt.getGeneratedKeys();
			if(rs.next()) {
				c.setId(rs.getInt(1));
			}
			this.stmt.close();
			
			return c;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Entidade editar(Entidade entidade) {
		// TODO Auto-generated method stub
		String sql = "UPDATE FROM criterio SET nome = ?, descricao = ?, notaMaxima = ?, notaMinima = ?, idCategoria = ? WHERE id = ?";
		try {
			Criterio criterio = (Criterio) entidade;
			this.stmt = conexao.prepareStatement(sql);
			this.stmt.setString(1, criterio.getNome());
			this.stmt.setString(2, criterio.getDescricao());
			this.stmt.setDouble(3, criterio.getNotaMaxima());
			this.stmt.setDouble(4, criterio.getNotaMinima());
			this.stmt.setLong(5, criterio.getCategoria().getId());
			this.stmt.setLong(6, criterio.getId());
			this.stmt.execute();
			this.stmt.close();
			return criterio;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Entidade> listarTudo(Entidade entidade) {
		// TODO Auto-generated method stub
		Categoria categoria = (Categoria) entidade;
		String sql = "SELECT * FROM criterio WHERE id = ?";
		try {
			this.stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = this.stmt.executeQuery();
			this.stmt.setLong(1, categoria.getId());
			List<Entidade> criterios =  new ArrayList<Entidade>();
			
			while(rs.next()) {
				Criterio criterio = new Criterio(rs.getLong("id"), rs.getString("descricao"), rs.getString("nome"),  rs.getDouble("notaMinima"), rs.getDouble("notaMaxima"));
				CategoriaDAO ctDAO =  new CategoriaDAO();
				Categoria ct =(Categoria) ctDAO.pesquisarId(rs.getLong("idCategoria"));
				criterio.setCategoria(ct);
				criterios.add(criterio);
			}
			this.stmt.close();
			return criterios;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Entidade pesquisarId(long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM criterio WHERE id = ?";
		try {
			this.stmt = this.conexao.prepareStatement(sql);
			this.stmt.setLong(1, id);
			ResultSet rs = this.stmt.executeQuery();
			Criterio criterio =  new Criterio();
			if(rs.next()) {
				criterio = new Criterio(rs.getLong("id"), rs.getString("descricao"), rs.getString("nome"),  rs.getDouble("notaMinima"), rs.getDouble("notaMaxima"));
				CategoriaDAO ctDAO =  new CategoriaDAO();
				Categoria ct =(Categoria) ctDAO.pesquisarId(rs.getLong("idCategoria"));
				criterio.setCategoria(ct);
			}
			this.stmt.close();
			return criterio;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Criterio> pesquisarPorAvalicao(Avaliacao avaliacao) {
		String sql = "SELECT * FROM criterio c INNER JOIN avaliacaocriterio ON c.id = ac.idCriterio INNER JOIN avaliacao a ON a.id = ac.idAvaliacao WHERE a.id = ?";
		try {
			this.stmt = conexao.prepareStatement(sql);
			ResultSet rs = this.stmt.executeQuery();
			this.stmt.setLong(1, avaliacao.getId());
			List<Criterio> criterios =  new ArrayList<Criterio>();
			while(rs.next()) {
				Criterio criterio = new Criterio(rs.getLong("id"), rs.getString("descricao"), rs.getString("nome"),  rs.getDouble("notaMinima"), rs.getDouble("notaMaxima"));
				CategoriaDAO ctDAO =  new CategoriaDAO();
				Categoria ct =(Categoria) ctDAO.pesquisarId(rs.getLong("idCategoria"));
				criterio.setCategoria(ct);
				criterios.add(criterio);
			}
			this.stmt.close();
			return criterios;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}