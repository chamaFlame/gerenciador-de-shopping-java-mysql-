package mysql;
import java.sql.*;
//importar a classe Loja do pacote classesDeNegocio
import classesDeNegocio.LojaDados;
public class LojaDAO {
	/*metodo pra inserir os dados da loja na tabela loja do mysql, os valores serão alterados por update, cada id terá 
	 * informações diferentes pois são lojas diferentes, que serão inseridas nas janelas através de select posteriormente*/
	public void inserirDadosDaLoja(LojaDados l)throws ClassNotFoundException, SQLException {
		ConexaoMysql conexao = new ConexaoMysql();
		String sqlInserirDadosLoja = "UPDATE loja SET nome = ?, descricao = ?, qntFuncionarios = ?, imagemLoja = ? "
				+ "WHERE id = ?";
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(sqlInserirDadosLoja);
		comando.setString(1, l.getNome());
		comando.setString(2, l.getDescricao());
		comando.setInt(3, l.getQntFuncionarios());
		comando.setString(4, l.getImagem());
		comando.setInt(5, l.getId());
		comando.execute();
		con.close();
	}
	//metodo pra selecionar os dados retornados da tabela da loja
	public String selectDadoLoja(String nomeDaColuna)throws ClassNotFoundException, SQLException{
		ConexaoMysql conexao = new ConexaoMysql();
		String sqlSelect = "SELECT "+nomeDaColuna + " FROM loja WHERE id = "+ selectLojaAberta();
		Connection con = conexao.conectar(); //-> .conectar()
		con.createStatement();
		Statement comando = con.createStatement();
		ResultSet resultado = comando.executeQuery(sqlSelect);
		resultado.next();
		String selecao = resultado.getString(nomeDaColuna);
		con.close();
		return selecao;
	}
	//metodo pra alterar a loja que será visualizada
	public void alterarDadosPraAbrir(LojaDados l)throws ClassNotFoundException, SQLException{
		ConexaoMysql conexao = new ConexaoMysql();
		String alterarSelecao = "UPDATE tabelaPraAbrir SET tabelaId = ?"; 
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(alterarSelecao);
		comando.setInt(1, l.getId());
		comando.execute();
		con.close();
	}
	//metodo pra selecionar a loja que será visualizada
	public Integer selectLojaAberta()throws ClassNotFoundException, SQLException{
		ConexaoMysql conexao = new ConexaoMysql();
		String seletor = "SELECT tabelaId FROM tabelaPraAbrir";
		Connection con = conexao.conectar(); //-> .conectar()
		con.createStatement();
		Statement comando = con.createStatement();
		ResultSet resultado = comando.executeQuery(seletor);
		resultado.next();
		Integer idDados = resultado.getInt("tabelaId");
		con.close();
		return idDados;
	}
}
