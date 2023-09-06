package co.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.util.ArrayList;

import co.unbosque.mundo.Jvj;
import co.unbosque.view.Ventana1v1;
import co.unbosque.view.VentanaConfig;
import co.unbosque.view.VentanaEntrena;
import co.unbosque.view.VentanaInfo;
import co.unbosque.view.VentanaPrincipal;
import co.unbosque.view.Ventanajvm;
/**
 * Clase que maneja el ciclo de ejecucion de la aplicacion
 */
public class Controller implements ActionListener{

	/**
	 * Objeto de la ventana principal
	 */
	private VentanaPrincipal vp;
	/**
	 * Objeto de la ventana del jugador vs jugador
	 */
	private Ventana1v1 v1v1;
	/**
	 * Objeto de la clase del mundo
	 */
	private Jvj m1;
	/**
	 * Objeto de la ventana de configuracion del juego
	 */
	private VentanaConfig vc;
	/**
	 * Objeto de la ventana que da la informacion de como se juega
	 */
	private VentanaInfo vi;
	/**
	 * Objeto de la ventana para realizar el entrenamiento
	 */
	private VentanaEntrena ve;
	/**
	 * Entero que maneja la cantidad de digitos ingresados por configuracion
	 */
	private int digitosJuego;//Maneja la cantidad de digitos del juego
	/**
	 * Objeto de la ventana de jugador vs maquina
	 */
	private Ventanajvm vjvm;
	/**
	 * Booleano que maneja si se aceptan o no numeros repetidos
	 */
	private boolean repetidos;//Le dice al programa si permite o no repetir digitos

	
	/**
	 * Metodo que crea un objeto de la clase controlador <br>
	 * <b>Pre:</b> <br>
	 * Las librerias estan correctamente incluidas en el proyecto <br>
	 * <b>Post:</b> <br>
	 * Se inicializaron las ventanas y se muestra la inicial.
	 */
	public Controller(){

		m1=new Jvj();
		vp= new VentanaPrincipal();
		//IMPLEMENTA LOS ACTIONLISTENER DE LOS BOTONES DE LA VENTANA PRINCIPAL
		vp.getBtjvj().addActionListener(this);//Boton jugador vs jugador
		vp.getBtentrena().addActionListener(this);//Boton entrenamiento
		vp.getBtjvm().addActionListener(this);//Boton jugador vs maquina
		vp.getBtconf().addActionListener(this);//Boton configuraciones
		vp.getBtInfo().addActionListener(this);//Boton como se juega

		v1v1= new Ventana1v1();
		v1v1.getBtAtras().addActionListener(this);//Boton atras
		v1v1.getBtJugarDeNuevo().addActionListener(this);//Boton revancha
		v1v1.getBtContinuar().addActionListener(this);//Boton reanudar


		vc=new VentanaConfig();
		vc.getBtGuardar().addActionListener(this);//Boton Guardar
		digitosJuego = 1;

		vjvm= new Ventanajvm();
		vjvm.getBtJugarDeNuevo().addActionListener(this);//boton revancha 2
		vjvm.getBtAtras().addActionListener(this);//boton atras 2
		vjvm.getBtContinuar().addActionListener(this);//Boton continuar
		vjvm.getBtAyuda().addActionListener(this);//Boton ayuda

		vi= new VentanaInfo();
		vi.getBtAtras().addActionListener(this);//Boton atras
		
		ve=new VentanaEntrena();
		ve.getBtAtras().addActionListener(this);//Boton atras

	}

	/**
	 * Metodo que lee los numeros que ingresa el usuario <br>
	 * <b>Pre:</b> <br>
	 * El mensaje que se muestra al usuario para pedir la informacion <br>
	 * <b>Post:</b> <br>
	 * Se leyo correctamente el numero
	 * 
	 * @param info Texto que lee el usuario en un JOption
	 * @return El numero leido en forma de String
	 */

	public String leerMensaje(String info){
		
		String rta="";
		rta=v1v1.leerDato(info);
		if (repetidos == false){
			if  (rta.length()==digitosJuego){
				if(m1.validar(m1.llenarArreglo(rta))=="invalido") {
					
					rta=leerMensaje(info); // 1 return
				}
			}else{
				rta=leerMensaje(info); // 2 return
			}
		}else if (repetidos == true){
			if  (rta.length()==digitosJuego){
				if(m1.validarR(m1.llenarArreglo(rta))=="invalido") {
					
					rta=leerMensaje(info); // 3 return
				}
			}else{
				rta=leerMensaje(info);  // 4 return
			}
		}
		return rta;
	}

