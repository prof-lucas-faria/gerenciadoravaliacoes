package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Categoria extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categoria frame = new Categoria();
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
	public Categoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdicionarCategoria = new JButton("Adicionar Categoria");
		btnAdicionarCategoria.setBounds(50, 28, 203, 25);
		btnAdicionarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCategoria oTela = new TelaCategoria();
				oTela.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAdicionarCategoria);
		
		JLabel nomeDaCategoria = new JLabel("Nome da Categoria");
		nomeDaCategoria.setBounds(50, 98, 143, 15);
		contentPane.add(nomeDaCategoria);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(197, 93, 85, 25);
		contentPane.add(btnEditar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.RED);
		btnDeletar.setBounds(291, 93, 93, 25);
		contentPane.add(btnDeletar);
	}
}
