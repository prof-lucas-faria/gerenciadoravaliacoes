package siapro.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import siapro.controller.AvaliadorController;
import siapro.model.Evento;
import java.awt.Font;

public class TelaAvaliador extends JFrame {

	private JPanel contentPane;
	private JTextField pesquisarAvaliadores;
	private JList listaAvaliadores;

	/*
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Evento evento = (Evento) new EventoDAO().pesquisarId(1);
//					TelaAvaliador frame = new TelaAvaliador(evento);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */

	/**
	 * Create the frame.
	 * @param e 
	 */
	public TelaAvaliador(Evento evento) {
		setTitle("Lista de Avaliadores");
		setBounds(100, 100, 459, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddAvaliadores = new JButton("Adicionar Avaliadores");
		btnAddAvaliadores.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddAvaliadores.setBounds(38, 61, 207, 29);
		btnAddAvaliadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaAddAvaliador();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddAvaliadores);
		
		pesquisarAvaliadores = new JTextField("Digite nome do Avaliador");
		pesquisarAvaliadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisarAvaliadores.setText("");
			}
		});
		pesquisarAvaliadores.setBounds(38, 120, 251, 33);
		contentPane.add(pesquisarAvaliadores);
		pesquisarAvaliadores.setColumns(10);
		
		listaAvaliadores = new JList(new AvaliadorController().listarAvaliadores(evento).toArray());
		listaAvaliadores.setFont(new Font("Dialog", Font.BOLD, 14));
		listaAvaliadores.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaAvaliadores.setBackground(UIManager.getColor("CheckBox.background"));
		listaAvaliadores.setBounds(38, 168, 379, 210);
		contentPane.add(listaAvaliadores);
		
		JLabel lblAvaliadores = new JLabel("AVALIADORES");
		lblAvaliadores.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAvaliadores.setBounds(164, 12, 139, 17);
		contentPane.add(lblAvaliadores);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeAvaliador = pesquisarAvaliadores.getText();
				listaAvaliadores.setListData(new AvaliadorController().pesquisarAvaliador(evento, nomeAvaliador).toArray());
			}
		});
		btnPesquisar.setBounds(295, 120, 122, 33);
		contentPane.add(btnPesquisar);
		
		setVisible(true);
	}
}
