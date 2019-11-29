package siapro.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import siapro.controller.OrganizadorController;

public class TelaOrganizador extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOrganizador frame = new TelaOrganizador();
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
	public TelaOrganizador() {

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeOrganizador = new JLabel("Registro De Organizador");
		lblRegistroDeOrganizador.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistroDeOrganizador.setBounds(10, 11, 201, 20);
		contentPane.add(lblRegistroDeOrganizador);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 50, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(10, 64, 131, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 95, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(10, 108, 131, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 139, 46, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(10, 154, 131, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrganizadorController().salvarOrganizador(textNome.getText(), textEmail.getText(), textSenha.getText());
			}
		});
		btnRegistrar.setBounds(31, 185, 89, 23);
		contentPane.add(btnRegistrar);
	}
}
