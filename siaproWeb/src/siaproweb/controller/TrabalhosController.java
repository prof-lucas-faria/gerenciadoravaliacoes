package siaproweb.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import siaproweb.dao.ProjetoDAO;
import siaproweb.model.Avaliador;
import siaproweb.model.Evento;
import siaproweb.model.Projeto;

@ManagedBean
public class TrabalhosController {
	
	public List<Projeto> listarTrabalhosAvaliador(Evento e,Avaliador a ) {
		List<Projeto> lp = new ProjetoDAO().pesquisarProjetoAvaliador(a, e);		
		return lp;
	} 

}
