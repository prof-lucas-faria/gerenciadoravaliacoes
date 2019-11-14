package siapro.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import siapro.model.Avaliador;

public class ImportarAvaliador {

	public boolean importar() {
		try {
			FileReader leitura = new FileReader("D:\\arquivo.csv");
			BufferedReader ler = new BufferedReader(leitura);
			ler.readLine();
			while (ler.ready()) {
				String linha = ler.readLine();
				String[] colunas = linha.split(",");
				String[] areas = this.formatar(linha).split(",");
				
				Avaliador a = new Avaliador();
				a.setNome(colunas[0]);
				a.setLogin(colunas[1]);
				a.setSenha(colunas[2]);
				
				System.out.println("Nome: " + a.getNome());
				System.out.println("Login: " +a.getLogin());
				System.out.println("Senha: " +a.getSenha());
				int i;
				for(i=0; i<areas.length ;i++) {
					System.out.println("Area"+(i+1)+": "+ areas[i]);
				}
				System.out.println("\n");
				

			}
			ler.close();
			leitura.close();
			return true;
		} catch (IOException ex1) {
			System.out.println("Erro lendo arquivo. " + ex1.getLocalizedMessage());
			return false;
		}
	}

	public static List<String> lerArquivo(File arquivo) {
		List<String> linhas = new ArrayList<>();
		try {
			FileReader leitura = new FileReader(arquivo);
			BufferedReader ler = new BufferedReader(leitura);
			while (ler.ready()) {
				linhas.add(ler.readLine());
			}
			ler.close();
			leitura.close();
			return linhas;
		} catch (IOException ex1) {
			System.out.println("Erro lendo arquivo. " + ex1.getLocalizedMessage());
		}
		return null;
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
