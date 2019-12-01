package siaproweb.core;

public enum SystemError implements SystemResult{
	INVALID_LOGIN("Login invalido - usuario inexistente"),
	INVALID_PASSWORD("Senha invalida - senha incorreta");
	
	private String description;
	
	SystemError(String description){
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
}
