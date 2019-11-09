package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeSistema = new JLabel("Nome Sistema");
		lblNomeSistema.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNomeSistema.setBounds(26, 12, 130, 15);
		contentPane.add(lblNomeSistema);
		
		JButton btnUsuario = new JButton("USUARIO");
		btnUsuario.setBounds(22, 39, 134, 25);
		contentPane.add(btnUsuario);
		
		JComboBox selecionarEvento = new JComboBox();
		selecionarEvento.setBounds(22, 92, 134, 24);
		contentPane.add(selecionarEvento);
		
		JButton btnIncio = new JButton("INÍCIO");
		btnIncio.setBounds(22, 139, 134, 25);
		contentPane.add(btnIncio);
		
		JButton btnEvento = new JButton("EVENTO");
		btnEvento.setBounds(22, 188, 134, 25);
		contentPane.add(btnEvento);
		
		JButton btnAvaliadores = new JButton("AVALIADORES");
		btnAvaliadores.setBounds(22, 233, 134, 25);
		contentPane.add(btnAvaliadores);
		
		JButton btnTrabalhos = new JButton("TRABALHOS");
		btnTrabalhos.setBounds(22, 277, 134, 25);
		contentPane.add(btnTrabalhos);
		
		JButton btnRelatrios = new JButton("RELATÓRIOS");
		btnRelatrios.setBounds(22, 319, 134, 25);
		contentPane.add(btnRelatrios);
		
		JLabel lblAvTrabalhos = new JLabel("Avaliações de Trabalhos");
		lblAvTrabalhos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAvTrabalhos.setBounds(686, 12, 201, 15);
		contentPane.add(lblAvTrabalhos);
	}
}
