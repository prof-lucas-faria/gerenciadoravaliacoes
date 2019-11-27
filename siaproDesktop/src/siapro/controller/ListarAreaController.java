package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.AreaDAO;
import siapro.model.Area;
import siapro.model.Entidade;

public class ListarAreaController {
	
	public List<Area> listarAreas(Entidade e) {
		List<Area> listaArea = new ArrayList<Area>();
		List<Entidade>	listaEnt =	new AreaDAO().listarTudo(e);
		for (Entidade entidade : listaEnt) {
			listaArea.add((Area)entidade);
		}
		return listaArea;
	}

}
