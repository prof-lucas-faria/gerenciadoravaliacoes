package siapro.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.AreaController;
import siapro.model.Evento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAddArea extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfNomeArea;
	private Evento evento;
	private JTextField tfDescricaoArea;
	
	public void botaoSalvar() {
		Evento e = (evento);
		if(tfNomeArea.getText().isEmpty() ||  tfDescricaoArea.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Não é possivel salvar com campos vazios");		
		}
		else {
			new AreaController().salvarArea(tfNomeArea.getText(), evento, tfDescricaoArea.getText());
			JOptionPane.showMessageDialog(null,"Área salva com sucesso");		
		}
	}
	
	public TelaAddArea(Evento evento) {
		this.evento = evento;
		setTitle("Adicionar Área");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblrea = new JLabel("ÁREA");
		lblrea.setBounds(166, 12, 66, 15);
		contentPane.add(lblrea);
		
		JLabel lblNewLabel = new JLabel("Área:");
		lblNewLabel.setBounds(112, 38, 66, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descrição da área:");
		lblDescrio.setBounds(112, 92, 145, 15);
		contentPane.add(lblDescrio);
		
		tfNomeArea = new JTextField();
		tfNomeArea.setBounds(112, 53, 220, 19);
		contentPane.add(tfNomeArea);
		tfNomeArea.setColumns(10);
		
		tfDescricaoArea = new JTextField();
		tfDescricaoArea.setBounds(112, 107, 220, 72);
		contentPane.add(tfDescricaoArea);
		tfDescricaoArea.setColumns(10);
		
		JButton btnSalvarArea = new JButton("Salvar área");
		btnSalvarArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botaoSalvar();
			}
		});
		btnSalvarArea.setBounds(283, 191, 114, 25);
		contentPane.add(btnSalvarArea);
		
		setVisible(true);
	}
}
