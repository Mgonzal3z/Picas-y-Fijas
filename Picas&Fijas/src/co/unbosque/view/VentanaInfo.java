package co.unbosque.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaInfo extends JFrame{
	
	/**
	 * Imagen de fondo de la ventana principal
	 */
	private ImageIcon ImagenBienvenida;
	/**
	 * Jlabel que contiene la imagen de fondo
	 */
	private JLabel bienvenida;
	/**
	 * Boton para regresar a la ventana principal
	 */
	private JButton btAtras;
	/**
	 * Entero que contiene el ancho de la pantalla del usuario
	 */
	private int ancho;
	/**
	 * Entero que contiene el alto de la pantalla del usuario
	 */
	private int alto;
	
	/**
	 * Metodo inicializador de la ventana de como se juega
	 * Define todos sus componentes y ubicaciones
	 */
public VentanaInfo(){
		
		ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setIconImage(new ImageIcon(getClass().getResource("/data/logo.png")).getImage());
		setTitle("Como se juega");
		setLayout(null);
		setSize(600, 400);
		setLocation((int)((ancho/2)-433),(int)((alto/2)-220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btAtras = new JButton("Atras");
		btAtras.setActionCommand("VOLVER");
		btAtras.setVisible(true);
		btAtras.setBounds(180, 300, 200, 30);
		add(btAtras);
		
		Dimension tam = getSize();
		ImagenBienvenida = new ImageIcon(getClass().getResource("/data/fondo.jpeg"));
		bienvenida = new JLabel(ImagenBienvenida);
		bienvenida.setBounds(0, 0,tam.width, tam.height);

		add(bienvenida);
		
		setResizable(false);
		
	}

/**
 * Getter del boton de atras, se usa para agregarle su respectivo ActionListener
 * @return El objeto del boton de atras
 */
public JButton getBtAtras() {
	return btAtras;
}

/**
 * Setter del boton de atras
 */
public void setBtAtras(JButton btAtras) {
	this.btAtras = btAtras;
}

}
