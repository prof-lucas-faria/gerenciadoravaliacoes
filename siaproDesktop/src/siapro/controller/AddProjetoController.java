package siapro.controller;

import siapro.dao.ProjetoDAO;
import siapro.model.Projeto;

public class AddProjetoController {
	
	

	public void salvarProjeto(String titulo,String autores, Categoria categoria, Area area) {
		Projeto proj = new Projeto();
		proj.setTitulo(titulo);
		proj.setAutores(autores);
		proj.setCategoria(categoria);
	
	
		
		new ProjetoDAO().salvar(proj);
	}

}