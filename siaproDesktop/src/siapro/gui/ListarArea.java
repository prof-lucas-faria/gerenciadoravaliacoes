package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.ListarAreaController;
import siapro.controller.ListarProjetoController;
import siapro.dao.AreaDAO;
import siapro.dao.EventoDAO;
import siapro.model.Area;
import siapro.model.Evento;
import siapro.model.Projeto;

import javax.swing.JButton;
import javax.swing.JList;

public class ListarArea extends JFrame {
	private ListarAreaController lac = new ListarAreaController();
	private JPanel contentPane;
	private Evento evento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarArea frame = new ListarArea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static ArrayList<Area> listaArea(Evento evento) {
		ListarAreaController lac = new ListarAreaController();
		ArrayList<Area>  lista = (ArrayList<Area>) lac.listarAreas(evento);
		return lista;
	}
	
	public void botaoAddArea() {
		new Area();
	}
	
	public ListarArea() {
		setTitle("Listar Área");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Teste
		Evento evento = (Evento) new EventoDAO().pesquisarId(1);
		
		JButton btnAdcionarArea = new JButton("Adicionar");
		btnAdcionarArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botaoAddArea();
			}
		});
		btnAdcionarArea.setBounds(5, 5, 424, 23);
		contentPane.add(btnAdcionarArea);
		
		Evento e = new Evento();
		e = (Evento) new EventoDAO().pesquisarId(1);
		
		//ListarAreaController c = new ListarAreaController();
		JList listArea = new JList(listaArea(e).toArray());
		listArea.setBounds(5, 28, 0, 228);
		listArea.setToolTipText("");
		contentPane.add(listArea);
		//listArea.setListData(c.listarAreas(e).toArray());
	}
}
