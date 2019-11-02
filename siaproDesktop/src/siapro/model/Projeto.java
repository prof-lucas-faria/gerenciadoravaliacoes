package siapro.model;

import java.util.List;

public class Projeto {
	private long id;
	private String titulo;
	private String autores;
	private List<Avaliacao> avaliacoes;
	private Area area;
	private Categoria categoria;
	
	public Projeto(long id, String titulo, String autores, List<Avaliacao> avaliacoes, Area area, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autores = autores;
		this.avaliacoes = avaliacoes;
		this.area = area;
		this.categoria = categoria;
	}
	public Projeto(String titulo, String autores, List<Avaliacao> avaliacoes, Area area, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.avaliacoes = avaliacoes;
		this.area = area;
		this.categoria = categoria;
	}
	
	
	
}
