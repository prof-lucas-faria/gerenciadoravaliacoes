package siapro.controller;


import java.util.ArrayList;

import java.util.List;

import siapro.dao.AreaDAO;
import siapro.dao.CategoriaDAO;
import siapro.dao.EventoDAO;
import siapro.dao.OrganizadorDAO;
import siapro.dao.ProjetoDAO;
import siapro.model.Area;
import siapro.model.Categoria;
import siapro.model.Entidade;
import siapro.model.Evento;
import siapro.model.Organizador;
import siapro.model.Projeto;
import siapro.model.Area;

public class AddProjetoController {
	

	public List<Categoria> listarCategoria(Evento evento) {
		evento.carregarCategorias();
		return evento.getCategorias();
	}
		
	public List<Area> listarAreas(Evento evento) {
	    evento.carregarAreas();
		return evento.getAreas();
	}
	public void salvarProjeto(String titulo, String autores, Categoria categoria, Area area) {		
		Projeto proj = new Projeto();
		proj.setTitulo(titulo);
		proj.setAutores(autores);
		proj.getCategoria();
		proj.getArea();
		new ProjetoDAO().salvar(proj);
	}

}