package janelas;
//imports
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import classesDeNegocio.Moderador;
import janelasVersaoMod.Planta1Mod;

//metodo principal
public class JanelaLoginModerador extends JFrame {
	//id
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField escreverNome;
	private JPasswordField escreverSenha;
	
	//metodo principal
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLoginModerador frame = new JanelaLoginModerador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();}}});}
	
	//elementos da janela
	public JanelaLoginModerador() throws ClassNotFoundException, SQLException {
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
		ImageIcon imgLogo = new ImageIcon("C:\\Users\\paulorenam\\Downloads\\eclipse\\meus programas\\ProjetoShopping\\logo.jpg");
		Logo.setIcon(imgLogo);
		
		//campo pra digitar o nome
		escreverNome = new JTextField();
		escreverNome.setBounds(581, 365, 216, 29);
		contentPane.add(escreverNome);
		escreverNome.setColumns(10);
		
		//campo pra digitar a senha
		escreverSenha = new JPasswordField();
		escreverSenha.setBounds(581, 423, 216, 29);
		contentPane.add(escreverSenha);
		
		//texto que indica o local do nome
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(507, 365, 64, 29);
		contentPane.add(labelNome);
		
		//texto que indica o local da senha
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(507, 423, 64, 29);
		contentPane.add(labelSenha);
		
		/*botão pra confirmar o login, se o metodo do login retornar true, as janelas da versão de moderador serão abertas 
		 * começando pela janela da planta 1 e fecha a janela do login, se o método retornar false, abrirá a janela inicial
		 * novamente e fechará a janela de login */
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.addActionListener(new ActionListener() {
			Moderador mod = new Moderador();
			public void actionPerformed(ActionEvent e){
				if(mod.checarLogin(escreverNome.getText(), String.valueOf(escreverSenha.getPassword())) == true) {
					escreverNome.setVisible(false);
					escreverSenha.setVisible(false);
					labelNome.setVisible(false);
					labelSenha.setVisible(false);
					botaoConfirmar.setVisible(false);
					JLabel labelBemVindo = new JLabel("Seja bem vindo " + mod.getNome()+"!");
					labelBemVindo.setBounds(630, 380, (mod.getNome().length())*67, 24);
					contentPane.add(labelBemVindo);
					JButton botaoContinuar = new JButton("Continuar");
					botaoContinuar.setBounds(617, 463, 142, 53);
					contentPane.add(botaoContinuar);
					botaoContinuar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Planta1Mod plantas = null;
							try {
								plantas = new Planta1Mod();
							} catch (ClassNotFoundException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							plantas.setVisible(true);
							setVisible(false);
						}});
					}
				else if(mod.checarLogin(escreverNome.getText(), String.valueOf(escreverSenha.getPassword())) == false){
					JOptionPane.showMessageDialog(null, "nome ou senha incorretos!");
					JanelaClienteOuModerador anterior = new JanelaClienteOuModerador();
					anterior.setVisible(true);
					setVisible(false);
				}
			}
		});
		botaoConfirmar.setBounds(617, 463, 142, 53);
		contentPane.add(botaoConfirmar);
	}}