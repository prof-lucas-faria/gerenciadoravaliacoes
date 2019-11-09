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
				String[] colunas = linha.split("");

				Avaliador a = new Avaliador();
				a.setNome(colunas[0]);
				a.setLogin(colunas[1]);
				a.setSenha(colunas[2]);

				System.out.println(a.getNome());
				System.out.println(a.getLogin());
				System.out.println(a.getSenha());

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

	public void formatar() {
		
		final String regex = "\\G" // Início do texto ou fim do casamento anterior
				+ "[^\\\"']*" // Texto sem colchetes nem aspas simples
				+ "(?:'[^']*'[^\\\"'*]*)*" // Opcional: Texto em aspas + texto sem "[" nem "'"
				+ "(\\\"" // Grupo 1: Colchete de abertura
				+ "[^]']*" // + texto sem "]" nem "'"
				+ "(?:'[^']*'[^]']*)*" // + texto em aspas + texto sem "]" nem "'"
				+ "\\\")"; // + colchete de fechamento
		final Pattern pat = Pattern.compile(regex);
		Matcher mat;

		final String[] entrada = { "1 + [aa]", "[bb] + 2", "'a' + [cc]", "['ola' + 'mundo']", "'[a' + 'b]'",
				"'[' + ']'", "[]", "'Ola [world] legal'", "Oi ['[aa]'] ola" };

//Loop cada string na entrada
		for (String stringlToVerify : entrada) {
			mat = pat.matcher(stringlToVerify);
			System.out.println("\nEntrada: " + stringlToVerify);

			if (mat.find())
				do { // Loop cada texto entre colchetes casado
					System.out.println("Captura: " + mat.group(1));
				} while (mat.find());
			else
				System.out.println("Não há colchetes fora das aspas");
		}
	}

}
