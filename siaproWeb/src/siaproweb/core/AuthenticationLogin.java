package siaproweb.core;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import siaproweb.dao.OrganizadorDAO;
import siaproweb.model.Organizador;

@ManagedBean
@SessionScoped
public class AuthenticationLogin {
	//O tipo deste atributo pode ser alterado para usuarios diferentes
	private static Organizador user;
	
	private static SystemResult validateLogin(String login) {
		//O tipo desta variavel e o metodo de busca pode ser alterado para usuarios diferentes
		Organizador userTransitory = new OrganizadorDAO().pesquisarLogin(login);
		//O metodo usado pode ser substituido por outro correspondente
		if(userTransitory.getId() != 0) {
			user = userTransitory;
			return SystemSuccess.ACCEPTED_LOGIN;			
		}
		else {
			return SystemError.INVALID_LOGIN;
		}
	}
	
	private static SystemResult validatePassword(String password) {
		//O metodo usado pode ser substituido por outro correspondente
		if(user.getSenha().equals(EncryptMD5.encryptText(password))) {
			//O atributo 'userLogged' serve para verificar se o login foi sucedido
			//SessionContext.getInstance().setAttribute("userLogged", true);
			//O atributo 'userObject' guarda uma instancea do usuario logado
			//SessionContext.getInstance().setAttribute("userObject", user);
			return SystemSuccess.ACCEPTED_PASSWORD;
		}
		return SystemError.INVALID_PASSWORD;
	}
	
	public static SystemResult authenticateLogin(String login, String password) {
		if(validateLogin(login) == SystemSuccess.ACCEPTED_LOGIN) {
			return validatePassword(password);
		}
		else {
			return validatePassword(password);
		}
	}
}
