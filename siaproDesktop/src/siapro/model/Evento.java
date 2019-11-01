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
	
}
