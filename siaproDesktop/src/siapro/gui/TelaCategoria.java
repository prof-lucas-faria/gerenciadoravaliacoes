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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		lblCat.setBounds(86, 22, 71, 14);
		contentPane.add(lblCat);
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setBounds(86, 58, 71, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 74, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblItensDeAvaliao = new JLabel("Itens de Avaliação");
		lblItensDeAvaliao.setBounds(86, 105, 110, 14);
		contentPane.add(lblItensDeAvaliao);
		
		JLabel lblNomeDoItem = new JLabel("Nome do Item:");
		lblNomeDoItem.setBounds(86, 130, 71, 14);
		contentPane.add(lblNomeDoItem);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(86, 150, 159, 20);
		contentPane.add(textField_1);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(86, 181, 55, 14);
		contentPane.add(lblDescrio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(86, 206, 159, 69);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Pontuação das Avaliações");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_1.setBounds(86, 286, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NotaMínima");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 6));
		lblNewLabel_2.setBounds(95, 300, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 311, 17, 20);
		contentPane.add(textField_3);
		
		JLabel lblNotamxima = new JLabel("NotaMáxima");
		lblNotamxima.setFont(new Font("Tahoma", Font.PLAIN, 6));
		lblNotamxima.setBounds(138, 300, 46, 14);
		contentPane.add(lblNotamxima);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(140, 311, 17, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Adcionar Item");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(86, 352, 83, 14);
		contentPane.add(btnNewButton);
		
		JButton btnSalvarCategoria = new JButton("Salvar Categoria");
		btnSalvarCategoria.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSalvarCategoria.setBounds(335, 371, 89, 14);
		contentPane.add(btnSalvarCategoria);
	}
}
