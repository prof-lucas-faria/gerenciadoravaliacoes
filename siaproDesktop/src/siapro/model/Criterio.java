package siapro.model;

public class Criterio implements Entidade{
	private long id;
	private String descricao;
	private int notaMinima;
	private int notaMaxima;
	
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
	public int getNotaMinima() {
		return notaMinima;
	}
	public void setNotaMinima(int notaMinima) {
		this.notaMinima = notaMinima;
	}
	public int getNotaMaxima() {
		return notaMaxima;
	}
	public void setNotaMaxima(int notaMaxima) {
		this.notaMaxima = notaMaxima;
	}
	
	
}
