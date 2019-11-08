package siapro.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportarAvaliador {

	public boolean importar() {
		try {
			FileReader leitura = new FileReader("D:\\");
			BufferedReader ler = new BufferedReader(leitura);
			ler.
			while (ler.ready()) {
				String linha = ler.readLine();
				String[] colunas = linha.split("\t");
				/*
				 * A partir daqui voce vê como quer fazer. Se daqui ja chama o banco e popula o
				 * preparedstatement Ou apenas retorna uma lista de linhas para outro metodo
				 * pegar cada linha e jogar no banco. Eu uso esse metodo para devolver um
				 * List<String> e depois em outra classe eu percorro o List Faco o SPLIT das
				 * linhas e faco o que deve ser feito. abaixo vou postar a forma que eu uso.
				 */

			}
			ler.close();
			leitura.close();
			return linha;
		} catch (IOException ex1) {
			System.out.println("Erro lendo arquivo. " + ex1.getLocalizedMessage());
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

}
