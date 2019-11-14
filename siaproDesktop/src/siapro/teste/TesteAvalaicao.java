package siapro.teste;



import java.util.ArrayList;
import java.util.List;

import siapro.dao.AvaliadorDAO;
import siapro.model.Avaliador;
import siapro.model.Entidade;
import siapro.model.Evento;
import siapro.model.Area;

public class TesteAvalaicao {
	public static void main(String[] args) {
		
		/* Avaliador avaliador = new Avaliador();
		AvaliadorDAO avaliadorDAO = new AvaliadorDAO();
		
		Area area = new Area();
		area.setNome("Tecnologia");
		area.setDescricao("Area referente a tecnologia");
		area.setId(2);
		
		ArrayList<Area> areas = new ArrayList<Area>();
		areas.add(area);

		
		avaliador.setId(35);
		avaliador.setNome("Fulano da Silva");
		avaliador.setSenha("353535");
		avaliador.setLogin("fulano@gmail.com");
		avaliador.setArea(areas);
		
		avaliadorDAO.editar(avaliador); */
		
		AvaliadorDAO aDAO = new AvaliadorDAO();
		Evento evento = new Evento();
		evento.setId(6);
		List<Entidade> lista = aDAO.listarTudo(evento);
		
		for(Entidade a: lista) {
			Avaliador avaliador = (Avaliador) a;
			System.out.println(avaliador.getNome());
		}
		
		
		
	
}}
