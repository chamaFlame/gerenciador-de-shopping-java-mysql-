package mysql;
import java.sql.*;
import java.util.ArrayList;

import classesDeNegocio.Produto;
public class ProdutoDAO {
	ConexaoMysql conexao = new ConexaoMysql();
	//metodo pra inserir um novo produto na tabela do s2l
	public void inserirNovoProduto(Produto p) throws ClassNotFoundException, SQLException {
		String insert = "INSERT INTO produto(id, idLoja, nome, preco, tipo, qntEstoque, imgProduto) "
				+ "VALUES(?, (SELECT id FROM loja WHERE id = ?), ?, ?, ?, ?, ?)";
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(insert);
		comando.setInt(1, p.getId());
		comando.setInt(2, p.getIdLoja());
		comando.setString(3, p.getNome());
		comando.setFloat(4, p.getPreco());
		comando.setString(5, p.getTipo());
		comando.setInt(6, p.getQntEstoque());
		comando.setString(7, p.getImgProduto());
		comando.execute();
		con.close();
	}
	//metodo pra remover um produto inserido através do id do produto e da loja ligada a ele
	public void removerProduto(Produto p)throws ClassNotFoundException, SQLException {
		String remover = "DELETE FROM produto WHERE id = ? AND idLoja = ?";
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(remover);
		comando.setInt(1, p.getId());
		comando.setInt(2, p.getIdLoja());
		comando.execute();
		con.close();;
	}
	//metodo pra retornar os produtos inseridos de acordo com a loja escolhida no metodo selectLojaAberta
	public ArrayList<Produto> Mostrar(Produto p)throws ClassNotFoundException, SQLException{
		LojaDAO loja = new LojaDAO();
		String select = "SELECT * FROM produto WHERE idLoja = "+ loja.selectLojaAberta();
		Connection con = conexao.conectar();
		PreparedStatement comando = con.prepareStatement(select);
		ArrayList<Produto> resultado = new ArrayList<Produto>();
		ResultSet rs = comando.executeQuery(); 
		while(rs.next()) {
			Produto p1 = new Produto();
			p1.setImgProduto(rs.getString("imgProduto"));
			p1.setNome(rs.getString("nome"));
			p1.setPreco(rs.getFloat("preco"));
			p1.setTipo(rs.getString("tipo"));
			p1.setQntEstoque(rs.getInt("qntEstoque"));
			resultado.add(p1);}
		con.close();
		return resultado;
	}
}
