package classesDeNegocio;

public class Produto {
	private String nome, tipo, marca, imgProduto;
	private Float preco;
	private Integer id, idLoja, qntEstoque;
	//metodo pra inserir o id da loja, todos os não numerais são removidos
	public boolean setId(String id) {
		id = id.replaceAll("[\\D]", "");
		if(id.isBlank()) {
			return false;}
		else {
			this.id = Integer.valueOf(id);
			return true;
		}}
	//mesmo que o método do id, o atributo serve como uma chave estrangeira, pra saber a qual loja o produto está ligado
	public boolean setIdLoja(String idLoja) {
		idLoja = idLoja.replaceAll("[\\D]", "");
		if(idLoja.isBlank()) {
			return false;}
		else {
			if(Integer.valueOf(idLoja)<1 || Integer.valueOf(idLoja)>8) {
				return false;
			}
			else{
				this.idLoja = Integer.valueOf(idLoja);
				return true;}}
	}
	//inserir o nome do produto
	public boolean setNome(String nome) {
		if(nome.isBlank()) {
			return false;}
		else {
			this.nome = nome;
			return true;}
	}
	//inserir o tipo do produto(roupa, eletronico, filme...)
	public boolean setTipo(String tipo) {
		if(tipo.isBlank()) {
			return false;}
		else {
			this.tipo = tipo;
			return true;}
	}
	//inserir o preço do produto através dos valores de 2 textFields, onde todos os não numerais são removidos
	public boolean setPreco(String preco1, String preco2) {
		preco1 = preco1.replaceAll("[\\D]", "");
		preco2 = preco2.replaceAll("[\\D]", "");
		if(preco1.isBlank()&& preco2.isBlank()) {
			return false;}
		else {
			this.preco = Float.valueOf(preco1+"."+preco2);
			return true;}
	}
	//metodo pra inserir o preço com apenas parametro float  
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	//metodo pra inserir a marca do produto, similar ao metodo setNome
	public boolean setMarca(String marca) {
		if(marca.isBlank()) {
			return false;}
		else {
			this.marca = marca;
			return true;}
	}
	/*metodo pra inserir um arquivo de imagem através de um imageIcon, onde o arquivo deve ser uma imagem para que 
	 * seja retornado true*/
	public boolean setImgProduto(String imgProduto) {
		imgProduto = imgProduto.replace("\\", "\\\\");
		if(imgProduto.contains(".jpg")||imgProduto.contains(".bmp")||imgProduto.contains(".jpeg")
				||imgProduto.contains(".png")||imgProduto.contains(".gif")) {
			this.imgProduto = imgProduto;
			return true;}
		else {
			return false;}
	}
	//inserir a quantidade do produto em estoque
	public boolean setQntEstoque(String qntEstoque) {
		qntEstoque = qntEstoque.replaceAll("[\\D]", "");
		if(qntEstoque.isBlank()) {
			return false;}
		else {
			this.qntEstoque = Integer.valueOf(qntEstoque);
			return true;}
		}
	//inserir a quantidade do produto em estoque com apenas 1 parametro Integer  
	public void setQntEstoque(Integer qntEstoque) {
		this.qntEstoque = qntEstoque;
	}
	//todos abaixo são metodos de retorno
	public String getNome() {
		return nome;
	}
	public String getTipo() {
		return tipo;
	}
	public Float getPreco() {
		return preco;
	}
	public String getMarca() {
		return marca;
	}
	public Integer getId() {
		return id;
	}
	public Integer getIdLoja() {
		return idLoja;
	}
	public String getImgProduto() {
		return imgProduto;
	}
	public Integer getQntEstoque() {
		return qntEstoque;
	}
	}