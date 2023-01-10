package classesDeNegocio;
public class LojaDados {
	//atributos do nome, descricao, url do local da imagem da loja no pc, numero de id da lojae a quantidade de funcionários
	private String nome, descricao, imagemLoja, tipo;
	private Integer id, qntFuncionarios;
	private Produto produto;
	/*metodo pra inserir nome da loja, se o nome estiver vazio é retornado false, senão o atributo recebe o valor do parametro
	 e é retornado true */
	public boolean setNome(String nome) {
		if(nome.isBlank()) {
			return false;}
		else {
			this.nome = nome;
			return true;}
	}
	//metodo pra receber a descricao da loja, util para a visualização dos clientes
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/*inserir a quantidade de funcionarios da loja, todos os não numerais são removidos do parametro, se o parametro estiver 
	vazio é retornado false, senão o atributo qntFuncionarios recebe o valor do parametro convertido pra Integer e retorna true
	*/
	public boolean setQntFuncionarios(String qntFuncionarios) {
		qntFuncionarios = qntFuncionarios.replaceAll("[\\D]", "");
		if(qntFuncionarios.isBlank()) {
			return false;}
		else {
			this.qntFuncionarios = Integer.valueOf(qntFuncionarios);
			return true;}
	}
	/*metodo pra inserir a imagem da loja (atraves do JFileChooser), o parametro recebe o endereço(url) da imagem e substitui
	 todas as barras invertidas por barras duplas invertidas, assim validando a url da imagem, se for um arquivo de imagem 
	 (if imagemLoja[...]) o atributo imagemLoja recebe a url e retorna true, senão retorna false*/
	public boolean setImagemLoja(String imagemLoja) {
		imagemLoja = imagemLoja.replace("\\", "\\\\");
		if(imagemLoja.contains(".jpg")||imagemLoja.contains(".bmp")||imagemLoja.contains(".jpeg")
				||imagemLoja.contains(".png")||imagemLoja.contains(".gif")) {
			this.imagemLoja = imagemLoja;
			return true;}
		else {
			return false;}
	}
	//metodo pra inserir o id da loja
	public boolean setId(String id) {
		id = id.replaceAll("[\\D]", "");
		if(id.isBlank()) {
			return false;}
		else {
			if(Integer.valueOf(id)<1 || Integer.valueOf(id)>8) {
				return false;
			}
			else{
				this.id = Integer.valueOf(id);
				return true;}}
	}
	//metodo pra retornar o nome da loja
	public String getNome() {
		return nome;
	}
	//metodo pra retornar a descricao da loja
	public String getDescricao() {
		return descricao;
	}
	//metodo pra retornar o id da loja
	public Integer getId() {
		return id;
	}
	//metodo pra retornar a quantidade de funcionarios da loja
	public Integer getQntFuncionarios() {
		return qntFuncionarios;
	}
	//metodo pra retornar o tipo da loja
	public String getTipo() {
		return tipo;
	}
	//metodo pra retornar o link da imagem da loja
	public String getImagem() {
		return imagemLoja;
	}
	public boolean setTipo(String tipo) {
		if(tipo.isBlank()) {
			return false;}
		else {
			this.tipo = tipo;
			return true;}
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
