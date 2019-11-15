package siapro.controller;

import siapro.dao.ProjetoDAO;
import siapro.model.Projeto;

public class AddProjetoController {

	public void salvarProjeto(String titulo,String autores, String categoria, String area) {
		Projeto proj = new Projeto();
		proj.setTitulo(titulo);
		proj.setAutores(autores);
		
		
		new ProjetoDAO().salvar(proj);
	}

}