package siapro.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

import siapro.model.Projeto;

public class ImportarProjeto {

	public List<Projeto> importarProjetoCSV(String url) {
		List<Projeto> projetos = new ArrayList<Projeto>();
		try {
			CsvReader leerProjetos = new CsvReader(url);
			leerProjetos.readHeaders();
			while (leerProjetos.readRecord()) {
				String titulo = leerProjetos.get(0);
				String autores = leerProjetos.get(1);
				;
				Projeto projeto = new Projeto();
				projeto.setTitulo(titulo);
				projeto.setAutores(autores);

				projetos.add(projeto);
			}
			leerProjetos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projetos;
	}

}
