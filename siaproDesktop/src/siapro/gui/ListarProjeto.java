package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ListarProjeto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProjeto frame = new ListarProjeto();
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
	public ListarProjeto() {
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
		
		JLabel lblTrabalhos = new JLabel("TRABALHOS");
		lblTrabalhos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTrabalhos.setBounds(217, 12, 114, 15);
		contentPane.add(lblTrabalhos);
		
		JButton btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setBounds(217, 39, 114, 25);
		contentPane.add(btnAdicionar);
		
		JButton btnDistribuir = new JButton("DISTRIBUIR");
		btnDistribuir.setBounds(364, 39, 114, 25);
		contentPane.add(btnDistribuir);
	}

}
