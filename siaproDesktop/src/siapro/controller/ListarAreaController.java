package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.AreaDAO;
import siapro.model.Area;
import siapro.model.Entidade;

public class ListarAreaController {
	
	public List<Area> listarAreas(Entidade e) {
		List<Area> a = new ArrayList<Area>();
		List<Entidade>	en =	new AreaDAO().listarTudo(e);
		for (Entidade entidade : en) {
			a.add((Area)entidade);
		}
		return a;
	}

}
