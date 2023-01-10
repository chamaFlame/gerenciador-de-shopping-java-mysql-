package janelas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesDeNegocio.LojaDados;
import mysql.LojaDAO;

//metodo principal
public class JanelaPlanta1 extends JFrame {
	//id
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	//iniciar a janela
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPlanta1 frame = new JanelaPlanta1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					}}});}
	
	//elementos da janela
	public JanelaPlanta1() throws ClassNotFoundException, SQLException {
		LojaDados lojaDados = new LojaDados();
		Loja loja = new Loja();
		LojaDAO alterarDadosAbertos = new LojaDAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//cada botao abre uma loja diferente através da busca pelos dados contidos no id na tabela do sql
		//botão pra abrir os dados da loja
		JButton botaoAbrirLoja1 = new JButton("Abrir loja");
		botaoAbrirLoja1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lojaDados.setId("1");
					try {
						alterarDadosAbertos.alterarDadosPraAbrir(lojaDados);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				loja.setVisible(true);
			}
		});
		botaoAbrirLoja1.setBackground(Color.RED);
		botaoAbrirLoja1.setBounds(0, 161, 100, 100);
		contentPane.add(botaoAbrirLoja1);
		
		//botão pra abrir os dados da loja
		JButton botaoAbrirLoja2 = new JButton("Abrir loja");
		botaoAbrirLoja2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lojaDados.setId("2");
				try {
					alterarDadosAbertos.alterarDadosPraAbrir(lojaDados);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			loja.setVisible(true);
			}
		});
		botaoAbrirLoja2.setBackground(Color.RED);
		botaoAbrirLoja2.setBounds(0, 260, 100, 100);
		contentPane.add(botaoAbrirLoja2);
		
		//botão pra abrir os dados da loja
		JButton botaoAbrirLoja3 = new JButton("Abrir loja");
		botaoAbrirLoja3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lojaDados.setId("3");
				try {
					alterarDadosAbertos.alterarDadosPraAbrir(lojaDados);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			loja.setVisible(true);
			}
		});
		botaoAbrirLoja3.setBackground(Color.RED);
		botaoAbrirLoja3.setBounds(0, 358, 100, 100);
		contentPane.add(botaoAbrirLoja3);
		
		//botão pra abrir os dados da loja
		JButton botaoAbrirLoja4 = new JButton("Abrir loja");
		botaoAbrirLoja4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lojaDados.setId("4");
				try {
					alterarDadosAbertos.alterarDadosPraAbrir(lojaDados);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			loja.setVisible(true);
			}
		});
		botaoAbrirLoja4.setBackground(Color.RED);
		botaoAbrirLoja4.setBounds(592, 161, 100, 100);
		contentPane.add(botaoAbrirLoja4);
		
		//botão pra abrir os dados da loja
		JButton botaoAbrirLoja5 = new JButton("Abrir loja");
		botaoAbrirLoja5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lojaDados.setId("5");
				try {
					alterarDadosAbertos.alterarDadosPraAbrir(lojaDados);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			loja.setVisible(true);
			}
		});
		botaoAbrirLoja5.setBackground(Color.RED);
		botaoAbrirLoja5.setBounds(592, 358, 100, 100);
		contentPane.add(botaoAbrirLoja5);
		
		//botão pra abrir os dados da loja
		JButton botaoAbrirLoja6 = new JButton("Abrir loja");
		botaoAbrirLoja6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lojaDados.setId("6");
				try {
					alterarDadosAbertos.alterarDadosPraAbrir(lojaDados);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			loja.setVisible(true);
			}
		});
		botaoAbrirLoja6.setBackground(Color.RED);
		botaoAbrirLoja6.setBounds(1250, 358, 100, 100);
		contentPane.add(botaoAbrirLoja6);
		
		//botão pra abrir os dados da loja
		JButton botaoAbrirLoja7 = new JButton("Abrir loja");
		botaoAbrirLoja7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lojaDados.setId("7");
				try {
					alterarDadosAbertos.alterarDadosPraAbrir(lojaDados);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			loja.setVisible(true);
			}
		});
		botaoAbrirLoja7.setBackground(Color.RED);
		botaoAbrirLoja7.setBounds(1250, 161, 100, 100);
		contentPane.add(botaoAbrirLoja7);
		
		//botão pra abrir os dados da loja
		JButton botaoAbrirLoja8 = new JButton("Abrir loja");
		botaoAbrirLoja8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lojaDados.setId("8");
				try {
					alterarDadosAbertos.alterarDadosPraAbrir(lojaDados);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			loja.setVisible(true);
			}
		});
		botaoAbrirLoja8.setBackground(Color.RED);
		botaoAbrirLoja8.setBounds(1250, 260, 100, 100);
		contentPane.add(botaoAbrirLoja8);
		
		//botão pra abrir a planta 2
		JButton botaoPlanta2 = new JButton("Planta 2");
		botaoPlanta2.setBackground(Color.BLUE);
		botaoPlanta2.setBounds(547, 0, 191, 43);
		contentPane.add(botaoPlanta2);
		
		//botão pra abrir a planta do estacionamento
		JButton botaoEstacionamento = new JButton("Estacionamento");
		botaoEstacionamento.setBackground(Color.BLUE);
		botaoEstacionamento.setBounds(0, 646, 153, 43);
		contentPane.add(botaoEstacionamento);
		
		//botão pra abrir a planta 3
		JButton botaoPlanta3 = new JButton("Planta 3");
		botaoPlanta3.setBackground(Color.BLUE);
		botaoPlanta3.setBounds(0, 540, 153, 43);
		contentPane.add(botaoPlanta3);
		
		//botão pra abrir a planta do estacionamento
		JButton botao2Estacionamento = new JButton("Estacionamento");
		botao2Estacionamento.setBackground(Color.BLUE);
		botao2Estacionamento.setBounds(1197, 646, 153, 43);
		contentPane.add(botao2Estacionamento);
		
		//botão pra abrir a planta 2
		JButton botaoPlanta4 = new JButton("Planta 4");
		botaoPlanta4.setBackground(Color.BLUE);
		botaoPlanta4.setBounds(1197, 540, 153, 43);
		contentPane.add(botaoPlanta4);
		
}
	}