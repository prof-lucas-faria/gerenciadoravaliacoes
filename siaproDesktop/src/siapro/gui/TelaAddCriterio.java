package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.CriterioController;
import siapro.controller.ListarCategoriaController;
import siapro.dao.CategoriaDAO;
import siapro.dao.CriterioDAO;
import siapro.dao.EventoDAO;
import siapro.model.Categoria;
import siapro.model.Criterio;
import siapro.model.Evento;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class TelaAddCriterio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeCriterio;
	private JTextField textFieldDescricao;
	private JTextField textFieldNotaMinima;
	private JTextField textFieldNotaMaxima;
	
	private Categoria categoria;
	private long idCriterio = 0;
	
	/*public TelaAddCriterio(Categoria c) {
		this.criterio.setId(0);
		this.categoria = c;
		
	}*/
	
	public TelaAddCriterio(Criterio c) {
		
		this(c.getCategoria());
		textFieldNomeCriterio.setText(c.getNome()); 
		textFieldDescricao.setText(c.getDescricao());
		textFieldNotaMinima.setText(Double.toString(c.getNotaMinima()));
		textFieldNotaMaxima.setText(Double.toString(c.getNotaMaxima()));
		
//		adicionar outros valores para o restante dos campos do formulário.
		this.idCriterio = c.getId();
		
	}
	
	
	public void salvar() {
		if(textFieldNomeCriterio.getText().isEmpty() || textFieldDescricao.getText().isEmpty() || textFieldNotaMinima.getText().isEmpty() || textFieldNotaMaxima.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não é possivel salvar dados vazios");
		}else {
			boolean salvou = new CriterioController().salvar(this.categoria, textFieldNomeCriterio.getText(), textFieldDescricao.getText(), textFieldNotaMinima.getText(), textFieldNotaMaxima.getText(), this.idCriterio);
			if(salvou) {
				this.textFieldNomeCriterio.setText("");
				this.textFieldDescricao.setText("");
				this.textFieldNotaMinima.setText("");
				this.textFieldNotaMaxima.setText("");
				JOptionPane.showMessageDialog(null, "Critério salvo com sucesso!!");
			}
		}
	}
	

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public TelaAddCriterio(Categoria categoria) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.categoria = categoria;
		
		
		setBounds(100, 100, 528, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoria = new JLabel("ADICIONAR CRITERIOS");
		lblCategoria.setBounds(12, 12, 229, 23);
		contentPane.add(lblCategoria);
		
		JLabel lblCategoria_1 = new JLabel("Categoria");
		lblCategoria_1.setBounds(37, 36, 72, 23);
		contentPane.add(lblCategoria_1);
		
		JLabel lblNewLabel = new JLabel("Criterios de Avalia\u00E7\u00E3o");
		lblNewLabel.setBounds(37, 90, 273, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCriterio = new JLabel("Criterio");
		lblCriterio.setBounds(57, 115, 126, 14);
		contentPane.add(lblCriterio);	
	
		textFieldNomeCriterio = new JTextField();
		textFieldNomeCriterio.setBounds(57, 136, 164, 20);
		contentPane.add(textFieldNomeCriterio);
		textFieldNomeCriterio.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(57, 167, 147, 14);
		contentPane.add(lblDescrio);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(57, 192, 164, 71);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				salvar();
			}
		});
		btnSalvar.setBounds(57, 280, 89, 23);
		contentPane.add(btnSalvar);
		
		textFieldNotaMinima = new JTextField();
		textFieldNotaMinima.setBounds(255, 233, 77, 30);
		contentPane.add(textFieldNotaMinima);
		textFieldNotaMinima.setColumns(10);
		
		textFieldNotaMaxima = new JTextField();
		textFieldNotaMaxima.setColumns(10);
		textFieldNotaMaxima.setBounds(393, 233, 77, 30);
		contentPane.add(textFieldNotaMaxima);
		
		JLabel lblNotaMinima = new JLabel("Nota Minima");
		lblNotaMinima.setBounds(257, 205, 133, 15);
		contentPane.add(lblNotaMinima);
		
		JLabel lblNotaMaxima = new JLabel("Nota Maxima");
		lblNotaMaxima.setBounds(383, 205, 133, 15);
		contentPane.add(lblNotaMaxima);
		
		JLabel labelCategoria = new JLabel("New label");
		labelCategoria.setBounds(61, 61, 393, 23);
		contentPane.add(labelCategoria);
		
		labelCategoria.setText(this.categoria.getNome());
		
		setVisible(true);
	}


}
