package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import siapro.controller.AreaController;
import siapro.controller.ListarAreaController;
import siapro.controller.ListarProjetoController;
import siapro.dao.AreaDAO;
import siapro.dao.EventoDAO;
import siapro.model.Area;
import siapro.model.Evento;
import siapro.model.Projeto;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ListarArea extends JFrame {
	private JPanel contentPane;
	private Evento evento;
	private Area area;

	public void botaoNovaArea() {
		Evento e = (evento);
		new TelaAddArea(e);
	}

	public ListarArea(Evento evento) {
		this.evento = evento;
		setTitle("Listar Área");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdcionarArea = new JButton("Adicionar");
		btnAdcionarArea.setBounds(5, 5, 424, 23);
		btnAdcionarArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoNovaArea();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAdcionarArea);
		
		JList listArea = new JList(new ListarAreaController().listarAreas(evento).toArray());
		listArea.setBounds(15, 39, 296, 197);
		contentPane.add(listArea);
		listArea.setToolTipText("");
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(335, 82, 89, 23);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAddArea(new AreaController().atualizarArea((Area) listArea.getSelectedValue()));
			}
		});
		contentPane.add(btnEditar);
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(335, 139, 89, 23);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AreaController().deletarArea((Area) listArea.getSelectedValue());
				listArea.setListData(new ListarAreaController().listarAreas(evento).toArray());
				JOptionPane.showMessageDialog(null,"Área excluida com sucesso");
			}
		});
		contentPane.add(btnExcluir);
		
		JScrollPane scrollListArea = new JScrollPane(listArea);
		scrollListArea.setBounds(15, 39, 298, 208);
		contentPane.add(scrollListArea);
		
		setVisible(true);
		}
}
