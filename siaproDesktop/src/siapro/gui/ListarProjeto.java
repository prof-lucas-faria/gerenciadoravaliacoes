package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ListarProjeto extends JFrame {

	private JPanel contentPane;
	private JTextField txtDigiteNomeDo;

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
		setTitle("Lista de Projetos");
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
		btnIncio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaInicial();
			}
		});
		btnIncio.setBounds(22, 139, 134, 25);
		contentPane.add(btnIncio);
		
		JButton btnEvento = new JButton("EVENTO");
		btnEvento.setBounds(22, 188, 134, 25);
		contentPane.add(btnEvento);
		
		JButton btnAvaliadores = new JButton("AVALIADORES");
		btnAvaliadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaAvaliador();
			}
		});
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
		
		JButton btnAddTrabalho = new JButton("Adicionar Trabalhos");
		btnAddTrabalho.setBounds(217, 39, 169, 25);
		contentPane.add(btnAddTrabalho);
		
		JButton btnDistribuirTrabalho = new JButton("Distribuir Trabalhos");
		btnDistribuirTrabalho.setBounds(419, 39, 183, 25);
		contentPane.add(btnDistribuirTrabalho);
		
		txtDigiteNomeDo = new JTextField();
		txtDigiteNomeDo.setBounds(217, 92, 235, 25);
		contentPane.add(txtDigiteNomeDo);
		txtDigiteNomeDo.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(460, 90, 114, 25);
		contentPane.add(btnPesquisar);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(217, 144, 80, 15);
		contentPane.add(lblCategoria);
		
		JLabel lblrea = new JLabel("Área:");
		lblrea.setBounds(460, 144, 66, 15);
		contentPane.add(lblrea);
		
		JList listaCategoria = new JList();
		listaCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaCategoria.setBackground(UIManager.getColor("CheckBox.background"));
		listaCategoria.setBounds(217, 169, 220, 175);
		contentPane.add(listaCategoria);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(UIManager.getColor("CheckBox.background"));
		list.setBounds(460, 169, 220, 175);
		contentPane.add(list);
		
		JLabel lblTrabalhosAdicionados = new JLabel("Trabalhos Adicionados");
		lblTrabalhosAdicionados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTrabalhosAdicionados.setBounds(217, 362, 194, 15);
		contentPane.add(lblTrabalhosAdicionados);
		
		JList list_1 = new JList();
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setBackground(UIManager.getColor("CheckBox.background"));
		list_1.setBounds(217, 389, 463, 104);
		contentPane.add(list_1);
	}
}
