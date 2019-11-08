package siapro.model;

public class Criterio implements Entidade{
	private long id;
	private String descricao;
	private String nome;
	private double notaMinima;
	private double notaMaxima;
	private Categoria categoria;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getNotaMinima() {
		return notaMinima;
	}
	public void setNotaMinima(double notaMinima) {
		this.notaMinima = notaMinima;
	}
	public double getNotaMaxima() {
		return notaMaxima;
	}
	public void setNotaMaxima(double notaMaxima) {
		this.notaMaxima = notaMaxima;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
