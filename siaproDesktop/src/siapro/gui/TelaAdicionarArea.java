package siapro.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.AreaController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdicionarArea extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfNomeArea;
	private JTextField tfDescricaoArea;
	
	public void botaoSalvar() {
		new AreaController().salvarArea(tfNomeArea.getText(), tfDescricaoArea.getText());
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionarArea frame = new TelaAdicionarArea();
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
	public TelaAdicionarArea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblrea = new JLabel("ÁREA");
		lblrea.setBounds(166, 12, 66, 15);
		contentPane.add(lblrea);
		
		JLabel lblNewLabel = new JLabel("Área:");
		lblNewLabel.setBounds(112, 39, 66, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descrição da área:");
		lblDescrio.setBounds(112, 92, 145, 15);
		contentPane.add(lblDescrio);
		
		tfNomeArea = new JTextField();
		tfNomeArea.setBounds(112, 61, 220, 19);
		contentPane.add(tfNomeArea);
		tfNomeArea.setColumns(10);
		
		JButton btnSalvarArea = new JButton("Salvar área");
		btnSalvarArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botaoSalvar();
			}
		});
		btnSalvarArea.setBounds(306, 233, 114, 25);
		contentPane.add(btnSalvarArea);
		
		tfDescricaoArea = new JTextField();
		tfDescricaoArea.setBounds(112, 119, 220, 72);
		contentPane.add(tfDescricaoArea);
		tfDescricaoArea.setColumns(10);
	}
}
