package siapro.model;

import java.util.ArrayList;

public class Avaliador implements Entidade {
	private long id;
	private String nome;
	private String login;
	private String senha;
	private ArrayList<Area> area;

	public Avaliador(long id, String nome, String login, String senha, ArrayList<Area> area) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.area = area;
	}
	
	public Avaliador(String nome, String login, String senha, ArrayList<Area> area) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.area = area;
	}
	
	public Avaliador(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	public Avaliador() {
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public ArrayList<Area> getArea() {
		return area;
	}
	public void setArea(ArrayList<Area> area) {
		this.area = area;
	}
}
