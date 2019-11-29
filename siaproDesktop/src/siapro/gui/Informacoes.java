package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Informacoes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacoes frame = new Informacoes();
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
	public Informacoes() {
<<<<<<< HEAD
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======

>>>>>>> e5992fab0ec5461ee49f2b80452733a816a8d6a8
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformaes = new JLabel("Informações");
		lblInformaes.setBackground(Color.MAGENTA);
		lblInformaes.setForeground(Color.RED);
		lblInformaes.setBounds(22, 0, 131, 15);
		contentPane.add(lblInformaes);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 30, 66, 15);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(78, 27, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(22, 57, 73, 15);
		contentPane.add(lblLocal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 55, 124, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(82, 98, 32, 24);
		contentPane.add(comboBox);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(22, 103, 66, 15);
		contentPane.add(lblEstado);
		
		JLabel lblInformaesSobreO = new JLabel("Informações sobre o Evento");
		lblInformaesSobreO.setForeground(Color.BLUE);
		lblInformaesSobreO.setBounds(22, 141, 224, 15);
		contentPane.add(lblInformaesSobreO);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 168, 252, 69);
		contentPane.add(textArea);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLUE);
		btnSalvar.setBounds(300, 222, 114, 25);
		contentPane.add(btnSalvar);
	}
}
