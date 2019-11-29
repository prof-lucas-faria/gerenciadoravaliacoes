package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class TelaAddAvaliador extends JFrame {

	private JPanel contentPane;
	private JTextField nomeAvaliador;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddAvaliador frame = new TelaAddAvaliador();
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
	public TelaAddAvaliador() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AVALIADOR");
		lblNewLabel.setBounds(25, 12, 92, 17);
		contentPane.add(lblNewLabel);
		
		nomeAvaliador = new JTextField();
		nomeAvaliador.setBounds(25, 81, 332, 21);
		contentPane.add(nomeAvaliador);
		nomeAvaliador.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(25, 135, 332, 21);
		contentPane.add(textEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Áreas");
		lblNewLabel_1.setBounds(25, 168, 60, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("Nome");
		lblEmail.setBounds(25, 57, 60, 17);
		contentPane.add(lblEmail);
		
		JLabel label = new JLabel("E-mail");
		label.setBounds(25, 114, 60, 17);
		contentPane.add(label);
		
		JList list = new JList();
		list.setBounds(35, 203, 1, 1);
		contentPane.add(list);
		
		JButton btnSalvarAvaliador = new JButton("Salvar");
		btnSalvarAvaliador.setBounds(307, 233, 105, 27);
		contentPane.add(btnSalvarAvaliador);
		
		setVisible(true);
	}
}
