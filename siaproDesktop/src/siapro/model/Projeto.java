package siapro.model;

import java.util.List;

import siapro.dao.AvaliacaoDAO;

public class Projeto {
	private long id;
	private String titulo;
	private String autores;
	private List<Avaliacao> avaliacoes;
	private Area area;
	private Categoria categoria;
	private Evento evento;
	
	public Projeto(){
		
	}
	
	public Projeto(long id, String titulo, String autores, List<Avaliacao> avaliacoes, Evento evento, Area area, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autores = autores;
		this.avaliacoes = avaliacoes;
		this.area = area;
		this.categoria = categoria;
		this.evento = evento;
	}
	public Projeto(String titulo, String autores, List<Avaliacao> avaliacoes, Evento evento, Area area, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.avaliacoes = avaliacoes;
		this.area = area;
		this.categoria = categoria;
		this.evento = evento;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public void carregarAvaliacoes(Projeto projeto) {
		List<Avaliacao> avaliacoes = new AvaliacaoDAO().pesquisarPorProjeto(projeto);
		this.setAvaliacoes(avaliacoes);
	}
	
	
}
