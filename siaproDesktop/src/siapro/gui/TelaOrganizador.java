package siapro.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		lblRegistroDeOrganizador.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegistroDeOrganizador.setBounds(10, 11, 330, 20);
		contentPane.add(lblRegistroDeOrganizador);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(10, 50, 100, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(10, 64, 350, 25);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(10, 85, 100, 32);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(10, 108, 350, 25);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSenha.setBounds(10, 139, 84, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(10, 154, 350, 25);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrganizadorController().salvarOrganizador(textNome.getText(), textEmail.getText(), textSenha.getText());
				JOptionPane.showMessageDialog(btnRegistrar, "Cadastrado Organizador: " + textNome.getText());

			}
		});
		btnRegistrar.setBounds(150, 200, 130, 30);
		contentPane.add(btnRegistrar);
	}
}
