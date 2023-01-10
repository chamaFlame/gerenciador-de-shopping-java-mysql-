package janelas;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import classesDeNegocio.Produto;
import mysql.ProdutoDAO;

public class VerProdutos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerProdutos frame = new VerProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public VerProdutos() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//tabela para ver os produtos da loja
		JTable tabelaProduto = new JTable();
		tabelaProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaProduto.setBounds(26, 30, 378, 200);
		//Navegação no JTable -> JScrollPane		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(26, 30, 1314, 648); //medidas e posição iguais ao JTable
		//Visualização do ScrollPane
		scroll.setViewportView(tabelaProduto);
		//Adiciona o scroll no JFrame(janela)
		contentPane.add(scroll);
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome"); //visualização
		modelo.addColumn("Preço");
		modelo.addColumn("Tipo");
		modelo.addColumn("Quantidade em estoque");
		Produto p = new Produto();
		ProdutoDAO pDAO = new ProdutoDAO();
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos = pDAO.Mostrar(p);
		//Mostrar isso Tabela (JTable)
		//for(int i=0; i < listaProdutos.size(); i++) {
		for(Produto pItem: listaProdutos) {
			//Cada linha:
			modelo.addRow(new Object[] {
					pItem.getImgProduto(),
					pItem.getNome(),
					pItem.getPreco(),
					pItem.getTipo(),
					pItem.getQntEstoque(),
			});
		} //fim for
		//Aplicar o modelo dentro do JTable:
		tabelaProduto.setModel(modelo);
	}
}
