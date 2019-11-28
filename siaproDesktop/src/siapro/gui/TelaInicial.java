package siapro.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import siapro.controller.TelaInicialController;
import siapro.dao.EventoDAO;
import siapro.dao.OrganizadorDAO;
import siapro.model.Entidade;
import siapro.model.Evento;
import siapro.model.Organizador;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JComboBox selecionarEvento;

	public void botaoEvento() {
		Evento e = (Evento) getSelecionarEvento().getSelectedItem();
		new TelaEvento(e);
	}
	
	public TelaInicial() {
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeSistema = new JLabel("Nome Sistema");
		lblNomeSistema.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNomeSistema.setBounds(26, 12, 130, 15);
		contentPane.add(lblNomeSistema);
		
		JButton btnUsuario = new JButton("USUARIO");
		btnUsuario.setBounds(22, 39, 134, 25);
		contentPane.add(btnUsuario);
		
		selecionarEvento = new JComboBox();
		
		List<Evento> eventos = new TelaInicialController().listarEventos();
		for (Evento evento : eventos) {
			selecionarEvento.addItem(evento);
		}
		
		selecionarEvento.setBounds(26, 92, 130, 24);
		contentPane.add(selecionarEvento);
		
		JButton btnEvento = new JButton("EVENTO");
		btnEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botaoEvento();
			}
		});
		btnEvento.setBounds(26, 146, 134, 25);
		contentPane.add(btnEvento);
		
		JButton btnAvaliadores = new JButton("AVALIADORES");
		btnAvaliadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaAvaliador(null);
			}
		});
		btnAvaliadores.setBounds(26, 191, 134, 25);
		contentPane.add(btnAvaliadores);
		
		JButton btnTrabalhos = new JButton("TRABALHOS");
		btnTrabalhos.setBounds(26, 235, 134, 25);
		contentPane.add(btnTrabalhos);
		
		JButton btnRelatrios = new JButton("RELATÓRIOS");
		btnRelatrios.setBounds(26, 277, 134, 25);
		contentPane.add(btnRelatrios);
		
		JLabel lblAvTrabalhos = new JLabel("Avaliações de Trabalhos");
		lblAvTrabalhos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAvTrabalhos.setBounds(686, 12, 201, 15);
		contentPane.add(lblAvTrabalhos);
		
		JList listaTrabalhos = new JList();
		listaTrabalhos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaTrabalhos.setBackground(UIManager.getColor("CheckBox.background"));
		listaTrabalhos.setBounds(174, 12, 500, 481);
		contentPane.add(listaTrabalhos);
		
//		Isso é necessário para que a tela APAREÇA
		setVisible(true);
	}
	public JComboBox getSelecionarEvento() {
		return selecionarEvento;
	}
}
