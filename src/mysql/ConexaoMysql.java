package mysql;
//importar todos os pacotes do sql
import java.sql.*; 
public class ConexaoMysql {
	//dados de acesso ao mysql
	private String database = "ProjetoShopping"; // use vendas;
	private String usuario = "root"; // usuário de acesso
	private String senha = "ikaonapu6";
	//url=endereço do servidor MySQL
	private String url = "jdbc:mysql://localhost:3306/"+database;	
	//metodo pra conectar o projeto à database
	public Connection conectar() throws ClassNotFoundException, SQLException { //cada conexão = id (Connection)
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
		}}