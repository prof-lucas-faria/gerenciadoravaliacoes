package siaproweb.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginController {
	
	public boolean validarLogin(String login, String senha) {
		
		return true;
	}
}
