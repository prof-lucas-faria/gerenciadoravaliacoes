package siapro.model;

import java.util.List;

public class Evento {
	private long id;
	private String nome;
	private String informacoes;
	private int quantMinAvalProjeto;
	private int quantMaxAvalProjeto;
	private boolean liberado;
	private List<Projeto> area;
	private List<Avaliador> avaliadores;
	private List<Organizador> organizadores;
	private List<Area> areas;
	private List<Categoria> categorias;
	
	public Evento(long id, String nome, String informacoes, int quantMinAvalProjeto, int quantMaxAvalProjeto,
			boolean liberado, List<Projeto> projetos, List<Avaliador> avaliadores, List<Organizador> organizadores,
			List<Area> areas, List<Categoria> categorias) {
	
		this.id = id;
		this.nome = nome;
		this.informacoes = informacoes;
		this.quantMinAvalProjeto = quantMinAvalProjeto;
		this.quantMaxAvalProjeto = quantMaxAvalProjeto;
		this.liberado = liberado;
		this.area = projetos;
		this.avaliadores = avaliadores;
		this.organizadores = organizadores;
		this.areas = areas;
		this.categorias = categorias;
	}

	public Evento(String nome, String informacoes, int quantMinAvalProjeto, int quantMaxAvalProjeto, boolean liberado,
			List<Projeto> area, List<Avaliador> avaliadores, List<Organizador> organizadores, List<Area> areas,
			List<Categoria> categorias) {
		super();
		this.nome = nome;
		this.informacoes = informacoes;
		this.quantMinAvalProjeto = quantMinAvalProjeto;
		this.quantMaxAvalProjeto = quantMaxAvalProjeto;
		this.liberado = liberado;
		this.area = area;
		this.avaliadores = avaliadores;
		this.organizadores = organizadores;
		this.areas = areas;
		this.categorias = categorias;
	}
	
	
	
}
