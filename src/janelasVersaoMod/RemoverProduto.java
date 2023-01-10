package janelasVersaoMod;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesDeNegocio.Produto;
import mysql.ProdutoDAO;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RemoverProduto extends JFrame {

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
					RemoverProduto frame = new RemoverProduto();
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
	public RemoverProduto() {
		Produto p = new Produto();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelIdProduto = new JLabel("ID do produto:");
		labelIdProduto.setBounds(48, 39, 80, 20);
		contentPane.add(labelIdProduto);
		
		JSpinner spinnerIdProduto = new JSpinner();
		spinnerIdProduto.setBounds(138, 39, 57, 20);
		contentPane.add(spinnerIdProduto);
		
		JSpinner SpinnerIdLoja = new JSpinner();
		SpinnerIdLoja.setBounds(138, 79, 57, 20);
		contentPane.add(SpinnerIdLoja);
		
		JLabel labelIdDaLoja = new JLabel("ID da loja:");
		labelIdDaLoja.setBounds(61, 81, 67, 17);
		contentPane.add(labelIdDaLoja);
		
		//remover produto através da pesquisa do seu id e da loja que ele pertence
		JButton botaoRemoverProduto = new JButton("Remover produto");
		botaoRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setId(String.valueOf(spinnerIdProduto.getValue()));
				p.setIdLoja(String.valueOf(SpinnerIdLoja.getValue()));
				ProdutoDAO remover = new ProdutoDAO();
				try {
					remover.removerProduto(p);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Valores não encontrados!");
				}
			}
		});
		botaoRemoverProduto.setBounds(61, 144, 134, 47);
		contentPane.add(botaoRemoverProduto);
	}

}
