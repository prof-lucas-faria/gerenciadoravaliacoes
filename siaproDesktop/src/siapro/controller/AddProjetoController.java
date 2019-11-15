package siapro.controller;

import siapro.dao.AreaDAO;
import siapro.dao.CategoriaDAO;
import siapro.dao.ProjetoDAO;
import siapro.model.Projeto;

public class AddProjetoController {


	public void salvarProjeto(String titulo,String autores, String categoria, String area) {
		
		CategoriaDAO catdao = new CategoriaDAO();
		
		AreaDAO ardao = new AreaDAO();
				
		Projeto proj = new Projeto();
		proj.setTitulo(titulo);
		proj.setAutores(autores);
		proj.setCategoria(catdao.pesquisarNome(categoria));
		proj.setArea(ardao.pesquisarNome(area));
	
		
		new ProjetoDAO().salvar(proj);
	}

}