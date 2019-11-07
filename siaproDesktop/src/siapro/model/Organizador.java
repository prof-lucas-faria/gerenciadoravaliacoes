package siapro.model;

public class Organizador extends Pessoa implements Entidade {
	String email;
	
	
	public Organizador(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	
	
}
