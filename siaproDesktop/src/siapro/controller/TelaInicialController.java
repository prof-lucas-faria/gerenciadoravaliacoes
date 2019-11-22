package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.EventoDAO;
import siapro.dao.OrganizadorDAO;
import siapro.model.Entidade;
import siapro.model.Evento;
import siapro.model.Organizador;

public class TelaInicialController {

	public List<Evento> listarEventos() {
		Organizador o = (Organizador) new OrganizadorDAO().pesquisarId(5);
		List<Entidade> entidades = new EventoDAO().listarTudo(o);
		List<Evento> eventos = new ArrayList<Evento>();
		
		for (Entidade entidade : entidades) {
			Evento e = (Evento) entidade;
			eventos.add(e);
		}
		
		return eventos;
	}
}
