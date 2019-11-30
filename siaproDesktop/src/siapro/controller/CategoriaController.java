package siapro.controller;

import java.util.List;

import siapro.dao.CategoriaDAO;
import siapro.model.Categoria;
import siapro.model.Criterio;
import siapro.model.Evento;

public class CategoriaController {

	public Categoria salvarCategoria(String nome, String maximo, String minimo) {
		Categoria cat = new Categoria();
		cat.setNome(nome);
		cat.setQntMaxAvalProjeto(Integer.parseInt(maximo));
		cat.setQntMinAvalProjeto(Integer.parseInt(minimo));
		
		return (Categoria) new CategoriaDAO().salvar(cat);
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

}
