package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.CategoriaController;
import siapro.controller.ListarAreaController;
import siapro.controller.ListarCategoriaController;
import siapro.dao.EventoDAO;
import siapro.model.Categoria;
import siapro.model.Evento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ListarCategoria extends JFrame {

	private JPanel contentPane;
	private static CategoriaController cC = new CategoriaController();

	/**
	 * Launch the application.
	 */

	public ListarCategoria(Evento evento) {
		setTitle("Categoria");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Adicionar Categoria");
		btnNewButton.setBounds(5, 5, 424, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Categoria();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JList listCategoria = new JList(cC.listarCategoria(evento).toArray());
		listCategoria.setBounds(5, 51, 245, 399);
		listCategoria.setToolTipText("");
		contentPane.add(listCategoria);
		
		JList list = new JList();
		list.setBounds(75, 213, 295, -135);
		contentPane.add(list);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new TelaEditarCategoria();
			}
		});
		btnEditar.setBounds(311, 55, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cC.deletarCategoria((Categoria) listCategoria.getSelectedValue());
			}
		});
		btnExcluir.setBounds(311, 105, 89, 23);
		contentPane.add(btnExcluir);
		//listCategoria.setListData(c.listarCategoria(e).toArray());
		
		setVisible(true);
	}
}
