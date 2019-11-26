package siapro.controller;

import siapro.dao.AreaDAO;
import siapro.model.Area;
import siapro.model.Evento;

public class AreaController {

	public void salvarArea(String nome, Evento evento, String descricao) {
		Area area = new Area();
		area.setNome(nome);
		area.setEvento(evento);
		area.setDescricao(descricao);
		
		new AreaDAO().salvar(area);		
	}

}
