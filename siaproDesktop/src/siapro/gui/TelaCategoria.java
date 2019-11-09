package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField nomeCategoria;
	private JTextField notaMin;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCategoria frame = new TelaCategoria();
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
	public TelaCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCat = new JLabel("CATEGORIA");
		lblCat.setBounds(86, 54, 71, 14);
		contentPane.add(lblCat);
		
		JLabel lblNewLabel = new JLabel("Nome da Categoria:");
		lblNewLabel.setBounds(86, 102, 110, 14);
		contentPane.add(lblNewLabel);
		
		nomeCategoria = new JTextField();
		nomeCategoria.setBounds(86, 126, 159, 20);
		contentPane.add(nomeCategoria);
		nomeCategoria.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pontuação das Avaliações");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(86, 179, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NotaMínima");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(86, 204, 55, 14);
		contentPane.add(lblNewLabel_2);
		
		notaMin = new JTextField();
		notaMin.setColumns(10);
		notaMin.setBounds(86, 218, 23, 20);
		contentPane.add(notaMin);
		
		JLabel lblNotamxima = new JLabel("NotaMáxima");
		lblNotamxima.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNotamxima.setBounds(165, 204, 61, 14);
		contentPane.add(lblNotamxima);
		
		JButton addItem = new JButton("Adcionar Item");
		addItem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addItem.setBounds(86, 266, 110, 20);
		contentPane.add(addItem);
		
		JButton salvaCategoria = new JButton("Salvar Categoria");
		salvaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 10));
		salvaCategoria.setBounds(86, 310, 110, 20);
		contentPane.add(salvaCategoria);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 218, 23, 20);
		contentPane.add(textField);
	}
}
