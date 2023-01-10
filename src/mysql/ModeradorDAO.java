package mysql;
//importar todos os pacotes do sql
import java.sql.*;
//importar a classe moderador do pacote classesDeNegocio
import classesDeNegocio.Moderador;
public class ModeradorDAO {
	//criar objeto pra conexao com o mysql
	ConexaoMysql conexao = new ConexaoMysql(); 
	//metodo pra alterar o nome e a senha na tabela moderador do mysql
	public void alterarNomeESenha(Moderador m) throws ClassNotFoundException, SQLException { //p=novos valores do produto
		//Comando SQL -> insert...
		String sqlUpdateNomeELogin = "UPDATE moderador SET nomeLogin = ?, senha = ? WHERE nomeLogin = ?"; 
		//Criar o objeto para conexão com BD
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
				//Criar um objeto que constroi o comando SQL
		PreparedStatement comando = con.prepareStatement(sqlUpdateNomeELogin);
				// 1 -> ?
		comando.setString(1, m.getNome());
				// 2 -> ?
		comando.setString(2, m.getSenha());
		comando.setString(3, m.getNomeAntigo());
				//executar o comando SQL
		comando.execute();
				//fechar a conexão!
		con.close();
	}
	//metodo pra inserir o nome de login no atributo da classe moderador
	public String selectNome()throws ClassNotFoundException, SQLException{ 
		String nome = "SELECT nomeLogin FROM moderador"; 
		//Criar o objeto para conexão com BD
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		con.createStatement();
				//Criar um objeto que constroi o comando SQL
		Statement comando = con.createStatement();
				//executar o comando SQL
		ResultSet resultado = comando.executeQuery(nome);
		resultado.next();
		String login = resultado.getString("nomeLogin");
				//fechar a conexão!
		con.close();
		return login;
	}
	//metodo pra inserir nome da senha no atributo da classe moderador
	public String selectSenha()throws ClassNotFoundException, SQLException{ 
		String senha = "SELECT senha FROM moderador"; 
		//Conectando ao BD
		Connection con = conexao.conectar(); //-> .conectar()
		con.createStatement();
				//Criar um objeto que constroi o comando SQL
		Statement comando = con.createStatement();
				//executar o comando SQL
		ResultSet resultado = comando.executeQuery(senha);
		resultado.next();
		String senhaLogin = resultado.getString("senha");
				//fechar a conexão!
		con.close();
		return senhaLogin;
		}
	}
