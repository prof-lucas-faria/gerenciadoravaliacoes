package siapro.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import siapro.controller.ListarAreaController;
import siapro.controller.ListarCategoriaController;
import siapro.controller.ListarProjetoController;
import siapro.dao.EventoDAO;
import siapro.model.Evento;

public class ListarProjeto extends JFrame {

	private JPanel contentPane;
	private JTextField txtfPesquisarProjeto;

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
		
		// Para testes
		Evento evento = new Evento();
		evento = (Evento) new EventoDAO().pesquisarId(4);
		
		JLabel lblTrabalhos = new JLabel("TRABALHOS");
		lblTrabalhos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTrabalhos.setBounds(12, 8, 114, 15);
		contentPane.add(lblTrabalhos);
		
		JButton btnAddTrabalho = new JButton("Adicionar Trabalhos");
		btnAddTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaAddProjeto();
			}
		});
		btnAddTrabalho.setBounds(12, 30, 169, 25);
		contentPane.add(btnAddTrabalho);
		
		JButton btnDistribuirTrabalho = new JButton("Distribuir Trabalhos");
		btnDistribuirTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				direcionar para a futura tela de distribuir projetos
			}
		});
		btnDistribuirTrabalho.setBounds(214, 30, 183, 25);
		contentPane.add(btnDistribuirTrabalho);
		
		txtfPesquisarProjeto = new JTextField();
		txtfPesquisarProjeto.setText("Digite sua pesquisa");
		txtfPesquisarProjeto.setBounds(12, 80, 235, 25);
		contentPane.add(txtfPesquisarProjeto);
		txtfPesquisarProjeto.setColumns(10);
		
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
		
		
		JList listaCategoria = new JList(new ListarCategoriaController().listarCategoria(evento).toArray());
		listaCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaCategoria.setBackground(UIManager.getColor("CheckBox.background"));
		listaCategoria.setBounds(12, 157, 330, 175);
		contentPane.add(listaCategoria);
		
		JList listaArea = new JList(new ListarAreaController().listarAreas(evento).toArray());
		listaArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaArea.setBackground(UIManager.getColor("CheckBox.background"));
		listaArea.setBounds(372, 157, 330, 175);
		contentPane.add(listaArea);
		
		JLabel lblTrabalhosAdicionados = new JLabel("Trabalhos Adicionados");
		lblTrabalhosAdicionados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTrabalhosAdicionados.setBounds(12, 350, 194, 15);
		contentPane.add(lblTrabalhosAdicionados);
		
		JList listaTrabalho = new JList(new ListarProjetoController().listarProjeto(evento).toArray());
		listaTrabalho.setBorder(new LineBorder(new Color(60, 179, 113)));
		listaTrabalho.setBackground(UIManager.getColor("CheckBox.background"));
		listaTrabalho.setBounds(12, 377, 463, 219);
		contentPane.add(listaTrabalho);
		
		JButton btnEditarTrabalho = new JButton("Editar Trabalho");
		btnEditarTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Direcionar para futura tela de editar
			}
		});
		btnEditarTrabalho.setBounds(500, 374, 147, 25);
		contentPane.add(btnEditarTrabalho);
		
		JButton btnExcluirTrabalho = new JButton("Excluir Trabalho");
		btnExcluirTrabalho.setBounds(500, 425, 152, 25);
		contentPane.add(btnExcluirTrabalho);
		
		setVisible(true);
	}
}
