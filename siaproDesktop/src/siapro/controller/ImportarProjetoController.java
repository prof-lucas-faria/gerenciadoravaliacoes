package siapro.controller;

import java.util.List;

import siapro.dao.ProjetoDAO;
import siapro.model.Projeto;

public class ImportarProjetoController {

	public void inserirProjeto(List<Projeto> projetos) {
		for (int i = 0; i < projetos.size(); i++) {
			new ProjetoDAO().salvar(projetos.get(i));
		}
	}
	
}
