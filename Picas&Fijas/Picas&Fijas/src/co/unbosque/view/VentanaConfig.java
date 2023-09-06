package co.unbosque.view;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaConfig extends JFrame{

	/**
	 * Imagen de fondo de la ventana principal
	 */
	private ImageIcon ImagenBienvenida;
	/**
	 * Jlabel que contiene la imagen de fondo
	 */
	private JLabel bienvenida;
	/**
	 * Boton para guardar las configuraciones
	 */
	private JButton btGuardar;
	/**
	 * JComboBox con las opciones para definir el numero de digitos para el juego
	 */
	private JComboBox<Integer> campo;
	/**
	 * JRadioBoton con la opcion de habilitar numeros repetidos
	 */
	private JRadioButton r1;
	/**
	 * JRadioBoton con la opcion de deshabilitar numeros repetidos
	 */
	private JRadioButton r2;
	/**
	 * ButtonGroup con las opcines para habilitar o deshabilitar numeros repetidos 
	 */
	private ButtonGroup bg;

	/**
	 * Metodo inicializador de la ventana de configuraciones
	 * Define todos sus componentes y ubicaciones
	 */
	public VentanaConfig(){
		
		
		setIconImage(new ImageIcon(getClass().getResource("/data/logo.png")).getImage());
		setTitle("Configuracion");
		setLayout(null);
		setSize(600, 400);
		setLocation(250,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Integer[] opciones=new Integer[]{1,2,3,4,5,6,7,8,9,10};
		campo=new JComboBox<>(opciones);
		campo.setBounds(50, 60, 200, 30);
		add(campo);

		
		btGuardar = new JButton("Guardar");
		btGuardar.setActionCommand("GUARDAR");
		btGuardar.setVisible(true);
		btGuardar.setBounds(180, 300, 200, 30);
		add(btGuardar);
		
		r1= new JRadioButton("Habilitar");
		r1.setActionCommand("Habilitar");
		r1.setBounds(50, 140, 100, 30);
		
		
		r2= new JRadioButton("Deshabilitar");
		r2.setActionCommand("Deshabilitar");
		r2.setBounds(160, 140, 100, 30);
		
		bg=new ButtonGroup();
		
		bg.add(r1);
		bg.add(r2);
		
		add(r1);
		add(r2);

		
		Dimension tam = getSize();
		ImagenBienvenida = new ImageIcon(getClass().getResource("/data/conf.jpeg"));
		bienvenida = new JLabel(ImagenBienvenida);
		bienvenida.setBounds(0, 0,tam.width, tam.height);

		add(bienvenida);
		
		setResizable(false);
		
	}

	/**
	 * Getter del RadioButton de habilitar repeticiones, 
	 * se usa para agregarle su respectivo ActionListener
	 * @return El objeto del RadioButton de habilitar
	 */
	public JRadioButton getR1() {
		return r1;
	}

	/**
	 * Setter del RadioButton de habilitar repeticiones
	 */
	public void setR1(JRadioButton r1) {
		this.r1 = r1;
	}

	/**
	 * Getter del RadioButton de deshabilitar repeticiones, 
	 * se usa para agregarle su respectivo ActionListener
	 * @return El objeto del RadioButton de deshabilitar
	 */
	public JRadioButton getR2() {
		return r2;
	}

	/**
	 * Setter del RadioButton de deshabilitar repeticiones
	 */
	public void setR2(JRadioButton r2) {
		this.r2 = r2;
	}

	/**
	 * Getter del ComboBox con las opciones del numero de digitos, 
	 * se usa para agregarle su respectivo ActionListener
	 * @return El objeto del ComboBox seleccionado
	 */
	public JComboBox<Integer> getCampo() {
		return campo;
	}

	/**
	 * Setter del ComboBox 
	 */
	public void setCampo(JComboBox<Integer> campo) {
		this.campo = campo;
	}

	/**
	 * Metodo para mostrar una configuracion incorrecta con un JOption
	 */
	public void mostrarError(){
		JOptionPane.showMessageDialog(null, "Configuración Incorrecta");
	}


	/**
	 * Getter del boton de guardar, 
	 * se usa para agregarle su respectivo ActionListener
	 * @return El objeto del boton de guardar la informacion
	 */
	public JButton getBtGuardar() {
		return btGuardar;
	}

	/**
	 * Setter del boton de guardar
	 */
	public void setBtGuardar(JButton btGuardar) {
		this.btGuardar = btGuardar;
	}
	
	


	
	
}
