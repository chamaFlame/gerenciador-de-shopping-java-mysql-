//janela pra alterar o nome e a senha do moderador 
package janelasVersaoMod;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import classesDeNegocio.Moderador;
import janelas.JanelaClienteOuModerador;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import mysql.ModeradorDAO;
public class InserirNovoNomeESenha extends JanelaClienteOuModerador {
	
	private static final long serialVersionUID = 2L;
	private JPanel contentPane;
	private JTextField txNovoNome;
	private JPasswordField pfSenha;
	//main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirNovoNomeESenha frame = new InserirNovoNomeESenha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});}
	//elementos do frame
	public InserirNovoNomeESenha() {
		//dados da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//logo do shopping
		JLabel Logo = new JLabel("local da imagem");
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setBounds(521, 95, 349, 226);
		contentPane.add(Logo);
		
		//objeto da imagem da logo
		ImageIcon imgLogo = new ImageIcon("C:\\Users\\paulorenam\\Downloads\\logo.jpg");
		Logo.setIcon(imgLogo);
		
		//campo pra digitar o novo nome de login
		txNovoNome = new JTextField();
		txNovoNome.setBounds(582, 360, 220, 26);
		contentPane.add(txNovoNome);
		txNovoNome.setColumns(10);
		
		//campo pra digitar a nova senha
		pfSenha = new JPasswordField();
		pfSenha.setBounds(582, 419, 220, 26);
		contentPane.add(pfSenha);
		
		//label pro campo do nome
		JLabel labelNome = new JLabel("Novo Nome:");
		labelNome.setBounds(485, 360, 87, 26);
		contentPane.add(labelNome);
		
		//label pro campo da senha
		JLabel labelNovaSenha = new JLabel("Nova Senha:");
		labelNovaSenha.setBounds(467, 419, 105, 26);
		contentPane.add(labelNovaSenha);
		
		/*botão pra confirmar o novo login e senha, se ambos os valores estiverem corretos, os valores substituem os devidos 
		 * atributos na tabela do mysql e nos atributos da classe, se ambos valores forem iguais aos valores anteriores o 
		 * metodo retorna false e abre a janela das plantas novamente*/
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(617, 470, 142, 42);
		botaoConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planta1Mod plantas = null;
				try {
					plantas = new Planta1Mod();
				} catch (ClassNotFoundException | SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				Moderador mod = null;
				try {
					mod = new Moderador();
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(mod.mudarNomeESenha(txNovoNome.getText(), String.valueOf(pfSenha.getPassword()))==true) {
					JOptionPane.showMessageDialog(null, "Novo nome: " +mod.getNome() + "\nNova senha: "+ mod.getSenha());
					ModeradorDAO mDao = new ModeradorDAO();
					try {
						mDao.alterarNomeESenha(mod);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					plantas.setVisible(true);
					setVisible(false);
				}
				else if((mod.mudarNomeESenha(txNovoNome.getText(), String.valueOf(pfSenha.getPassword())))==false) {
					JOptionPane.showMessageDialog(null, "Invalido");
					plantas.setVisible(true);
					setVisible(false);
					}}});
		contentPane.add(botaoConfirmar);
		}}