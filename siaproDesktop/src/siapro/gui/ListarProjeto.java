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

import siapro.controller.ListarProjetoController;

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
		setBounds(100, 100, 737, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTrabalhos = new JLabel("TRABALHOS");
		lblTrabalhos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTrabalhos.setBounds(12, 8, 114, 15);
		contentPane.add(lblTrabalhos);
		
		JButton btnAddTrabalho = new JButton("Adicionar Trabalhos");
		btnAddTrabalho.setBounds(12, 30, 169, 25);
		contentPane.add(btnAddTrabalho);
		
		JButton btnDistribuirTrabalho = new JButton("Distribuir Trabalhos");
		btnDistribuirTrabalho.setBounds(214, 30, 183, 25);
		contentPane.add(btnDistribuirTrabalho);
		
		txtDigiteNomeDo = new JTextField();
		txtDigiteNomeDo.setText("Digite sua pesquisa");
		txtDigiteNomeDo.setBounds(12, 80, 235, 25);
		contentPane.add(txtDigiteNomeDo);
		txtDigiteNomeDo.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(255, 78, 114, 25);
		contentPane.add(btnPesquisar);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCategoria.setBounds(12, 132, 98, 15);
		contentPane.add(lblCategoria);
		
		JLabel lblrea = new JLabel("Área:");
		lblrea.setFont(new Font("Dialog", Font.BOLD, 14));
		lblrea.setBounds(372, 127, 73, 25);
		contentPane.add(lblrea);
		
		JList listaCategoria = new JList();
		listaCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaCategoria.setBackground(UIManager.getColor("CheckBox.background"));
		listaCategoria.setBounds(12, 157, 330, 175);
		contentPane.add(listaCategoria);
		
		JList listaArea = new JList();
		listaArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaArea.setBackground(UIManager.getColor("CheckBox.background"));
		listaArea.setBounds(372, 157, 330, 175);
		contentPane.add(listaArea);
		
		JLabel lblTrabalhosAdicionados = new JLabel("Trabalhos Adicionados");
		lblTrabalhosAdicionados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTrabalhosAdicionados.setBounds(12, 350, 194, 15);
		contentPane.add(lblTrabalhosAdicionados);
		
//		String[] texto = {"Trabalhoo 01""Trabalhoo 02", "Trabalhoo 03"};
//		JList listaTrabalho = new JList(texto);
		ListarProjetoController lpc = new ListarProjetoController();
		JList listaTrabalho = new JList(lpc.listarProjeto(entidade));
		listaTrabalho.setBorder(new LineBorder(new Color(60, 179, 113)));
		listaTrabalho.setBackground(UIManager.getColor("CheckBox.background"));
		listaTrabalho.setBounds(12, 377, 463, 219);
		contentPane.add(listaTrabalho);
		
	}
}
