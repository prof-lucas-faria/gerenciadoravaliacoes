package siaproweb.controller;

import java.lang.reflect.InvocationTargetException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import siaproweb.core.AuthenticationLogin;
import siaproweb.core.EncryptMD5;
import siaproweb.dao.AvaliadorDAO;
import siaproweb.model.Avaliador;

@ManagedBean
@SessionScoped
public class AutenticacaoController {
	private Avaliador avaliador;
	
	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

	public AutenticacaoController() {
		this.avaliador = new Avaliador();
	}

	public String efetuarLogin() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		avaliador.setSenha(EncryptMD5.encryptText(avaliador.getSenha()));
		AuthenticationLogin autenticador = new AuthenticationLogin(new AvaliadorDAO(), "pesquisarLogin");
		System.out.println(autenticador.authenticateLogin(avaliador, "getLogin", "getSenha"));
		return "Home";
	}
}
