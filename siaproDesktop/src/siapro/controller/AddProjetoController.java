package siapro.controller;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import siapro.dao.AreaDAO;
import siapro.dao.CategoriaDAO;
import siapro.dao.EventoDAO;
import siapro.dao.OrganizadorDAO;
import siapro.dao.ProjetoDAO;
import siapro.model.Categoria;
import siapro.model.Entidade;
import siapro.model.Evento;
import siapro.model.Organizador;
import siapro.model.Projeto;

public class AddProjetoController {
	

		public List<Categoria> listarCategoria(Entidade e) {
		List<Categoria> a = new ArrayList<Categoria>();
		List<Entidade>	en =	new CategoriaDAO().listarTudo(e);
		for (Entidade entidade : en) {
			a.add((Categoria)entidade);
		}
		return a;
	}
		
	    public List<Area> listarAreas(Entidade e) {
		List<Area> b = new ArrayList<Area>();
		List<Entidade>	en =	new AreaDAO().listarTudo(e);
		for (Entidade entidade : en) {
			b.add((Area)entidade);
		}
		return b;
	}
	public void salvarProjeto(String titulo,String autores, Categoria a, Area b) {		
				
		Projeto proj = new Projeto();
		proj.setTitulo(titulo);
		proj.setAutores(autores);
		proj.getCategoria();
		proj.getArea();
		new ProjetoDAO().salvar(proj);
	}

}