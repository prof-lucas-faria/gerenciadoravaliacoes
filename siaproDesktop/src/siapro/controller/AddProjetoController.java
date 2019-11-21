package siapro.controller;

import siapro.dao.AreaDAO;
import siapro.dao.CategoriaDAO;
import siapro.dao.ProjetoDAO;
import siapro.model.Projeto;

public class AddProjetoController {


	public void salvarProjeto(String titulo,String autores, Categoria categoria, Area area) {
		
		CategoriaDAO catdao = new CategoriaDAO();
		
		AreaDAO ardao = new AreaDAO();
				
		Projeto proj = new Projeto();
		proj.setTitulo(titulo);
		proj.setAutores(autores);
		proj.setCategoria(catdao.pesquisarPorEvento(categoria));
		proj.setArea(ardao.pesquisarporEvento(area));
	
		
		new ProjetoDAO().salvar(proj);
	}

}