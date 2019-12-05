package siapro.controller;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.AreaDAO;
import siapro.model.Area;
import siapro.model.Entidade;
import siapro.model.Evento;

public class AreaController {
	
	public void salvarArea(String nome, Evento evento, String descricao, long idArea) {
		Area area = new Area();
		area.setNome(nome);
		area.setEvento(evento);
		area.setDescricao(descricao);
		area.setId(idArea);
		if(area.getId() == 0) {
			new AreaDAO().salvar(area);	
		}else {
			new AreaDAO().editar(area);		
		}
	}
	
	public void deletarArea(Area area) {
		new AreaDAO().deletar(area);		
	}
	
	public Area atualizarArea(Area area) {
		return (Area) new AreaDAO().pesquisarId(area.getId());
	}
}
