package siapro.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import siapro.controller.AddProjetoController;
import siapro.controller.AreaController;
import siapro.dao.EventoDAO;
import siapro.model.Evento;
import siapro.model.Projeto;
import siapro.model.Categoria;
import siapro.model.Area;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaAddProjeto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutores;
	private static AddProjetoController apc = new AddProjetoController();
	private  JComboBox selecionarCategoria;
	private JComboBox selecionarArea;
	private Evento evento;
	


	public void salvar() {
		Categoria c = (Categoria) selecionarCategoria.getSelectedItem();
		Area a = (Area) selecionarArea.getSelectedItem();
		
		if(textFieldTitulo.getText().isEmpty() || textFieldAutores.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Não é possivel salvar com campos vazios");		
		}
		else {			
			JOptionPane.showMessageDialog(null,"Projeto salvo com sucesso");
			new AddProjetoController().salvarProjeto(textFieldTitulo.getText(), textFieldAutores.getText(),  evento, c, a);
			new ListarProjeto(evento);
			dispose();
		}	
	}

	/**
	 * @wbp.parser.constructor
	 */
	public TelaAddProjeto(Evento evento) {
		this.evento = evento;
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
		
		JButton buttonBack = new JButton("<");
		buttonBack.setBounds(15, 11, 41, 23);
		contentPane.add(buttonBack);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(344, 76, 48, 14);
		contentPane.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(344, 97, 202, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		textFieldAutores = new JTextField();
		textFieldAutores.setBounds(344, 170, 202, 20);
		contentPane.add(textFieldAutores);
		textFieldAutores.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(344, 222, 69, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(344, 302, 48, 14);
		contentPane.add(lblArea);
		
		JLabel lblAutores = new JLabel("Autores:");
		lblAutores.setBounds(344, 150, 48, 14);
		contentPane.add(lblAutores);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnSalvar.setBounds(401, 398, 89, 23);
		contentPane.add(btnSalvar);
		
		selecionarCategoria = new JComboBox();
		List<Categoria> categorias = new AddProjetoController().listarCategoria(evento);
		for (Categoria categoria : categorias) {
			selecionarCategoria.addItem(categoria);
		}
		selecionarCategoria.setBounds(344, 248, 202, 24);
		contentPane.add(selecionarCategoria);
		
		selecionarArea = new JComboBox();
		List<Area> areas = apc.listarAreas(evento);
		for (Area area : areas) {
			selecionarArea.addItem(area);
		}
		selecionarArea.setBounds(344, 341, 202, 23);
		contentPane.add(selecionarArea);
		
		setVisible(true);
		}
	
	public TelaAddProjeto(Evento evento, Projeto p) {
		this.evento = evento;
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
		
		JButton buttonBack = new JButton("<");
		buttonBack.setBounds(15, 11, 41, 23);
		contentPane.add(buttonBack);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(344, 76, 48, 14);
		contentPane.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(344, 97, 202, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setText(p.getTitulo());
		
		
		textFieldAutores = new JTextField();
		textFieldAutores.setBounds(344, 170, 202, 20);
		contentPane.add(textFieldAutores);
		textFieldAutores.setColumns(10);
		textFieldAutores.setText(p.getAutores());
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(344, 222, 69, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(344, 302, 48, 14);
		contentPane.add(lblArea);
		
		JLabel lblAutores = new JLabel("Autores:");
		lblAutores.setBounds(344, 150, 48, 14);
		contentPane.add(lblAutores);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnSalvar.setBounds(401, 398, 89, 23);
		contentPane.add(btnSalvar);
		
		selecionarCategoria = new JComboBox();
		List<Categoria> categorias = new AddProjetoController().listarCategoria(evento);
		for (Categoria categoria : categorias) {
			selecionarCategoria.addItem(categoria);
		}
		selecionarCategoria.setBounds(344, 248, 202, 24);
		contentPane.add(selecionarCategoria);
		
		selecionarArea = new JComboBox();
		List<Area> areas = apc.listarAreas(evento);
		for (Area area : areas) {
			selecionarArea.addItem(area);
		}
		selecionarArea.setBounds(344, 341, 202, 23);
		contentPane.add(selecionarArea);
		
		setVisible(true);
		}
}
