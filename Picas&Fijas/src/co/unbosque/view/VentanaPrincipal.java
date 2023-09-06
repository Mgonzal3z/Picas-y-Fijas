package co.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public class VentanaPrincipal extends JFrame{
	
	/**
	 * Imagen de fondo de la ventana principal
	 */
	private ImageIcon ImagenBienvenida;
	/**
	 * Jlabel que contiene la imagen de fondo
	 */
	private JLabel bienvenida;
	/**
	 * Boton para el entrenamiento del juego
	 */
	private JButton btentrena;
	/**
	 * Boton para el modo de jugador vs jugador
	 */
	private JButton btjvj;//MODO DE JUEGO 1 JUGADOR VS 1 JUGADOR
	/**
	 * Boton para el modo de jugador vs maquina
	 */
	private JButton btjvm;
	/**
	 * Boton para las configuraciones del juego
	 */
	private JButton btconf;
	/**
	 * Boton para explicar como se juega
	 */
	private JButton btInfo;
	/**
	 * Entero que contiene el ancho de la pantalla del usuario
	 */
	private int ancho;
	/**
	 * Entero que contiene el alto de la pantalla del usuario
	 */
	private int alto;
	
	
	/**
	 * Metodo inicializador de la ventana principal. 
	 * Define todos sus componentes y ubicaciones
	 */

	public VentanaPrincipal(){
		
		ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setIconImage(new ImageIcon(getClass().getResource("/data/logo.png")).getImage());
		setTitle("Bienvenidos a Picas y Fijas");
		setLayout(null);
		setSize(600, 350);
		setLocation((int)((ancho/2)-433),(int)((alto/2)-220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBotones();
		
		Dimension tam = getSize();
		ImagenBienvenida = new ImageIcon(getClass().getResource("/data/fondoP.jpeg"));
		bienvenida = new JLabel(ImagenBienvenida);
		bienvenida.setBounds(0, 0,tam.width, tam.height);

		add(bienvenida);
		
		setResizable(false);
		setVisible(true);
		
	}
	
	/**
	 * Metodo donde se definen los componentes y ubicaciones
	 * de los botones
	 */
	public void menuBotones(){
		
		btentrena = new JButton("Entrenar");
		btentrena.setActionCommand("ENTRENAR");
		btentrena.setVisible(true);
		btentrena.setBounds(180, 130, 200, 30);
		add(btentrena);
		
		btjvj = new JButton("Jugador Vs Jugador");
		btjvj.setActionCommand("1v1");
		btjvj.setVisible(true);
		btjvj.setBounds(180, 170, 200, 30);
		add(btjvj);
		
		btjvm = new JButton("Jugador Vs Maquina");
		btjvm.setActionCommand("1vm");
		btjvm.setVisible(true);
		btjvm.setBounds(180, 210, 200, 30);
		add(btjvm);
		
		btconf = new JButton("Configuraciones");
		btconf.setActionCommand("CONFIGURAR");
		btconf.setBounds(440, 270, 130, 30);
		add(btconf);
		
		btInfo = new JButton("Cómo Jugar?");
		btInfo.setActionCommand("INFO");
		btInfo.setBounds(10, 270, 120, 30);
		add(btInfo);
		
	}
	

	/**
	 * Getter del boton de como se juega, se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de informacion
	 */
	public JButton getBtInfo() {
		return btInfo;
	}


	/**
	 * Setter del boton de como se juega
	 */
	public void setBtInfo(JButton btInfo) {
		this.btInfo = btInfo;
	}


	/**
	 * Getter del boton de entrenamiento, se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de entrenamiento
	 */
	public JButton getBtentrena() {
		return btentrena;
	}


	/**
	 * Setter del boton de entrenamiento
	 */
	public void setBtentrena(JButton btentrena) {
		this.btentrena = btentrena;
	}


	/**
	 * Getter del boton de jugador vs jugador, se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de jugador vs jugador
	 */
	public JButton getBtjvj() {
		return btjvj;
	}


	/**
	 * Setter del boton de jugador vs jugador
	 */
	public void setBtjvj(JButton btjvj) {
		this.btjvj = btjvj;
	}

	/**
	 * Getter del boton de jugador vs maquina, se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de jugador vs maquina
	 */
	public JButton getBtjvm() {
		return btjvm;
	}

	/**
	 * Setter del boton de jugador vs maquina
	 */
	public void setBtjvm(JButton btjvm) {
		this.btjvm = btjvm;
	}

	/**
	 * Getter del boton de configuracion, se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de configuracion
	 */
	public JButton getBtconf() {
		return btconf;
	}

	/**
	 * Setter del boton de configuraciones
	 */
	public void setBtconf(JButton btconf) {
		this.btconf = btconf;
	}

}
