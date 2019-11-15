package siapro.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import siapro.controller.ImportarAvaliadorController;
import siapro.model.Area;
import siapro.model.Avaliador;

public class ImportarAvaliador {

	public boolean importar() {
		try {
			FileReader leitura = new FileReader("D:\\arquivo.csv");
			BufferedReader ler = new BufferedReader(leitura);
			ler.readLine();
			List<Avaliador> avaliadores = new ArrayList<Avaliador>();
			while (ler.ready()) {
				String linha = ler.readLine();
				String[] colunas = linha.split(",");
				String[] areas = this.formatar(linha).split(",");
				ArrayList<Area> areaList = new ArrayList<Area>();
				
				Avaliador a = new Avaliador();
				a.setNome(colunas[0]);
				a.setLogin(colunas[1]);
				a.setSenha(colunas[2]);
				
				//System.out.println("Nome: " + a.getNome());
				//System.out.println("Login: " +a.getLogin());
				
				
				int i;
				for(i=0; i<areas.length ;i++) {
					
					areaList.add(new Area(areas[i]));
					//System.out.println("Area"+(i+1)+": "+ areas[i]);
				}
				
				a.setArea(areaList);
				//System.out.println("\n");
				//System.out.println("a: " +a.getArea().get(1).getNome());
				

			}
			new ImportarAvaliadorController().salvarAvaliadores(avaliadores);
			
			ler.close();
			leitura.close();
			return true;
		} catch (IOException ex1) {
			System.out.println("Erro lendo arquivo. " + ex1.getLocalizedMessage());
			return false;
		}
	}


	public String formatar(String linha) {
		String regex = "\"([^\"]*)\""; // regex com um grupo entre aspas
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(linha); // linha é a variável que contém a linha que foi lida do arquivo
		if (matcher.find()) {
		    String textoEntreAspas = matcher.group(1); // obtém o grupo lido da regex
		    return textoEntreAspas;
		}
		return null;
	}

}
