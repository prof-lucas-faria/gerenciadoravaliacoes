package siapro.dao;

import java.util.List;

import siapro.model.Categoria;
import siapro.model.Entidade;
import siapro.model.Evento;

public interface InterfaceDAO {
	
	public Entidade salvar(Entidade entidade);
	
	public Entidade editar(Entidade entidade);
	
	public List<Entidade> listarTudo(Entidade entidade);
	
	public Entidade pesquisarId(long id);

	List<Categoria> pesquisarPorEvento(Evento evento);


}
