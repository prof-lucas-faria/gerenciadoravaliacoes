package siaproweb.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import siaproweb.dao.CategoriaDAO;
import siaproweb.model.Categoria;
import siaproweb.model.Criterio;

@ManagedBean
@RequestScoped
public class TesteController {
	public Categoria categoria;
	
	public TesteController() {
		System.out.println("teste");
		this.categoria = (Categoria) new CategoriaDAO().pesquisarId(1);
		categoria.carregarCriterios();
	}
	
	public String gravar() {
		for (Criterio criterio : categoria.getCriterios()) {
			
		}
		return "Pronto";
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}