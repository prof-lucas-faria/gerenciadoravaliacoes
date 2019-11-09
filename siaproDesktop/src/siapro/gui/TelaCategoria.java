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
	private JTextField nomeItem;
	private JTextField descrição;
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
		lblCat.setBounds(86, 22, 71, 14);
		contentPane.add(lblCat);
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setBounds(86, 58, 71, 14);
		contentPane.add(lblNewLabel);
		
		nomeCategoria = new JTextField();
		nomeCategoria.setBounds(86, 74, 159, 20);
		contentPane.add(nomeCategoria);
		nomeCategoria.setColumns(10);
		
		JLabel lblItensDeAvaliao = new JLabel("Itens de Avaliação");
		lblItensDeAvaliao.setBounds(86, 105, 110, 14);
		contentPane.add(lblItensDeAvaliao);
		
		JLabel lblNomeDoItem = new JLabel("Nome do Item:");
		lblNomeDoItem.setBounds(86, 130, 71, 14);
		contentPane.add(lblNomeDoItem);
		
		nomeItem = new JTextField();
		nomeItem.setColumns(10);
		nomeItem.setBounds(86, 150, 159, 20);
		contentPane.add(nomeItem);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(86, 181, 55, 14);
		contentPane.add(lblDescrio);
		
		descrição = new JTextField();
		descrição.setColumns(10);
		descrição.setBounds(86, 206, 159, 69);
		contentPane.add(descrição);
		
		JLabel lblNewLabel_1 = new JLabel("Pontuação das Avaliações");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(86, 286, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NotaMínima");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2.setBounds(95, 300, 55, 14);
		contentPane.add(lblNewLabel_2);
		
		notaMin = new JTextField();
		notaMin.setColumns(10);
		notaMin.setBounds(96, 314, 23, 20);
		contentPane.add(notaMin);
		
		JLabel lblNotamxima = new JLabel("NotaMáxima");
		lblNotamxima.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNotamxima.setBounds(165, 300, 61, 14);
		contentPane.add(lblNotamxima);
		
		JButton addItem = new JButton("Adcionar Item");
		addItem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addItem.setBounds(86, 352, 102, 20);
		contentPane.add(addItem);
		
		JButton salvaCategoria = new JButton("Salvar Categoria");
		salvaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 10));
		salvaCategoria.setBounds(314, 365, 110, 20);
		contentPane.add(salvaCategoria);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 314, 23, 20);
		contentPane.add(textField);
	}
}
