package siapro.model;

public class Area implements Entidade{
	private long id;
	private String nome;
	private Evento evento;
	private String descricao;
	
	
	
	public Area(String nome) {
		super();
		this.nome = nome;
	}
	
	
	public Area() {
		super();
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
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}
