//Janela para visualizar os dados da loja
package janelasVersaoMod;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import classesDeNegocio.LojaDados;
import mysql.LojaDAO;

public class DadosDaLoja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDigitarNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosDaLoja frame = new DadosDaLoja();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//dados do jframe
	public DadosDaLoja() throws ClassNotFoundException, SQLException {
		LojaDados loja = new LojaDados();
		//dados da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfDigitarNome = new JTextField();
		tfDigitarNome.setBounds(660, 32, 147, 20);
		contentPane.add(tfDigitarNome);
		tfDigitarNome.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(592, 34, 58, 17);
		contentPane.add(labelNome);
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setLineWrap(true);
		taDescricao.setBounds(700, 151, 537, 438);
		contentPane.add(taDescricao);
		
		JScrollPane escrolar = new JScrollPane(taDescricao);
		escrolar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		escrolar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		escrolar.setBounds(700, 151, 537, 438);
		contentPane.add(escrolar);
		
		JSpinner spinnerQntFuncionarios = new JSpinner();
		spinnerQntFuncionarios.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinnerQntFuncionarios.setBounds(1007, 32, 53, 20);
		contentPane.add(spinnerQntFuncionarios);
		
		JLabel labelQntFuncionarios = new JLabel("N\u00BA de funcion\u00E1rios da loja: ");
		labelQntFuncionarios.setBounds(840, 35, 157, 14);
		contentPane.add(labelQntFuncionarios);
		
		JLabel labelId = new JLabel("Id da loja: ");
		labelId.setBounds(418, 35, 84, 14);
		contentPane.add(labelId);
		
		/*JLabel labelImagem = new JLabel("New label");
		labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
		labelImagem.setBounds(176, 218, 495, 371);
		contentPane.add(labelImagem);*/
		
		JButton botaoAbrirFileChooser = new JButton("Selecionar imagem");
		botaoAbrirFileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser escolherArquivo = new JFileChooser();
				escolherArquivo.showOpenDialog(botaoAbrirFileChooser);
				escolherArquivo.setMultiSelectionEnabled(false);
				if(loja.setImagemLoja(String.valueOf(escolherArquivo.getSelectedFile()))== true) {
					JLabel labelImagem = new JLabel();
					labelImagem.setIcon(null);
					labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
					labelImagem.setBounds(176, 218, 495, 371);
					contentPane.add(labelImagem);
					ImageIcon imagemLoja = new ImageIcon(loja.getImagem());
					labelImagem.setIcon(imagemLoja);
				}
				else {
					JOptionPane.showMessageDialog(null, "arquivo inválido!");
				}
			}
		});
		botaoAbrirFileChooser.setBounds(327, 153, 175, 54);
		contentPane.add(botaoAbrirFileChooser);
		
		JSpinner spinnerTipoDeLoja = new JSpinner();
		spinnerTipoDeLoja.setModel(new SpinnerListModel(new String[] {"De roupas", "De eletr\u00F4nicos", "Derivados", 
				"Lanchonete", "Cinema", "Playground", "Outro"}));
		spinnerTipoDeLoja.setBounds(1007, 63, 102, 20);
		contentPane.add(spinnerTipoDeLoja);
		
		JSpinner spinnerId = new JSpinner();
		spinnerId.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		spinnerId.setBounds(472, 32, 46, 20);
		contentPane.add(spinnerId);
		
		JLabel labelTipoLoja = new JLabel("Tipo de loja:");
		labelTipoLoja.setBounds(903, 69, 84, 14);
		contentPane.add(labelTipoLoja);

		JButton botaoSalvar = new JButton("Salvar mudanças");
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loja.setDescricao(taDescricao.getText());
				if(loja.setId(String.valueOf(spinnerId.getValue())) && 
						loja.setQntFuncionarios(String.valueOf(spinnerQntFuncionarios.getValue()))&& 
						loja.setTipo(String.valueOf(spinnerTipoDeLoja.getValue()))&& 
						loja.setNome(tfDigitarNome.getText())==true) {
					LojaDAO lojaSql = new LojaDAO();
					try {
						lojaSql.inserirDadosDaLoja(loja);
						JOptionPane.showMessageDialog(null,"Novos dados na loja de ID "+ loja.getId()+ " inseridos!");
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		botaoSalvar.setBounds(700, 600, 173, 64);
		contentPane.add(botaoSalvar);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planta1Mod planta = null;
				try {
					planta = new Planta1Mod();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				planta.setVisible(true);
				setVisible(false);
			}
		});
		botaoVoltar.setBounds(472, 600, 173, 64);
		contentPane.add(botaoVoltar);
	}
}
