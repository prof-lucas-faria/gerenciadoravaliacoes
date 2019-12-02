package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.ProjetoDAO;
import siapro.model.Entidade;
import siapro.model.Evento;
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
	
	public List<Projeto> pesquisarTitulo(Evento evento, String titulo) {
		Projeto projeto = new Projeto();
		projeto.setTitulo(titulo);
		projeto.setEvento(evento);
		List<Projeto> listaTitulo = new ProjetoDAO().pesquisarTitulo(projeto);
		return listaTitulo;
	}
	
	public Projeto desativarProjeto(Projeto projeto) {
		new ProjetoDAO().desativar(projeto);
		return projeto;
	}

}
