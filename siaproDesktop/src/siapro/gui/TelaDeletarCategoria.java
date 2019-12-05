package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.CategoriaController;
import siapro.controller.CriterioController;
import siapro.model.Categoria;
import siapro.model.Criterio;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaDeletarCategoria extends JFrame {

	private JPanel contentPane;
	private CategoriaController cC = new CategoriaController();

	public TelaDeletarCategoria(Categoria categoria) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Aperte confirmar para deletar a categoria:");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(0, 11, 440, 69);
		lbl.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		contentPane.add(lbl);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cC.deletarCategoria(categoria);
			}
		});
		btnConfirmar.setBounds(157, 159, 127, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblCriterio = new JLabel(categoria.getNome());
		lblCriterio.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblCriterio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriterio.setBounds(0, 63, 440, 31);
		contentPane.add(lblCriterio);
		
		setVisible(true);
	}
}
