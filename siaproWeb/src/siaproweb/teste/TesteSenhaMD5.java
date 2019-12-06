package siaproweb.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import siaproweb.conexao.Conexao;
import siaproweb.core.EncryptMD5;
import siaproweb.model.Avaliador;


public class TesteSenhaMD5 {

	public static void main(String[] args) {
		String sql = "select * from avaliador"; 
		ArrayList<Avaliador> avaliadores =  new ArrayList<>();
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Avaliador avaliador = new Avaliador();
				avaliador.setId(rs.getLong("id"));
				avaliador.setNome(rs.getString("nome"));
				avaliador.setLogin(rs.getString("login"));
				avaliador.setSenha(EncryptMD5.encryptText(rs.getString("senha")));
				avaliadores.add(avaliador);	
			}
			stmt.close();
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		for (Avaliador avaliador : avaliadores) {
			System.out.println(avaliador.getId() + "-" + avaliador.getSenha());
			String sql1 = "update avaliador set nome = ?, login = ?, senha = ? where id = ?";
			try {
				Connection conexao = new Conexao().getConexao();
				PreparedStatement stmt = conexao.prepareStatement(sql1);
				stmt.setString(1, avaliador.getNome());
				stmt.setString(2, avaliador.getLogin());
				stmt.setString(3, avaliador.getSenha());
				stmt.setLong(4, avaliador.getId());
				stmt.execute();
				stmt.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
