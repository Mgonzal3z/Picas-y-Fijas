package co.unbosque.view;

import java.awt.Dimension;
import java.awt.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaEntrena extends JFrame{

	/**
	 * Imagen de fondo de la ventana principal
	 */
	private ImageIcon ImagenBienvenida;
	/**
	 * Jlabel que contiene la imagen de fondo
	 */
	private JLabel bienvenida;
	/**
	 * Lista donde se visualiza la informacion
	 */
	private List mensajes;
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
	 * Metodo inicializador de la ventana de entrenamiento
	 * Define todos sus componentes y ubicaciones
	 */
	public VentanaEntrena(){

		ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setIconImage(new ImageIcon(getClass().getResource("/data/logo.png")).getImage());
		setTitle("Entrenamiento");
		setLayout(null);
		setSize(600, 450);
		setLocation((int)((ancho/2)-433),(int)((alto/2)-220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);

		mensajes= new List();
		mensajes.setBounds(10, 10,260,390);
		add(mensajes);
		
		btAtras = new JButton("Atras");
		btAtras.setActionCommand("ATRASE");
		btAtras.setVisible(true);
		btAtras.setBounds(335, 290, 200, 30);
		add(btAtras);
		
		Dimension tam = getSize();
		ImagenBienvenida = new ImageIcon(getClass().getResource("/data/entrena.jpeg"));
		bienvenida = new JLabel(ImagenBienvenida);
		bienvenida.setBounds(0, 0,tam.width, tam.height);
		add(bienvenida);

	}
	
	/**
	 * Getter del List de informacion, 
	 * se usa para agregarle su respectivo ActionListener
	 * @return El objeto del List de informacion
	 */
	public List getMensajes() {
		return mensajes;
	}

	/**
	 * Setter del List de mensajes
	 */
	public void setMensajes(List mensajes) {
		this.mensajes = mensajes;
	}
	
	
	/**
	 * Metodo que añade la informacion al List de mensajes
	 */
	public void escribirMensaje(String m){
		this.mensajes.add(m, 0);
	}

	/**
	 * Metodo que lee con un JOptionPane la informcion digitada por el usuario<br>
	 * <b>Pre:</b> <br>
	 * Informacion a mostrar al usuario <br>
	 * <b>Post:</b> <br>
	 * El texto ingresado por el usuario 
	 * 
	 * @param mensaje Informacion que se muestra en el JOption para pedir al usuario que ingrese un valor
	 * @return El numero ingresado en forma de String
	 */
	public String leerDato(String mensaje) {
		String rta = "";
		try{
		JOptionPane jp=new JOptionPane();
		rta = jp.showInputDialog(null,mensaje,"Ingreso de dato",JOptionPane.QUESTION_MESSAGE);
		
		}catch(NullPointerException e){
			System.out.println("Operacion Cancelada");
			
		}
		return rta;
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
	public void setBtAtras(JButton btconf) {
		this.btAtras = btconf;
	}

}
