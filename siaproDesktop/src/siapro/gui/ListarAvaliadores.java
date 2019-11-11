package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;

public class ListarAvaliadores extends JFrame {

	private JPanel contentPane;
	private JTextField pesqAvaliadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarAvaliadores frame = new ListarAvaliadores();
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
	public ListarAvaliadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JButton adcAvaliadores = new JButton("ADICIONAR AVALIADORES");
		adcAvaliadores.setFont(new Font("Dialog", Font.BOLD, 10));
		adcAvaliadores.setBackground(new Color(51, 204, 255));
		adcAvaliadores.setBounds(32, 104, 190, 46);
		contentPane.add(adcAvaliadores);
		
		JLabel txtAvaliadores = new JLabel("AVALIADORES");
		txtAvaliadores.setBounds(32, 44, 180, 15);
		contentPane.add(txtAvaliadores);
		
		pesqAvaliadores = new JTextField();
		pesqAvaliadores.setBounds(32, 208, 394, 30);
		contentPane.add(pesqAvaliadores);
		pesqAvaliadores.setColumns(10);
		
		
	
	}
}
