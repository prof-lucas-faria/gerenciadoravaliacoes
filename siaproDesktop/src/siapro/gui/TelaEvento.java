package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class TelaEvento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEvento frame = new TelaEvento();
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
	public TelaEvento() {
		setTitle("Evento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeSistema = new JLabel("Nome do Sistema");
		nomeSistema.setForeground(Color.RED);
		nomeSistema.setFont(new Font("Dialog", Font.BOLD, 14));
		nomeSistema.setBounds(26, 12, 150, 15);
		contentPane.add(nomeSistema);
		
		JButton usuario = new JButton("Usuario");
		usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		usuario.setBounds(26, 58, 134, 25);
		contentPane.add(usuario);
		
		JComboBox selecione = new JComboBox();
		selecione.setBounds(26, 123, 134, 24);
		contentPane.add(selecione);
		
		JButton inicio = new JButton("Inicio");
		inicio.setBounds(26, 181, 134, 25);
		contentPane.add(inicio);
		
		JButton evento = new JButton("Evento");
		evento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		evento.setBounds(26, 250, 134, 25);
		contentPane.add(evento);
		
		JButton avaliadores = new JButton("Avaliadores");
		avaliadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		avaliadores.setBounds(26, 301, 134, 25);
		contentPane.add(avaliadores);
		
		JButton trabalhos = new JButton("Trabalhos");
		trabalhos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		trabalhos.setBounds(26, 353, 134, 25);
		contentPane.add(trabalhos);
		
		JButton relatorios = new JButton("Relatorios");
		relatorios.setBounds(26, 398, 134, 25);
		contentPane.add(relatorios);
		
		JLabel lblNomeDoEvento = new JLabel("Nome do Evento");
		lblNomeDoEvento.setForeground(Color.RED);
		lblNomeDoEvento.setBounds(252, 12, 134, 15);
		contentPane.add(lblNomeDoEvento);
		
		JButton abrirCategoria = new JButton("Categoria");
		abrirCategoria.setForeground(Color.BLUE);
		abrirCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		abrirCategoria.setBounds(226, 58, 114, 25);
		contentPane.add(abrirCategoria);
		
		JButton abrirArea = new JButton("Area");
		abrirArea.setForeground(Color.BLUE);
		abrirArea.setBounds(352, 58, 114, 25);
		contentPane.add(abrirArea);
		
		JButton abrirInformacoes = new JButton("Informações");
		abrirInformacoes.setForeground(Color.BLUE);
		abrirInformacoes.setBounds(478, 58, 134, 25);
		contentPane.add(abrirInformacoes);
	}
}
