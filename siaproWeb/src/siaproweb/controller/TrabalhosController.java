package siaproweb.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import siaproweb.core.SessionContext;
import siaproweb.dao.ProjetoDAO;
import siaproweb.model.Avaliador;
import siaproweb.model.Evento;
import siaproweb.model.Projeto;

@ManagedBean 
public class TrabalhosController {
	
	private Avaliador avaliador = ((Avaliador) SessionContext.getInstance().getAttribute("userObject"));
	
	private Evento evento = ((Evento) SessionContext.getInstance().getAttribute("userObject"));
	
	public List<Projeto> listarTrabalhosAvaliador() {
		List<Projeto> lp = new ProjetoDAO().pesquisarProjetoAvaliador(this.avaliador, this.evento);		
		return lp;
	} 

	public String AvaliarProjeto() {
		
		return "Avaliacao?faces-redirect=true";
	}
}
