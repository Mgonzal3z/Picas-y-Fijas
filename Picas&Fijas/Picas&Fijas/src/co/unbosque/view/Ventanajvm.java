package co.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ventanajvm extends JFrame{

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
	 * Boton para accionar la revancha del juego
	 */
	private JButton btJugarDeNuevo;
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
	 * Lista donde se visualiza la puntuacion del jugador 1
	 */
	private List puntajeJ1;
	/**
	 * Lista donde se visualiza la puntuacion del jugador 2
	 */
	private List puntajeJ2;
	/**
	 * Boton para las reanudar el juego
	 */
	private JButton btContinuar;
	/**
	 * Boton para pedir una ayuda sobre la informacion de la maquina
	 */
	private JButton btAyuda;

	/**
	 * Metodo inicializador de la ventana jugador vs maquina
	 * Define todos sus componentes y ubicaciones
	 */

	public Ventanajvm(){

		ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setIconImage(new ImageIcon(getClass().getResource("/data/logo.png")).getImage());
		setTitle("Jugador Vs Maquina");
		setLayout(null);
		setSize(600, 500);
		setLocation((int)((ancho/2)-433),(int)((alto/2)-220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);

		mensajes= new List();
		mensajes.setBounds(10, 10,260,440);
		add(mensajes);

		puntajeJ1= new List(); 
		puntajeJ1.setBounds(405, 410, 60, 30);
		add(puntajeJ1);
	
		puntajeJ2= new List(); 
		puntajeJ2.setBounds(475, 410, 60, 30);
		add(puntajeJ2);
		
		btAyuda = new JButton("Pista");
		btAyuda.setActionCommand("AYUDA");
		btAyuda.setVisible(true);
		btAyuda.setBounds(335, 290, 200, 30);
		add(btAyuda);
		
		btJugarDeNuevo = new JButton("Revancha");
		btJugarDeNuevo.setActionCommand("REVANCHA2");
		btJugarDeNuevo.setVisible(true);
		btJugarDeNuevo.setBounds(335, 240, 200, 30);
		add(btJugarDeNuevo);
		
		btAtras = new JButton("Atras");
		btAtras.setActionCommand("ATRAS2");
		btAtras.setVisible(true);
		btAtras.setBounds(335, 340, 200, 30);
		add(btAtras);
		
		btContinuar = new JButton("Reanudar");
		btContinuar.setActionCommand("REANUDAR");
		btContinuar.setVisible(true);
		btContinuar.setBounds(335, 190, 200, 30);
		add(btContinuar);

		Dimension tam = getSize();
		ImagenBienvenida = new ImageIcon(getClass().getResource("/data/jvm.jpeg"));
		bienvenida = new JLabel(ImagenBienvenida);
		bienvenida.setBounds(0, 0,tam.width, tam.height);
		add(bienvenida);

	}

	/**
	 * Getter del boton de ayuna, se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de ayuda
	 */
	public JButton getBtAyuda() {
		return btAyuda;
	}

	/**
	 * Setter del boton de ayuda
	 */
	public void setBtAyuda(JButton btAyuda) {
		this.btAyuda = btAyuda;
	}

	/**
	 * Getter del boton de continuar, se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de continuar
	 */
	public JButton getBtContinuar() {
		return btContinuar;
	}

	/**
	 * Setter del boton de continuar
	 */
	public void setBtContinuar(JButton btContinuar) {
		this.btContinuar = btContinuar;
	}
	
	
	/**
	 * Getter del List de puntaje para el jugador 1, 
	 * se usa para agregarle su respectivo ActionListener
	 * @return El objeto del List de puntaje para el jugador 1
	 */
	public List getPuntajeJ1() {
		return puntajeJ1;
	}

	/**
	 * Setter del List de puntaje para el jugador 1
	 */
	public void setPuntajeJ1(String puntajeJ1) {
		this.puntajeJ1.add(puntajeJ1);
	}

	/**
	 * Getter del List de puntaje para el jugador 2, 
	 * se usa para agregarle su respectivo ActionListener
	 * @return El objeto del List de puntaje para el jugador 2
	 */
	public List getPuntajeJ2() {
		return puntajeJ2;
	}

	/**
	 * Setter del List de puntaje para el jugador 2
	 */
	public void setPuntajeJ2(String puntajeJ2) {
		this.puntajeJ2.add(puntajeJ2);
	}

	/**
	 * Getter del boton de revancha, se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de revancha
	 */
	public JButton getBtJugarDeNuevo() {
		return btJugarDeNuevo;
	}

	/**
	 * Setter del boton de revancha
	 */
	public void setBtJugarDeNuevo(JButton btJugarDeNuevo) {
		this.btJugarDeNuevo = btJugarDeNuevo;
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
		JOptionPane jp=new JOptionPane();
		rta = jp.showInputDialog(null,mensaje,"Ingreso de dato",JOptionPane.QUESTION_MESSAGE);
		
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
	
	/**
	 * Metodo para mostrar la informacion de la pista<br>
	 * @param mPista El mensaje que se desea mostrar en el JOption
	 */
	public void mostrarPista(String mPista){
		JOptionPane.showMessageDialog(null, mPista,"Pista:",JOptionPane.INFORMATION_MESSAGE);		
	}

}

