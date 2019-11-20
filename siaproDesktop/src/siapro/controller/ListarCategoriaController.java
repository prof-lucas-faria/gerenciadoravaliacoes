package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.CategoriaDAO;
import siapro.model.Categoria;
import siapro.model.Entidade;

public class ListarCategoriaController {

	public List<Categoria> listarCategoria(Entidade e) {
		List<Categoria> a = new ArrayList<Categoria>();
		List<Entidade>	en =	new CategoriaDAO().listarTudo(e);
		for (Entidade entidade : en) {
			a.add((Categoria)entidade);
		}
		return a;
	}

}