	/**
	 * Metodo que lee los numeros que ingresa el usuario en el entrenamiento<br>
	 * <b>Pre:</b> <br>
	 * El mensaje que se muestra al usuario para pedir la informacion <br>
	 * <b>Post:</b> <br>
	 * Se leyo correctamente el numero
	 * 
	 * @param info Texto que lee el usuario en un JOption
	 * @return El numero leido en forma de String
	 */
	public String leerMensajeEntrenamiento(String info){
		String rta="";
		rta=ve.leerDato(info);
		if(repetidos==false){
		if  (rta.length()==4){
			if(m1.validar(m1.llenarArreglo(rta))=="invalido") {
				rta=leerMensajeEntrenamiento(info);
			}
		}else{
			rta=leerMensajeEntrenamiento(info);
		}
		}else{
			if(m1.validarR(m1.llenarArreglo(rta))=="invalido") {
				rta=leerMensajeEntrenamiento(info);
			}
		}

		return rta;
	}

	/**
	 * Metodo que prepara el entorno del jugador vs jugador, se ingresan 
	 * los numeros con los que va a jugar cada uno<br>
	 * @return 1 si se leyo la informacion 0 sino
	 */
	public int prepararJuego1v1(){
		int cont=0;
		try{
			m1.setNumeros1(new ArrayList<>());
			m1.setNumeros2(new ArrayList<>());
			String n1=leerMensaje("Jugador 1: ELIGE TU NÚMERO de "+digitosJuego+" digitos: ");
			m1.setNumeros1(m1.llenarArreglo(n1));			
			v1v1.escribirMensaje("Jugador 1 Preparado ");
			String n2=leerMensaje("Jugador 2: ELIGE TU NÚMERO de "+digitosJuego+" digitos: ");
			m1.setNumeros2(m1.llenarArreglo(n2));
			v1v1.escribirMensaje("Jugador 2 Preparado ");
			cont=1;
		}catch(NullPointerException e)
		{

		}
		return cont;
	}
	
	
	/**
	 * Metodo que ejecuta el juego del jugador vs jugador
	 * se conecta con el mundo y realiza las validaciones 
	 * de las picas y fijas <br>
	 * <b>Pre:</b> <br>
	 * La preparacion del entorno con el metodo de prepararJuego1v1 <br>
	 * <b>Post:</b> <br>
	 * Finaliza el juego porque un jugador adivino

	 */
	public void juego1v1(){
		try{
			String exito="";
			ArrayList auxIntento=new ArrayList();
			while (exito!="ADIVINASTE"){
				v1v1.escribirMensaje("+++++++++++++++++++++++++++++");
				String nIntento=leerMensaje("TURNO J1: Ingresa un número de "+digitosJuego+" digitos: ");
				v1v1.escribirMensaje("TURNO J1: "+ nIntento);
				auxIntento=m1.llenarArreglo(nIntento);
				exito=m1.validarFija(m1.getNumeros2(), auxIntento);
				v1v1.escribirMensaje("J1: "+exito);
				if(exito!="ADIVINASTE"){
					//TURNO JUGADOR 2
					exito="";
					v1v1.escribirMensaje("--------------------------------------");
					String nIntento2=leerMensaje("TURNO J2: Ingresa un número de "+digitosJuego+" digitos: ");
					v1v1.escribirMensaje("TURNO J2: "+ nIntento2);
					auxIntento=m1.llenarArreglo(nIntento2);
					exito=m1.validarFija(m1.getNumeros1(), auxIntento);
					v1v1.escribirMensaje("J2: "+exito);
					if(exito=="ADIVINASTE"){
						m1.setPuntajeJ2(Integer.parseInt(m1.getPuntajeJ2())+1);
					}
				}else{
					m1.setPuntajeJ1(Integer.parseInt(m1.getPuntajeJ1())+1);
				}
			}
			v1v1.getBtContinuar().setVisible(false);
		}catch(NullPointerException e){

		}
	}

	/**
	 * Metodo que entrena al usuario para que aprenda a jugar,
	 * siempre tiene el mismo numero<br>
	 */
	public void entrenamiento(){
		try{
			String nEntrena = "1234";
			//Le dice al mundo quíen es su arreglo numero 1
			m1.setNumeros1(m1.llenarArreglo(nEntrena));
			m1.setNumeros1(m1.llenarArreglo(nEntrena));
			ve.escribirMensaje("BIENVENIDO AL ENTRENAMIENTO: ");
			ve.escribirMensaje("*********************************************");
			ve.escribirMensaje("PRACTIQUEMOS: ");
			ve.escribirMensaje("Intenta adivinar mi número de 4 cifras ");
			String rta="";
			while(rta!="ADIVINASTE"){
				String nUsuario=leerMensajeEntrenamiento("Digita número de 4 cifras: ");
				if(nUsuario.length()==4){
					ve.escribirMensaje("Tu intento: "+nUsuario);
					m1.setNumeros2(m1.llenarArreglo(nUsuario));
					rta=m1.validarEntrenamiento(m1.getNumeros1(), m1.getNumeros2());
					ve.escribirMensaje(rta);
				}
			}
			ve.escribirMensaje("*********************************************");
			ve.escribirMensaje("  FELICIDADES- ENHORABUENA TIO");
			ve.escribirMensaje("HAS CONCLUIDO EL ENTRENAMIENTO");
			ve.escribirMensaje("*********************************************");
			
		}catch(NullPointerException e){

		}
	}


