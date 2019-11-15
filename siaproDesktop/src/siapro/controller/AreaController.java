package siapro.controller;

import siapro.dao.AreaDAO;
import siapro.model.Area;

public class AreaController {

	public void salvarArea(String nome, String descricao) {
		Area area = new Area();
		area.setNome(nome);
		area.setDescricao(descricao);
		
		new AreaDAO().salvar(area);		
	}

}
