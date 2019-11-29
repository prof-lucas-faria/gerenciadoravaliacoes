package siapro.controller;

import java.util.List;

import siapro.dao.CategoriaDAO;
import siapro.model.Categoria;
import siapro.model.Criterio;
import siapro.model.Evento;

public class CategoriaController {

	public void salvarCategoria(long id, String nome, String maximo, String minimo) {
		Categoria cat = new Categoria();
		cat.setId(id);
		cat.setNome(nome);
		cat.setQntMaxAvalProjeto(Integer.parseInt(maximo));
		cat.setQntMinAvalProjeto(Integer.parseInt(minimo));
		if(cat.getId() == 0) {
			new CategoriaDAO().salvar(cat);			
		}
		else {
			new CategoriaDAO().editar(cat);	
		}
	}
	
	public void editarCategoria(Categoria categoria) {
		new CategoriaDAO().editar(categoria);		
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
	
	public Categoria atualizarCategoria(Categoria categoria) {
		return (Categoria) new CategoriaDAO().pesquisarId(categoria.getId());
	}

}