	/**
	 * Metodo que se conecta con el mundo para validar los datos ingresados por el 
	 * usuario<br>
	 * <b>Pre:</b> <br>
	 * Metodo de validarRepetidos en el mundo <br>
	 * <b>Post:</b> <br>
	 * El numero ingresado por el usuario validado
	 * 
	 * @param cantNumeros Cantidad de numeros con los que se esta jugando
	 * @return El numero validado en forma de String
	 */
	public String validarRepetidos(int cantNumeros){
		String n2=m1.aleatorio(cantNumeros);
		int cont=0;
		cont=m1.validarRepetidos(m1.llenarArreglo(n2));

		if(cont>0){
			n2= validarRepetidos(cantNumeros);
		}
		return n2;
	}


	/**
	 * Metodo que prepara el entorno del jugador vs maquina, se ingresa
	 * el numero con los que va a jugar<br>
	 * @return 1 si se leyo la informacion 0 sino
	 */
	public int prepararJuego1vm(){
		int cont=0;
		try{
			String n1=leerMensaje("Jugador: ELIGE TU NÚMERO "+digitosJuego+" cifras: ");
			m1.setNumeros1(m1.llenarArreglo(n1));
			vjvm.escribirMensaje("Jugador Preparado ");
			vjvm.escribirMensaje("------------------------");
			String n2=validarRepetidos(digitosJuego);
			m1.setNumeros2(m1.llenarArreglo(n2));
			vjvm.escribirMensaje("Estoy Preparada ");
			vjvm.escribirMensaje("------------------------");
			cont=1;
		}catch(NullPointerException e)
		{

		}
		return cont;
	}

	
	/**
	 * Metodo que ejecuta el juego del jugador vs maquina
	 * se conecta con el mundo y realiza las validaciones 
	 * de las picas y fijas <br>
	 * <b>Pre:</b> <br>
	 * La preparacion del entorno con el metodo de prepararJuego1vm <br>
	 * <b>Post:</b> <br>
	 * Finaliza el juego porque un jugador adivino

	 */
	public void juego1vm(){
		try{
			String exito="";
			ArrayList auxIntento=new ArrayList();
			while (exito!="ADIVINASTE"){
				String nIntento=leerMensaje("TU TURNO: Ingresa un número de "+digitosJuego+" cifras: ");
				vjvm.escribirMensaje("JUGADOR: "+ nIntento);
				auxIntento=m1.llenarArreglo(nIntento);
				exito=m1.validarFija(m1.getNumeros2(), auxIntento);
				vjvm.escribirMensaje("J1: "+exito);
				if(exito!="ADIVINASTE"){
					//TURNO MAQUINA
					exito="";
					vjvm.escribirMensaje("---------------- ");
					String nIntento2=validarRepetidos(digitosJuego);
					vjvm.escribirMensaje("MAQUINA: "+ nIntento2);
					auxIntento=m1.llenarArreglo(nIntento2);
					exito=m1.validarFija(m1.getNumeros1(), auxIntento);
					vjvm.escribirMensaje("M: "+exito);	
					if(exito=="ADIVINASTE"){
						m1.setPuntajeJ2(Integer.parseInt(m1.getPuntajeJ2())+1);
					}
				}else{
					m1.setPuntajeJ1(Integer.parseInt(m1.getPuntajeJ1())+1);
				}

			}
			vjvm.getBtContinuar().setVisible(false);

		}catch(NullPointerException e){

		}
	}


