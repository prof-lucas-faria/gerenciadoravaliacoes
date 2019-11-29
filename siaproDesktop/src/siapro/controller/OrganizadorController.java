package siapro.controller;

import siapro.dao.OrganizadorDAO;
import siapro.model.Organizador;
import siapro.model.Pessoa;

public class OrganizadorController {

	public void salvarOrganizador(String nome, String email, String senha) {
		Organizador o = new Organizador(email);
		o.setSenha(senha);
		o.setNome(nome);
		new OrganizadorDAO().salvar(o);
	}
	
}
