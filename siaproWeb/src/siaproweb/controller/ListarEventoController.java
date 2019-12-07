package siaproweb.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import siaproweb.core.SessionContext;
import siaproweb.model.Avaliador;
import siaproweb.model.Projeto;

@ManagedBean
@RequestScoped

public class ListarEventoController {
	private Avaliador avaliador;
	private Projeto projeto;
	
	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}
	
	public ListarEventoController(){
		this.avaliador = (Avaliador) SessionContext.getInstance().getAttribute("userObject");
	}
	
	public Projeto getProjeto() {	
		return getProjeto();
	}

	public void setPprojeto(Projeto proj) {
		this.projeto = proj;
	}
}
