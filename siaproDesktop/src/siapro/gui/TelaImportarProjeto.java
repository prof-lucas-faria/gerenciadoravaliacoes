package siapro.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.ImportarProjetoController;
import siapro.controller.ListarAreaController;
import siapro.controller.ListarCategoriaController;
import siapro.core.ImportarProjeto;
import siapro.dao.EventoDAO;
import siapro.model.Area;
import siapro.model.Categoria;
import siapro.model.Evento;
import siapro.model.Projeto;

public class TelaImportarProjeto extends JFrame {

	private JPanel contentPane;
	private JComboBox cbArea;
	private JComboBox cbCategoria;
	private Path caminho;
	
	// Para testes
	private Evento evento = (Evento) new EventoDAO().pesquisarId(2);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaImportarProjeto frame = new TelaImportarProjeto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Area areaSelecionada() {
		Area area = (Area) getSelecionarArea().getSelectedItem();
		return area;
	}

	public Categoria categoriaSelecionada() {
		Categoria categoria = (Categoria) getSelecionarCategoria().getSelectedItem();
		return categoria;
	}

	private List<Projeto> botaoImportarProjetoCSV() {
		List<Projeto> projs = new ArrayList<Projeto>();
		return projs;
	}
	
	public TelaImportarProjeto(/**Evento evento*/) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEvento.setBounds(27, 46, 66, 15);
		contentPane.add(lblEvento);

		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Dialog", Font.BOLD, 14));
		lblArea.setBounds(27, 80, 66, 32);
		contentPane.add(lblArea);

		cbArea = new JComboBox();

		List<Area> areas = new ListarAreaController().listarAreas(evento);
		for (Area area : areas) {
			cbArea.addItem(area);
		}

		cbArea.setBounds(121, 84, 405, 24);
		contentPane.add(cbArea);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCategoria.setBounds(27, 142, 91, 15);
		contentPane.add(lblCategoria);

		cbCategoria = new JComboBox();

		List<Categoria> categorias = new ListarCategoriaController().listarCategoria(evento);
		for (Categoria categoria : categorias) {
			cbCategoria.addItem(categoria);
		}

		cbCategoria.setBounds(121, 137, 405, 24);
		contentPane.add(cbCategoria);

		JLabel lblImportarProjetoEm = new JLabel("Importar Projeto em CSV");
		lblImportarProjetoEm.setFont(new Font("Dialog", Font.BOLD, 17));
		lblImportarProjetoEm.setBounds(121, 0, 312, 32);
		contentPane.add(lblImportarProjetoEm);

		JButton btnProcurarCsv = new JButton("Procurar CSV");
		btnProcurarCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(btnProcurarCsv);
				File file = fc.getSelectedFile();
				try {
					caminho = Paths.get(file.getAbsolutePath());
					JOptionPane.showMessageDialog(btnProcurarCsv, "Local do arquivo: " + caminho.toString());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(btnProcurarCsv, "Arquivo não foi carregado");
				}
			}
		});
		btnProcurarCsv.setBounds(121, 206, 157, 25);
		contentPane.add(btnProcurarCsv);

		JButton btnImportarCsv = new JButton("Importar CSV");
		btnImportarCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Projeto> projetos = new ArrayList<Projeto>();
				String url = caminho.toString();
				
				projetos = new ImportarProjeto().importarProjetoCSV(url);

				for (int i = 0; i < projetos.size(); i++) {
					projetos.get(i).setArea(areaSelecionada());
					projetos.get(i).setEvento(evento);
					projetos.get(i).setCategoria(categoriaSelecionada());
				}

				new ImportarProjetoController().inserirProjeto(projetos);
				JOptionPane.showMessageDialog(btnProcurarCsv, "Inseridos " + projetos.size() + " projetos!");
			}

		});

		btnImportarCsv.setBounds(345, 206, 157, 25);
		contentPane.add(btnImportarCsv);

		JLabel lblNomeEvento = new JLabel(evento.getNome());
		lblNomeEvento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNomeEvento.setBounds(121, 41, 395, 24);
		contentPane.add(lblNomeEvento);

		setVisible(true);
		
	}

	public JComboBox getSelecionarArea() {
		return cbArea;
	}

	public JComboBox getSelecionarCategoria() {
		return cbCategoria;
	}
}
