package siaproweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import siaproweb.core.SessionContext;
import siaproweb.dao.EventoDAO;
import siaproweb.model.Avaliador;
import siaproweb.model.Entidade;
import siaproweb.model.Evento;
import siaproweb.model.Projeto;

@ManagedBean
@RequestScoped

public class ListarEventoController {
	private Avaliador avaliador = ((Avaliador) SessionContext.getInstance().getAttribute("userObject"));
	
	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}
	
	public ArrayList <Evento> listarEventos(){
		List<Entidade> entidades = new EventoDAO().listarTudo(this.avaliador);
		ArrayList<Evento> eventos = new ArrayList <Evento>();
		for (Entidade entidade : entidades) {
			eventos.add((Evento) entidade);
		}
		return eventos;
	}
	
	public Projeto getProjeto() {	
		return getProjeto();
	}
}
