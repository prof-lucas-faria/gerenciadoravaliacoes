package siapro.model;

import java.util.List;

public class Evento implements Entidade {
	private long id;
	private String nome;
	private String informacoes;
	private boolean liberado;
	private List<Projeto> area;
	private List<Avaliador> avaliadores;
	private List<Organizador> organizadores;
	private List<Area> areas;
	private List<Categoria> categorias;
	
	public Evento(long id, String nome, String informacoes,
			boolean liberado, List<Projeto> projetos, List<Avaliador> avaliadores, List<Organizador> organizadores,
			List<Area> areas, List<Categoria> categorias) {
	
		this.id = id;
		this.nome = nome;
		this.informacoes = informacoes;
		this.liberado = liberado;
		this.area = projetos;
		this.avaliadores = avaliadores;
		this.organizadores = organizadores;
		this.areas = areas;
		this.categorias = categorias;
	}

	public Evento(String nome, String informacoes, boolean liberado,
			List<Projeto> area, List<Avaliador> avaliadores, List<Organizador> organizadores, List<Area> areas,
			List<Categoria> categorias) {
		super();
		this.nome = nome;
		this.informacoes = informacoes;
		this.liberado = liberado;
		this.area = area;
		this.avaliadores = avaliadores;
		this.organizadores = organizadores;
		this.areas = areas;
		this.categorias = categorias;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public boolean isLiberado() {
		return liberado;
	}

	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}

	public List<Projeto> getArea() {
		return area;
	}

	public void setArea(List<Projeto> area) {
		this.area = area;
	}

	public List<Avaliador> getAvaliadores() {
		return avaliadores;
	}

	public void setAvaliadores(List<Avaliador> avaliadores) {
		this.avaliadores = avaliadores;
	}

	public List<Organizador> getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(List<Organizador> organizadores) {
		this.organizadores = organizadores;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
}
