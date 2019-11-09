package siapro.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaAddProjeto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddProjeto frame = new TelaAddProjeto();
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
	public TelaAddProjeto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeProjeto = new JLabel("Cadastro de Projeto");
		lblCadastroDeProjeto.setBounds(5, 5, 884, 20);
		lblCadastroDeProjeto.setFont(new Font("Segoe UI Historic", Font.BOLD, 14));
		lblCadastroDeProjeto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCadastroDeProjeto);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(344, 76, 48, 14);
		contentPane.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(344, 97, 202, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(344, 222, 69, 14);
		contentPane.add(lblCategoria);
		
		JComboBox<String> comboBoxCategoria = new JComboBox<String>();
		comboBoxCategoria.setBounds(344, 247, 202, 22);
		contentPane.add(comboBoxCategoria);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(344, 302, 48, 14);
		contentPane.add(lblArea);
		
		JComboBox<String> comboBoxArea = new JComboBox<String>();
		comboBoxArea.setBounds(344, 327, 202, 22);
		contentPane.add(comboBoxArea);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(401, 398, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblAutores = new JLabel("Autores:");
		lblAutores.setBounds(344, 150, 48, 14);
		contentPane.add(lblAutores);
		
		textFieldAutores = new JTextField();
		textFieldAutores.setBounds(344, 170, 202, 20);
		contentPane.add(textFieldAutores);
		textFieldAutores.setColumns(10);
		
		JButton buttonBack = new JButton("<");
		buttonBack.setBounds(15, 11, 41, 23);
		contentPane.add(buttonBack);
		
		
	}
}
