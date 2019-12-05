package siapro.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import siapro.controller.AvaliadorController;
import siapro.controller.ListarAreaController;
import siapro.controller.ListarCategoriaController;
import siapro.controller.TelaInicialController;
import siapro.dao.AvaliadorDAO;
import siapro.dao.EventoDAO;
import siapro.model.Avaliador;
import siapro.model.Entidade;
import siapro.model.Evento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JLabel;

public class TelaAvaliador extends JFrame {

	private JPanel contentPane;
	private JTextField pesquisarAvaliadores;
	private Evento evento;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Evento evento = (Evento) new EventoDAO().pesquisarId(1);
					TelaAvaliador frame = new TelaAvaliador(evento);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param e 
	 */
	public TelaAvaliador(Evento evento) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Para testes
		evento = (Evento) new EventoDAO().pesquisarId(1);
		
		JButton btnAddAvaliadores = new JButton("Adicionar Avaliadores");
		btnAddAvaliadores.setBounds(38, 61, 193, 29);
		btnAddAvaliadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaAddAvaliador();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddAvaliadores);
		
		pesquisarAvaliadores = new JTextField();
		pesquisarAvaliadores.setBounds(38, 120, 251, 33);
		contentPane.add(pesquisarAvaliadores);
		pesquisarAvaliadores.setColumns(10);
		
		//System.out.println(evento.getId());
		//Evento e = (Evento) entidade;
		
		JList listaAvaliadores = new JList(new AvaliadorController().listarAvaliadores(evento).toArray());
		listaAvaliadores.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaAvaliadores.setBackground(UIManager.getColor("CheckBox.background"));
		listaAvaliadores.setBounds(38, 168, 330, 75);
		contentPane.add(listaAvaliadores);
		
		
		//List<Evento> eventos = new TelaInicialController().listarEventos();
		
	
		
		//List<Avaliador> avaliadores = new AvaliadorController().listarAvaliadores(e); 
		
		JLabel lblAvaliadores = new JLabel("AVALIADORES");
		lblAvaliadores.setBounds(164, 12, 125, 17);
		contentPane.add(lblAvaliadores);
		
		JList list_1 = new JList();
		list_1.setBounds(52, 195, 1, 1);
		contentPane.add(list_1);
		
		JList listaAvalaidores = new JList();
		listaAvalaidores.setBounds(52, 195, 1, 1);
		contentPane.add(listaAvalaidores);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(295, 120, 105, 27);
		contentPane.add(btnPesquisar);
	}
}
