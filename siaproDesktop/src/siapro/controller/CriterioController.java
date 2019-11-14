package siapro.controller;

import siapro.dao.CriterioDAO;
import siapro.model.Criterio;

public class CriterioController {
	public void Salvar(String nome, String descricao, String notaMax, String notaMin) {
		double notaMaxima = Double.parseDouble(notaMax);
		double notaMinima = Double.parseDouble(notaMin);
		
		Criterio c = new Criterio();
		c.setNome(nome);
		c.setDescricao(descricao);
		c.setNotaMaxima(notaMaxima);
		c.setNotaMinima(notaMinima);
		new CriterioDAO().salvar(c);
	}
}