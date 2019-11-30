package siapro.controller;

import java.util.List;

import siapro.dao.CategoriaDAO;
import siapro.model.Categoria;
import siapro.model.Criterio;
import siapro.model.Evento;

public class CategoriaController {

	public Categoria salvarCategoria(Categoria categoria) {
		if(categoria.getId() == 0) {
			return (Categoria) new CategoriaDAO().salvar(categoria);
		}
		else {
			new CategoriaDAO().editar(categoria);
			return categoria;
		}
	}
	
	public List<Categoria> listarCategoria(Evento evento) {
		evento.carregarCategorias();
		return evento.getCategorias();
	}
	
	public List<Criterio> listarCriterio(Categoria categoria) {
		categoria.carregarCriterios();
		return categoria.getCriterios();
	}

	public void deletarCategoria(Categoria categoria) {
		new CategoriaDAO().deletar(categoria);
	}

}
