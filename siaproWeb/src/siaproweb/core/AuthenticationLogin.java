package siaproweb.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class AuthenticationLogin {
	private static Object user;
	private static Object dao;
	private static String methodDAO;
	
	public AuthenticationLogin(Object userDao, String methodConsultDao) {
		dao = userDao;
		methodDAO = methodConsultDao;
	}
	
	public SystemResult authenticateLogin(Object userInserted, String methodGetLogin, String methodGetPassword) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(validateLogin(userInserted, methodGetLogin) == SystemSuccess.ACCEPTED_LOGIN) {
			return validatePassword(userInserted, methodGetPassword);
		}
		else {
			return validateLogin(userInserted, methodGetLogin);
		}
	}
	
	private static SystemResult validateLogin(Object userInserted, String methodGetLogin) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Object userTransitory = consultUser(userInserted);
		if(getLogin(userInserted, methodGetLogin).equals(getLogin(userTransitory, methodGetLogin))) {
			user = userTransitory;
			return SystemSuccess.ACCEPTED_LOGIN;			
		}
		else {
			return SystemError.INVALID_LOGIN;
		}
	}
	
	private static SystemResult validatePassword(Object userInserted, String methodGetPassword) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(getPassword(userInserted, methodGetPassword).equals(getPassword(user, methodGetPassword))) {
			SessionContext.getInstance().setAttribute("userLogged", true);
			SessionContext.getInstance().setAttribute("userObject", user);
			return SystemSuccess.ACCEPTED_PASSWORD;
		}
		return SystemError.INVALID_PASSWORD;
	}
	
	private static String getPassword(Object userData, String methodGetPassword) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	 	try{
		 	Class<?> classe = Class.forName(userData.getClass().getName());
		    return (String) classe.getMethod(methodGetPassword).invoke(userData);
		}catch(ClassNotFoundException cnfe){
			System.err.println("Erro: " + cnfe);
		}
		return null;
	}
	
	private static String getLogin(Object userInserted, String methodGetLogin) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	 	try{
		 	Class<?> classe = Class.forName(userInserted.getClass().getName());
		 	Method metodox = classe.getMethod(methodGetLogin);
		    return (String) metodox.invoke(userInserted);
		}catch(ClassNotFoundException cnfe){
			System.err.println("Erro: " + cnfe);
		}
		return null;
	}
	
	private static Object consultUser(Object userInserted) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	 	try{
		 	Class<?> classeDAO = Class.forName(dao.getClass().getName());
		 	Method metodox = null;
			for (Method metodo : classeDAO.getMethods()) {
		 		if(metodo.getName().equals(methodDAO)) {
		 			metodox = metodo;
		 			break;
		 		}
		 	}
		    return (Object) metodox.invoke(dao, userInserted);
		}catch(ClassNotFoundException cnfe){
			System.err.println("Erro: " + cnfe);
		}
		return null;
	} 
	
}
