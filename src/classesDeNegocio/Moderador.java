//dados do moderador
package classesDeNegocio;

import java.sql.SQLException;

import mysql.ModeradorDAO;

public class Moderador {
	
	/*atributos pro nome de login, senha e nome antigo para verificar o nome anterior antes de muda-lo 
	(usado no select do ModeradorDAO)*/
	private String nomeLogin, senha, nomeAntigo;
	//metodo construtor
	public Moderador() throws ClassNotFoundException, SQLException {
		/*nomeLogin e senha recebem os devidos valores na tabela moderador do sql 
		atraves dos metodos select da classe ModeradorDAO*/
		super();
		ModeradorDAO mDao = new ModeradorDAO();
		nomeLogin = mDao.selectNome();
		senha = mDao.selectSenha();
		
	}
	/*método pra alterar o nome e a senha do moderador, se o parametro nomeLogin ou senha for igual aos devidos atributos, 
	é retornado true, senao nomeAntigo recebe o valor atual do atributo nomeLogin e os atributos nomeLogin e senha recebem os
	novos valores e retorna true, se o parametro senha for vazio, o atributo senha não tem valor (sem senha)*/
	public boolean mudarNomeESenha(String nome, String senha) {
		if(nome.equals(this.nomeLogin)&&(senha.equals(this.senha))){
			return false;}
		else {
			nomeAntigo = this.nomeLogin;
			this.nomeLogin = nome;
			this.senha = senha;
			return true;}
		}
	//retornar o valor do nome
	public String getNome() {
		return nomeLogin;
	}
	//retornar o nome anterior(util para alterar o nome de login do moderador)
	public String getNomeAntigo() {
		return nomeAntigo;
	}
	//retornar o valor da senha
	public String getSenha() {
		return senha;
	}
	//checar se o nome e a senha do login são validos, se ambos os valores não estiverem corretos, é retornado false
	public boolean checarLogin(String nome, String senha) {
		if((nome.equals(this.nomeLogin)&&(senha.equals(this.senha)))){
			return true;}
		else {
			return false;
			}}}