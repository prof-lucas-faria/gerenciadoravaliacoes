package siapro.conexao;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

	private static final String DSN = "jdbc:mysql://localhost/sistemagerenciadordeavaliacoes?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	
	public Connection getConexao() {
		try {
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
