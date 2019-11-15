package siapro.controller;

import siapro.dao.CategoriaDAO;
import siapro.model.Categoria;

public class AddProjetoController {

	public void salvarCategoria(String nome, String maximo, String minimo) {
		Categoria cat = new Categoria();
		cat.setNome(nome);
		cat.setQntMaxAvalProjeto(Integer.parseInt(maximo));
		cat.setQntMinAvalProjeto(Integer.parseInt(minimo));
		
		new CategoriaDAO().salvar(cat);
	}

}