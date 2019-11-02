package siapro.model;

import java.util.ArrayList;

public class Avaliacao {
	private long id;
	private double nota;
	private boolean avaliacao;
	private Avaliador avaliador;
	private ArrayList<Criterio> criterios;
	
	public Avaliacao(long id, double nota, boolean avaliacao, Avaliador avaliador, ArrayList<Criterio> criterios) {
		this.id = id;
		this.nota = nota;
		this.avaliacao = avaliacao;
		this.avaliador = avaliador;
		this.criterios = criterios;
	}
	
	public Avaliacao(double nota, boolean avaliacao, Avaliador avaliador, ArrayList<Criterio> criterios) {
		this.nota = nota;
		this.avaliacao = avaliacao;
		this.avaliador = avaliador;
		this.criterios = criterios;
	}
	
	public Avaliacao(double nota, boolean avaliacao) {
		this.nota = nota;
		this.avaliacao = avaliacao;
	}
	
	public Avaliacao() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Avaliador getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public boolean isAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(boolean avaliacao) {
		this.avaliacao = avaliacao;
	}
	public ArrayList<Criterio> getCriterios() {
		return criterios;
	}
	public void setCriterios(ArrayList<Criterio> criterios) {
		this.criterios = criterios;
	}
}
