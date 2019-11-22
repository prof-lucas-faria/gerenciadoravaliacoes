package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.ListarAreaController;
import siapro.controller.ListarCategoriaController;
import siapro.model.Categoria;
import siapro.model.Evento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ListarCategoria extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCategoria frame = new ListarCategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public static ArrayList<Categoria> listaCategoria(Evento evento) {
		ListarCategoriaController lcc = new ListarCategoriaController();
		ArrayList<Categoria>  lista = (ArrayList<Categoria>) lcc.listarCategoria(evento);
		return lista;
	}
	
	public ListarCategoria() {
		setTitle("Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Adicionar Categoria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);
		
		Evento e = new Evento();
		//ListarCategoriaController c = new ListarCategoriaController();
		
		JList listCategoria = new JList(listaCategoria(e).toArray());
		listCategoria.setBounds(5, 28, 0, 228);
		listCategoria.setToolTipText("");
		contentPane.add(listCategoria);
		//listCategoria.setListData(c.listarCategoria(e).toArray());
		
		
	}

}
