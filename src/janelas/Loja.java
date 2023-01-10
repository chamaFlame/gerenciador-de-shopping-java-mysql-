package janelas;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mysql.LojaDAO;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loja extends JFrame {

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
					Loja frame = new Loja();
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
	public Loja() throws ClassNotFoundException, SQLException {
		LojaDAO select = new LojaDAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//elementos da janela
		JTextArea taDescricao = new JTextArea();
		taDescricao.setEditable(false);
		taDescricao.setLineWrap(true);
		taDescricao.setText(select.selectDadoLoja("descricao"));
		taDescricao.setBounds(700, 151, 649, 438);
		contentPane.add(taDescricao);
		JScrollPane escrolar = new JScrollPane(taDescricao);
		escrolar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		escrolar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		escrolar.setBounds(700, 151, 649, 438);
		contentPane.add(escrolar);
		
		JLabel labelImagem = new JLabel();
		labelImagem.setIcon(null);
		labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
		labelImagem.setBounds(10, 151, 661, 438);
		contentPane.add(labelImagem);
		ImageIcon imagemLoja = new ImageIcon(select.selectDadoLoja("imagemLoja"));
		labelImagem.setIcon(imagemLoja);
		
		JLabel labelNomeDaLoja = new JLabel(select.selectDadoLoja("nome"));
		labelNomeDaLoja.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeDaLoja.setFont(new Font("Arial Black", Font.PLAIN, 30));
		labelNomeDaLoja.setBounds(10, 38, 661, 110);
		contentPane.add(labelNomeDaLoja);
		
		//abrir janela pra mostrar a tabela de produtos da loja
		JButton botaoMostrarProdutos = new JButton("Ver Produtos");
		botaoMostrarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VerProdutos produtos = new VerProdutos();
					produtos.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botaoMostrarProdutos.setBounds(1168, 600, 181, 78);
		contentPane.add(botaoMostrarProdutos);
	}
}