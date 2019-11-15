package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.ListarAreaController;
import siapro.dao.AreaDAO;

import javax.swing.JButton;
import javax.swing.JList;

public class ListarArea extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public ListarArea() {
		setTitle("Listar Área");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdcionarArea = new JButton("Adicionar");
		btnAdcionarArea.setBounds(5, 5, 424, 23);
		contentPane.add(btnAdcionarArea);
		
		ListarAreaController c = new ListarAreaController();
		JList listArea = new JList(c.listarAreas(e));
		listArea.setBounds(5, 28, 0, 228);
		listArea.setToolTipText("");
		contentPane.add(listArea);
		listArea.setListData(c.listarAreas(e).toArray());
	}
}
