package siapro.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportarProjeto {
	
	public boolean importar(String url) {
		File arquivoCSV = new File(url);
		boolean resposta = false;
		try {
			String linhasArquivo;
			Scanner leitor = new Scanner(arquivoCSV);
			leitor.nextLine(); // pular linha de nome das colunas
			
			while(leitor.hasNext()) { // Fazer leitura e separar
				linhasArquivo = leitor.nextLine();
				String[] valoresSepara = linhasArquivo.split(";"); // remover ;
/*				System.out.println("titulo = " + valoresSepara[0] + 
						" autores = " + valoresSepara[1] + " outros = " + valoresSepara[2]);
*/			
			}
			
			resposta = true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return resposta;
	}

}
