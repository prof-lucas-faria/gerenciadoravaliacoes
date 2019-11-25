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
		for (Entidade ent : listaEnt) {
			listaProjeto.add((Projeto)ent);
		}
		return listaProjeto;
	}
	
	public List<Projeto> pesquisarTitulo(Entidade entidade, String pesquisa) {
		List<Projeto> listaTitulo = new ArrayList<Projeto>();
		List<Entidade> listaEnt = new ProjetoDAO().pesquisarTitulo(entidade, pesquisa);
		for (Entidade ent : listaEnt) {
			listaTitulo.add((Projeto)ent);
		}
		return listaTitulo;
	}

}
