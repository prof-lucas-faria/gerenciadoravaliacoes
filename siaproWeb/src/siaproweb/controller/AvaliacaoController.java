package siaproweb.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import siaproweb.dao.AvaliacaoDAO;
import siaproweb.dao.AvaliadorDAO;
import siaproweb.dao.ProjetoDAO;
import siaproweb.model.Avaliacao;
import siaproweb.model.Categoria;
import siaproweb.model.Criterio;
import siaproweb.model.Projeto;
@ManagedBean
@SessionScoped

public class AvaliacaoController {
	private Projeto projeto;
	private Categoria categoria;
	private Criterio criterio;
	//private List<Criterio> criterios;
	private Avaliacao avaliacao;
	
	public AvaliacaoController() {
		Projeto p = (Projeto) new ProjetoDAO().pesquisarId(1);
		this.projeto = p;
		Categoria c = new CategoriaController().pesquisarPorProjeto(this.projeto);
		c.carregarCriterios();
		this.categoria = c;
		//this.criterios = c.getCriterios();
		
	}
	public void voltar() {
		System.out.println("Voltar");
		//return "ListarTrabalhos";
	}
	
	/*public void avaliar() {
		for(Criterio c : this.criterios) {
			System.out.println(c.getNota());
		}
		
	}*/
	
	public void salvarAvaliacao() {
		this.avaliacao = new Avaliacao();
		//System.out.println(this.avaliacao.getCriterios().get(1).getNota());
		this.avaliacao.setCriterios(this.categoria.getCriterios());
		this.avaliacao.setProjeto(this.projeto);
		this.avaliacao.setAvaliacao(true);
		double nota = 0;
		for(Criterio c : this.categoria.getCriterios()) {
			 nota += c.getNota();
		}
		this.avaliacao.setNota(nota);
		System.out.println("A nota Final é: " + this.avaliacao.getNota());
		//new AvaliadorDAO().salvar(this.avaliacao);
	}
	public Projeto getProjeto() {
		
		return projeto;
	}

	public void setPprojeto(Projeto p) {
		this.projeto = p;
	}
	/*public void pesquisarCategoria() {
		Categoria c = new CategoriaController().pesquisarPorProjeto(this.projeto);
		this.categoria = c;
	}*/
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	/*public List<Criterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}*/
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
}
