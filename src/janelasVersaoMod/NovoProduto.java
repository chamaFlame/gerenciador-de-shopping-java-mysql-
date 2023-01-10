package janelasVersaoMod;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import classesDeNegocio.Produto;
import mysql.ProdutoDAO;

import javax.swing.SpinnerNumberModel;

public class NovoProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txDigitarMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoProduto frame = new NovoProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovoProduto() {
		//elementos da janela
		Produto produto = new Produto();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField tfDigitarNome = new JTextField();
		tfDigitarNome.setBounds(660, 32, 147, 20);
		contentPane.add(tfDigitarNome);
		tfDigitarNome.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(604, 34, 46, 17);
		contentPane.add(labelNome);
		
		JLabel labelId = new JLabel("Id da loja: ");
		labelId.setBounds(418, 35, 52, 14);
		contentPane.add(labelId);
		
		JSpinner spinnerId = new JSpinner();
		spinnerId.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		spinnerId.setBounds(472, 32, 46, 20);
		contentPane.add(spinnerId);
		
		JSpinner spinnerIdProduto = new JSpinner();
		spinnerIdProduto.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinnerIdProduto.setBounds(472, 60, 46, 20);
		contentPane.add(spinnerIdProduto);
		
		JLabel labelIdProduto = new JLabel("Id do produto:");
		labelIdProduto.setBounds(400, 63, 70, 14);
		contentPane.add(labelIdProduto);
		
		//filechooser para selecionar a imagem da loja, apenas arquivos de imagem serão aceitos
		JButton botaoAbrirFileChooser = new JButton("Selecionar imagem");
		botaoAbrirFileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser escolherArquivo = new JFileChooser();
				escolherArquivo.showOpenDialog(botaoAbrirFileChooser);
				escolherArquivo.setMultiSelectionEnabled(false);
				if(produto.setImgProduto(String.valueOf(escolherArquivo.getSelectedFile()))== true) {
					JLabel labelImagem = new JLabel();
					labelImagem.setIcon(null);
					labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
					labelImagem.setBounds(176, 218, 495, 371);
					contentPane.add(labelImagem);
					ImageIcon imagemLoja = new ImageIcon(produto.getImgProduto());
					labelImagem.setIcon(imagemLoja);
				}
				else {
					JOptionPane.showMessageDialog(null, "arquivo inválido!");
				}
			}
		});
		botaoAbrirFileChooser.setBounds(327, 153, 175, 54);
		contentPane.add(botaoAbrirFileChooser);
		
		JLabel labelTipoProduto = new JLabel("Tipo de produto:");
		labelTipoProduto.setBounds(900, 34, 84, 14);
		contentPane.add(labelTipoProduto);
		
		JSpinner spinnerTipoDeProduto = new JSpinner();
		spinnerTipoDeProduto.setModel(new SpinnerListModel(new String[] {"Roupa", "Eletr\u00F4nico", "Alimento", "Filme", "Outro"}));
		spinnerTipoDeProduto.setBounds(1000, 33, 102, 20);
		contentPane.add(spinnerTipoDeProduto);
		
		JLabel labelPreco = new JLabel("preco: R$");
		labelPreco.setBounds(900, 86, 84, 14);
		contentPane.add(labelPreco);
		
		JTextField preco1 = new JTextField();
		preco1.setBounds(950, 84, 84, 20);
		contentPane.add(preco1);
		preco1.setColumns(10);
		
		JLabel ponto = new JLabel(",");
		ponto.setHorizontalAlignment(SwingConstants.CENTER);
		ponto.setBounds(1035, 88, 4, 14);
		contentPane.add(ponto);
		
		JTextField preco2 = new JTextField();
		preco2.setBounds(1039, 84, 84, 20);
		contentPane.add(preco2);
		preco2.setColumns(10);
		
		JLabel labelMarca = new JLabel("Marca:");
		labelMarca.setBounds(592, 83, 58, 17);
		contentPane.add(labelMarca);
		
		txDigitarMarca = new JTextField();
		txDigitarMarca.setColumns(10);
		txDigitarMarca.setBounds(660, 83, 147, 20);
		contentPane.add(txDigitarMarca);
		
		JSpinner spinnerQntEstoque = new JSpinner();
		spinnerQntEstoque.setBounds(472, 91, 46, 20);
		contentPane.add(spinnerQntEstoque);
		
		JLabel labelQntEstoque = new JLabel("Quantidade em estoque");
		labelQntEstoque.setBounds(342, 94, 128, 14);
		contentPane.add(labelQntEstoque);
		/*inserir novo produto no sql, se todos os metodos sets retornarem true, o método para inserir na tabela é chamado
		 * senão é mostrada uma mensagem indicando erro*/
		JButton botaoSalvar = new JButton("Salvar novo produto");
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(produto.setId(String.valueOf(spinnerId.getValue()))&& 
						produto.setIdLoja(String.valueOf(spinnerIdProduto.getValue()))&& 
						produto.setMarca(txDigitarMarca.getText()) && produto.setNome(tfDigitarNome.getText()) && 
						produto.setPreco(preco1.getText(), preco2.getText()) && 
						produto.setQntEstoque(String.valueOf(spinnerQntEstoque.getValue()))&& 
						produto.setTipo(String.valueOf(spinnerTipoDeProduto.getValue()))== true) {
					ProdutoDAO sql = new ProdutoDAO();
					try {
						sql.inserirNovoProduto(produto);
						JOptionPane.showMessageDialog(null, "Produto "+ produto.getNome()+ " inserido na loja "
						+produto.getIdLoja());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Há valores incorretos! por favor verifique novamente");
				}
			}
		});
		botaoSalvar.setBounds(604, 506, 173, 64);
		contentPane.add(botaoSalvar);
		//botao pra abrir a janela pra remover o produto da tabela do sql
		JButton botaoRemoverProduto = new JButton("Remover produto");
		botaoRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverProduto janelaDeRemover = new RemoverProduto();
				janelaDeRemover.setVisible(true);
			}
		});
		botaoRemoverProduto.setBounds(604, 581, 173, 54);
		contentPane.add(botaoRemoverProduto);
	}
}
