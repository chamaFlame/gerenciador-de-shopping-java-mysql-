package classesDeNegocio;
import java.sql.SQLException;
import janelas.JanelaClienteOuModerador;
public class Main {
	//inicio do programa, tornar a tela inicial visivel
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JanelaClienteOuModerador janela = new JanelaClienteOuModerador();
		janela.setVisible(true);
		
	}}
/* a fazer: imagem das plantas num programa de edição de imagem, segundo andar, planta 2 e 3 DAOs pras classes restantes, 
 * classe dos produtos e dos funcionarios e janela dos produtos das lojas*/