package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;

public class TelaAddCriterio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeCriterio;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddCriterio frame = new TelaAddCriterio();
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
	public TelaAddCriterio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblNewLabel.setBounds(37, 90, 126, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCriterio = new JLabel("Criterio");
		lblCriterio.setBounds(57, 115, 126, 14);
		contentPane.add(lblCriterio);
		
		JComboBox comboBoxCategorias = new JComboBox();
		comboBoxCategorias.setBounds(36, 57, 147, 22);
		contentPane.add(comboBoxCategorias);
		
		textFieldNomeCriterio = new JTextField();
		textFieldNomeCriterio.setBounds(57, 136, 164, 20);
		contentPane.add(textFieldNomeCriterio);
		textFieldNomeCriterio.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(57, 167, 77, 14);
		contentPane.add(lblDescrio);
		
		textField = new JTextField();
		textField.setBounds(57, 192, 164, 71);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(262, 240, 89, 23);
		contentPane.add(btnSalvar);
	}
}
