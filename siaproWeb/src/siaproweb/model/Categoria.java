package siapro.model;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.CriterioDAO;


public class Categoria implements Entidade {
	private long id;
	private String nome;
	private ArrayList<Criterio> criterios;
	private int qntMinAvalProjeto;
	private int qntMaxAvalProjeto;
	private Evento evento;
	
	public Categoria(long id, String nome, ArrayList<Criterio> criterios) {;
		this.id = id;
		this.nome = nome;
		this.criterios = criterios;
	}
	
	public Categoria(String nome, ArrayList<Criterio> criterios) {
		this.nome = nome;
		this.criterios = criterios;
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNome();
	}
	
	public Categoria() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQntMinAvalProjeto() {
		return qntMinAvalProjeto;
	}

	public void setQntMinAvalProjeto(int qntMinAvalProjeto) {
		this.qntMinAvalProjeto = qntMinAvalProjeto;
	}

	public int getQntMaxAvalProjeto() {
		return qntMaxAvalProjeto;
	}

	public void setQntMaxAvalProjeto(int qntMaxAvalProjeto) {
		this.qntMaxAvalProjeto = qntMaxAvalProjeto;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Criterio> getCriterios() {
		return criterios;
	}
	
	public void carregarCriterios() {
		this.criterios = new ArrayList<>();
		List<Entidade> entidades = new CriterioDAO().listarTudo(this);
		for (Entidade entidade : entidades) {
			this.criterios.add((Criterio) entidade);
		}
	}
	
	public void setCriterios(ArrayList<Criterio> criterios) {
		this.criterios = criterios;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento e) {
		this.evento = e;
	}
	
	
}
