package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.AvaliadorDAO;
import siapro.dao.CategoriaDAO;
import siapro.model.Avaliador;
import siapro.model.Categoria;
import siapro.model.Entidade;
import siapro.model.Evento;

public class AvaliadorController {
	
	public List<Avaliador> listarAvaliadores(Entidade e) {
		List<Avaliador> a = new ArrayList<Avaliador>();
		List<Entidade>	en = new AvaliadorDAO().listarTudo(e);
		for (Entidade entidade : en) {
			a.add((Avaliador)entidade);
		}
			
		return a;
	}

}
