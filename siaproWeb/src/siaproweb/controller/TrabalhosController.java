package siaproweb.controller;

import java.util.List;

import siaproweb.dao.ProjetoDAO;
import siaproweb.model.Avaliador;
import siaproweb.model.Evento;
import siaproweb.model.Projeto;

public class TrabalhosController {
	
	public List<Projeto> listarTrabalhosAvaliador(Evento e,Avaliador a ) {
		List<Projeto> lp = new ProjetoDAO().pesquisarProjetoAvaliador(a, e);		
		return lp;
	} 

}
