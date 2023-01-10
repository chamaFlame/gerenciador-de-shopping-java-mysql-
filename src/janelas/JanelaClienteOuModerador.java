//janela inicial pra escolher pra logar como moderador ou cliente
package janelas;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
public class JanelaClienteOuModerador extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaClienteOuModerador frame = new JanelaClienteOuModerador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();}}});}
	
	//elementos da janela
	public JanelaClienteOuModerador() {
		//dados da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			System.out.println("Janela fechou!");
				}
		});
		
		//logo do shopping
		JLabel Logo = new JLabel("local da imagem");
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setBounds(521, 95, 349, 226);
		contentPane.add(Logo);
		//objeto da imagem da logo
		ImageIcon imgLogo = new ImageIcon("C:\\Users\\paulorenam\\Downloads\\eclipse\\meus programas\\ProjetoShopping\\logo.jpg");
		Logo.setIcon(imgLogo);
		
		//botao de login do cliente,
		JButton botaoCliente = new JButton("Cliente");
		botaoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPlanta1 plantas = null;
				try {
					plantas = new JanelaPlanta1();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				plantas.setVisible(true);
				setVisible(false);
				}});
		botaoCliente.setBounds(633, 364, 127, 39);
		contentPane.add(botaoCliente);
		
		//botao de login do moderador
		JButton botaoModerador = new JButton("Moderador");
		botaoModerador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaLoginModerador login = null;
				try {
					login = new JanelaLoginModerador();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				login.setVisible(true);
				setVisible(false);}});
		botaoModerador.setBounds(633, 432, 127, 39);
		contentPane.add(botaoModerador);}}