package siapro.controller;

import java.util.List;

import siapro.dao.AvaliadorDAO;
import siapro.model.Avaliador;

public class ImportarAvaliadorController {

	public void salvarAvaliadores(List<Avaliador> avaliadores) {
		int i;
		for(i=0; i<avaliadores.size();i++) {
			new AvaliadorDAO().salvar(avaliadores.get(i));
		}
	}
	
}
