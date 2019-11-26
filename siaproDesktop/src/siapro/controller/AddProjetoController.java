package siapro.controller;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import siapro.dao.AreaDAO;
import siapro.dao.CategoriaDAO;
import siapro.dao.ProjetoDAO;
import siapro.model.Categoria;
import siapro.model.Entidade;
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
	public void salvarProjeto(String titulo,String autores, Categoria categoria, Area area) {		
		//CategoriaDAO catdao = new CategoriaDAO();
		
		//AreaDAO ardao = new AreaDAO();				
		Projeto proj = new Projeto();
		proj.setTitulo(titulo);
		proj.setAutores(autores);
		//List<Categoria> a = new ArrayList<Categoria>();
		//List<Area> b = new ArrayList<Area>();		
		//proj.setCategoria(catdao.pesquisarPorEvento(categoria));
		//proj.setArea(ardao.pesquisarporEvento(area));		
		new ProjetoDAO().salvar(proj);
	}
}