	/**
	 * Contiene la logica de los eventos que vienen de la vista <br>
	 * <b>Pre:</b> <br>
	 * El usuario ejecuto una evento y espera una respuesta <br>
	 * <b>Post:</b> <br>
	 * Se ejecuta la accion correspondiente al evento lanzado por el usuario
	 * 
	 * @param e Evento que ejecuta el usuario
	 */
	int contjvm=0;
	int contjvj=0;
	int nPista=0;
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("1v1")) {
			v1v1.getMensajes().clear();
			vp.setVisible(false);
			v1v1.setVisible(true);
			contjvj=prepararJuego1v1();
			if (contjvj>0){
				juego1v1();
			}
			v1v1.getPuntajeJ1().clear();
			v1v1.getPuntajeJ2().clear();
			v1v1.setPuntajeJ1("        "+m1.getPuntajeJ1());
			v1v1.setPuntajeJ2("        "+m1.getPuntajeJ2());
		}
		else if (e.getActionCommand().equals("ENTRENAR")) {
			ve.getMensajes().clear();
			vp.setVisible(false);
			ve.setVisible(true);  
			entrenamiento();
		}else if (e.getActionCommand().equals("ATRAS")) {
			v1v1.setVisible(false);
			vjvm.setVisible(false);
			vp.setVisible(true);
			v1v1.getPuntajeJ1().clear();
			v1v1.getPuntajeJ2().clear();
			m1.setPuntajeJ1(0);
			m1.setPuntajeJ2(0);
		}else if (e.getActionCommand().equals("ATRASE")) {
			ve.setVisible(false);
			vp.setVisible(true);
			}else if (e.getActionCommand().equals("1vm")) {
			nPista=0;
			vjvm.getMensajes().clear();
			vp.setVisible(false);
			vjvm.setVisible(true);
			contjvm=prepararJuego1vm();
			if (contjvm>0){
				juego1vm();
			}
			vjvm.getPuntajeJ1().clear();
			vjvm.getPuntajeJ2().clear();
			vjvm.setPuntajeJ1("        "+m1.getPuntajeJ1());
			vjvm.setPuntajeJ2("        "+m1.getPuntajeJ2());
		}else if (e.getActionCommand().equals("CONFIGURAR")) {
			vp.setVisible(false);	
			vc.setVisible(true);
		}else if (e.getActionCommand().equals("GUARDAR")) {
			vc.setVisible(false);
			vp.setVisible(true);
			if(vc.getR1().isSelected()){    
				repetidos=true;
			}else {
				repetidos=false;
			} 
			digitosJuego=Integer.parseInt(vc.getCampo().getSelectedItem().toString());
		}else if (e.getActionCommand().equals("REVANCHA")) {
			v1v1.getMensajes().clear();
			vp.setVisible(false);
			v1v1.setVisible(true);
			v1v1.getBtContinuar().setVisible(true);
			contjvj=prepararJuego1v1();
			if (contjvj>0){
				juego1v1();
			}

			v1v1.getPuntajeJ1().clear();
			v1v1.getPuntajeJ2().clear();
			v1v1.setPuntajeJ1("        "+m1.getPuntajeJ1());
			v1v1.setPuntajeJ2("        "+m1.getPuntajeJ2());
		}
		else if (e.getActionCommand().equals("REVANCHA2")) {
			vjvm.getMensajes().clear();
			vp.setVisible(false);
			vjvm.setVisible(true);
			vjvm.getBtContinuar().setVisible(true);
			nPista=0;
			contjvm=prepararJuego1vm();
			if (contjvm>0){
				juego1vm();
			}
			vjvm.getPuntajeJ1().clear();
			vjvm.getPuntajeJ2().clear();
			vjvm.setPuntajeJ1("        "+m1.getPuntajeJ1());
			vjvm.setPuntajeJ2("        "+m1.getPuntajeJ2());
		}else if (e.getActionCommand().equals("ATRAS2")) {
			vjvm.setVisible(false);
			vp.setVisible(true);
			vjvm.getPuntajeJ1().clear();
			vjvm.getPuntajeJ2().clear();
			m1.setPuntajeJ1(0);
			m1.setPuntajeJ2(0);
		}else if (e.getActionCommand().equals("REANUDAR")) {
			
			if(contjvm > 0){
				juego1vm();
			}else
			{
				vjvm.escribirMensaje("********************************");
				vjvm.escribirMensaje("PULSE REVANCHA PARA CONTINUAR");

			}
		}else if (e.getActionCommand().equals("REANUDAR1")) {
			
			if(contjvj > 0){
				juego1v1();
			}else
			{
				v1v1.escribirMensaje("********************************");
				v1v1.escribirMensaje("PULSE REVANCHA PARA CONTINUAR");

			}
		}else if (e.getActionCommand().equals("AYUDA")) {
			try{
			if (digitosJuego>2){
				vjvm.mostrarPista(m1.pista(nPista));
				nPista=nPista+1;
			}else{
				vjvm.mostrarPista("Ayudas permitidas a partir de 3 digitos");
			}
			}catch(IndexOutOfBoundsException err){
				
			}
		}else if (e.getActionCommand().equals("VOLVER")) {
			vi.setVisible(false);
			vp.setVisible(true);
		}else if (e.getActionCommand().equals("INFO")) {
			vp.setVisible(false);
			vi.setVisible(true);
		}

	}

}




