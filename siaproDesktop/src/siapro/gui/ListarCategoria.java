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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ListarCategoria extends JFrame {

	private JPanel contentPane;
	private static CategoriaController cC = new CategoriaController();

	/**
	 * Launch the application.
	 */
 
	public ListarCategoria(Evento evento) {
		setTitle("Categoria");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JList listCategoria = new JList(cC.listarCategoria(evento).toArray());
		listCategoria.setBounds(5, 48, 288, 285);
		listCategoria.setToolTipText("");
		contentPane.add(listCategoria);
		
		JButton btnNewButton = new JButton("Adicionar Categoria");
		btnNewButton.setBounds(303, 48, 165, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Categoria categoria = new Categoria();
				categoria.setEvento(evento);
				new TelaEditarCategoria(categoria);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaEditarCategoria((Categoria) listCategoria.getSelectedValue());
			}
		});
		btnEditar.setBounds(303, 82, 165, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Deletar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaDeletarCategoria((Categoria) listCategoria.getSelectedValue());
			}
		});
		btnExcluir.setBounds(303, 116, 165, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listCategoria.setListData(cC.listarCategoria(evento).toArray());
			}
		});
		btnAtualizar.setBounds(303, 150, 165, 23);
		contentPane.add(btnAtualizar);
		
		JLabel lblListaDeCategorias = new JLabel("Lista de categorias");
		lblListaDeCategorias.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeCategorias.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblListaDeCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeCategorias.setBounds(5, 11, 479, 34);
		contentPane.add(lblListaDeCategorias);
		
		setVisible(true);
	}
}
