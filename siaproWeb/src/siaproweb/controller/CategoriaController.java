package siaproweb.controller;

import java.util.List;

import siaproweb.dao.CategoriaDAO;
import siaproweb.model.Categoria;
import siaproweb.model.Criterio;
import siaproweb.model.Evento;

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
