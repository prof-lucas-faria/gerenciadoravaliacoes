package siapro.controller;

import siapro.dao.EventoDAO;
import siapro.model.Evento;

public class EventoController {
	public void editarEvento(String nome, String informacoes, Boolean situacao, String logotipo, long idEvento) {
		Evento evento = new Evento();
		evento.setNome(nome);
		evento.setInformacoes(informacoes);
		evento.setLiberado(situacao);
		evento.setLogotipo(logotipo);
		evento.setId(idEvento);
		new EventoDAO().editar(evento);
	}
	public Evento atualizar(Evento evento) {
		return (Evento) new EventoDAO().pesquisarId(evento.getId());
	}
}
