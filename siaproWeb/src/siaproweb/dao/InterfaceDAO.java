package siaproweb.dao;

import java.util.List;

import siaproweb.model.Entidade;

public interface InterfaceDAO {
	
	public Entidade salvar(Entidade entidade);
	
	public Entidade editar(Entidade entidade);
	
	public List<Entidade> listarTudo(Entidade entidade);
	
	public Entidade pesquisarId(long id);

}
