package siaproweb.core;

public enum SystemSuccess implements SystemResult {
	ACCEPTED_LOGIN("Login aceito - usuario encontrado no sistema"),
	ACCEPTED_PASSWORD("Senha aceita - senha compativel com usuario");
	
	private String description;
	
	private SystemSuccess(String description) {
		this.description = description;
	}	
	
	@Override
	public String toString() {
		return this.description;
	}
}
