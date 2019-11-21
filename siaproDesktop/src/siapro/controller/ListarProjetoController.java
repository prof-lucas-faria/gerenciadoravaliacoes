package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.ProjetoDAO;
import siapro.model.Entidade;
import siapro.model.Projeto;

public class ListarProjetoController {
	
	public List<Projeto> listarProjeto(Entidade entidade) {
		List<Projeto> listaProjeto = new ArrayList<Projeto>();
		List<Entidade> listaEnt = new ProjetoDAO().listarTudo(entidade);
		for (Entidade entidades : listaEnt) {
			listaProjeto.add((Projeto)entidades);
		}
		return listaProjeto;
	}

}
