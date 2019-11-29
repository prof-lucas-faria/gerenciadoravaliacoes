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
import siapro.model.Evento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;

public class TelaEvento extends JFrame {

	private JPanel painel;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaEvento frame = new TelaEvento();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public TelaEvento(Evento e) {
		setTitle("Evento");
		setBounds(100, 100, 795, 483);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		JLabel nomeSistema = new JLabel("Nome do Sistema");
		nomeSistema.setForeground(Color.RED);
		nomeSistema.setFont(new Font("Dialog", Font.BOLD, 14));
		nomeSistema.setBounds(26, 12, 150, 15);
		painel.add(nomeSistema);
		
		JButton usuario = new JButton("Usuario");
		usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		usuario.setBounds(26, 58, 134, 25);
		painel.add(usuario);
		
		JComboBox selecione = new JComboBox();
		selecione.setBounds(26, 123, 134, 24);
		painel.add(selecione);
		
		JButton inicio = new JButton("Inicio");
		inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TelaInicial oTela = new TelaInicial();
				//oTela.setVisible(true);
				dispose();
			}
		});
		inicio.setBounds(26, 181, 134, 25);
		painel.add(inicio);
		
		JButton evento = new JButton("Evento");
		evento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		evento.setBounds(26, 250, 134, 25);
		painel.add(evento);
		
		JButton avaliadores = new JButton("Avaliadores");
		avaliadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		avaliadores.setBounds(26, 301, 134, 25);
		painel.add(avaliadores);
		
		JButton trabalhos = new JButton("Trabalhos");
		trabalhos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		trabalhos.setBounds(26, 353, 134, 25);
		painel.add(trabalhos);
		
		JButton relatorios = new JButton("Relatorios");
		relatorios.setBounds(26, 398, 134, 25);
		painel.add(relatorios);
		
		JLabel lblNomeDoEvento = new JLabel("Nome do Evento");
		lblNomeDoEvento.setForeground(Color.RED);
		lblNomeDoEvento.setBounds(252, 12, 134, 15);
		painel.add(lblNomeDoEvento);
		
		JButton abrirCategoria = new JButton("Categoria");
		abrirCategoria.setForeground(Color.BLUE);
		abrirCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarCategoria oTela = new ListarCategoria(e);
				oTela.setVisible(true);
			}
		});
		abrirCategoria.setBounds(226, 58, 114, 25);
		painel.add(abrirCategoria);
		
		JButton abrirArea = new JButton("Area");
		abrirArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarArea oTela = new ListarArea();
				oTela.setVisible(true);
			}
		});
		abrirArea.setForeground(Color.BLUE);
		abrirArea.setBounds(352, 58, 114, 25);
		painel.add(abrirArea);
		
		JButton abrirInformacoes = new JButton("Informações");
		abrirInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Informacoes oTela = new Informacoes();
				oTela.setVisible(true);
			}
		});
		abrirInformacoes.setForeground(Color.BLUE);
		abrirInformacoes.setBounds(478, 58, 134, 25);
		painel.add(abrirInformacoes);

		setVisible(true);
	}
}