package siaproweb.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import siaproweb.core.SessionContext;
import siaproweb.dao.AvaliacaoDAO;
import siaproweb.dao.AvaliadorDAO;
import siaproweb.dao.ProjetoDAO;
import siaproweb.model.Avaliacao;
import siaproweb.model.Avaliador;
import siaproweb.model.Categoria;
import siaproweb.model.Criterio;
import siaproweb.model.Projeto;
@ManagedBean
@RequestScoped

public class AvaliacaoController {
	private Projeto projeto;
	private Categoria categoria;
	private Avaliacao avaliacao;
	private Avaliador avaliador;
	 
	public AvaliacaoController() {
		Projeto p = (Projeto) new ProjetoDAO().pesquisarId(1); //Eu precisava do projetona seção pra pegar ele
		this.projeto = p;
		Categoria c = new CategoriaController().pesquisarPorProjeto(this.projeto);
		c.carregarCriterios();
		this.categoria = c;
		this.avaliador =(Avaliador) SessionContext.getInstance().getAttribute("userObject");
		//this.avaliador = (Avaliador) new AvaliadorDAO().pesquisarId(5); 
		
 	}
	public String voltar() {
		System.out.println("teste"); 
		//não sei por qual motivo esse método n funciona
		return "ListarTrabalhos";
	}
	
	public double calcularNota(List<Criterio> criterios) {
		double nota = 0;
		for(Criterio c : this.categoria.getCriterios()) {
			 nota += c.getNota();
		}
		nota = nota/this.categoria.getCriterios().size();
		return nota;
	}
	public void salvarAvaliacao() {
		this.avaliacao = new Avaliacao();
		this.avaliacao.setCriterios(this.categoria.getCriterios());
		this.avaliacao.setProjeto(this.projeto);
		this.avaliacao.setAvaliacao(true);
		this.avaliacao.setNota(this.calcularNota(this.avaliacao.getCriterios()));
		this.avaliacao.setAvaliador(this.avaliador);
		System.out.println("A nota Final é: " + this.avaliacao.getNota() + "Avaliado por" + this.avaliador.getNome());
		new AvaliacaoDAO().salvar(this.avaliacao);
	}
	public Projeto getProjeto() {
		return projeto;
	}

	public void setPprojeto(Projeto p) {
		this.projeto = p;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Avaliador getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}
}
