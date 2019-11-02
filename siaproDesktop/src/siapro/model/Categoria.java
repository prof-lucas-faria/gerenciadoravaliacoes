package siapro.model;

import java.util.ArrayList;

public class Categoria {
	private long id;
	private String nome;
	private ArrayList<Criterio> criterios;
	
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
	
	public Categoria(String nome, ArrayList<Criterio> criterios) {
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
	public ArrayList<Criterio> getCriterios() {
		return criterios;
	}
	
	public void setCriterios(ArrayList<Criterio> criterios) {
		this.criterios = criterios;
	}	
}
