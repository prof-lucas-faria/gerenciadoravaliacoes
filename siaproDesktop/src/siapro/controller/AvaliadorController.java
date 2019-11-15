package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.AvaliadorDAO;
import siapro.model.Avaliador;
import siapro.model.Entidade;

public class AvaliadorController {
	
	public List<Avaliador> listarAvaliadores(Entidade e) {
		List<Avaliador> a = new ArrayList<Avaliador>();
		List<Entidade>	en =	new AvaliadorDAO().listarTudo(e);
		for (Entidade entidade : en) {
			a.add((Avaliador)entidade);
		}
		return a;
	}

}
