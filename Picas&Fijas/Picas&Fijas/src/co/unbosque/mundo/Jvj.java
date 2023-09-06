package co.unbosque.mundo;

import java.util.ArrayList;

/**
 * Clase que contiene los metodos del mundo
 */
public class Jvj {
	/**
	 * Lista en la que se encuentran los numeros ingresados por el jugador 1
	 */
	private ArrayList numeros1;
	/**
	 * Lista en la que se encuentran los numeros ingresados por el jugador 2
	 */
	private ArrayList numeros2;
	/**
	 * Lista en la que se encuentran las picas obtenidas en una iteracion
	 */
	private ArrayList picas;
	/**
	 * Lista en la que se encuentran las fijas obtenidas en una iteracion
	 */
	private ArrayList fijas;
	/**
	 * Entero con el puntaje del jugador 1
	 */
	private int puntajeJ1;
	/**
	 * Entero con el puntaje del jugador 1
	 */
	private int puntajeJ2;

	/**
	 * Metodo contructor de la clase. * <br>
	 */
	public Jvj(){

		//VARIABLES
		numeros1= new ArrayList();
		numeros2= new ArrayList();
		fijas=new ArrayList();
		picas=new ArrayList();
		puntajeJ1=0;
		puntajeJ2=0;

	}

	/**
	 * Metodo encargado de validar los datos ingresador por el usuario
	 * <br>
	 * @param n ArrayList con el numero ingresado partido en pocisiones
	 * @return String del estado de la validacion
	 */
	public String validar(ArrayList n){
		String rta="";
		int cont=0;
		//VAlida que solo se ingresen numeros
		for(int i=0;i<n.size();i++){
			try{
				int num=Integer.parseInt(n.get(i).toString());
			}catch(NumberFormatException e){
				cont=cont+1;
			}
		}
		if(cont>0){

		}else{
			cont=validarRepetidos(n);
		}

		if(cont>0){
			rta="invalido";
		}else{
			rta="valido";
		}
		return rta;
	}
	
	/**
	 * Metodo encargado de validar los datos ingresador por el usuario cuando se pueden repetir digitos
	 * <br>
	 * @param n ArrayList con el numero ingresado partido en pocisiones
	 * @return String del estado de la validacion
	 */
	public String validarR(ArrayList n){
		String rta="";
		int cont=0;
		//VAlida que solo se ingresen numeros
		for(int i=0;i<n.size();i++){
			try{
				int num=Integer.parseInt(n.get(i).toString());
			}catch(NumberFormatException e){
				cont=cont+1;
			}
		}
		if(cont>0){
			rta="invalido";
		}else{
			rta="valido";
		}
		return rta;
	}

	/**
	 * Metodo encargado de validar los datos ingresador por el usuario 
	 * <br>
	 * @param n ArrayList con el numero ingresado partido en pocisiones
	 * @return int cantidad de digitos repetidos
	 */
	public int validarRepetidos(ArrayList n){
		int cont=0;
		for(int i=0;i<n.size();i++){
			for(int j=0;j<n.size();j++){
				if(j!=i){
					if(n.get(i)==n.get(j)){
						cont=+1;
					}
				}
			}
		}
		return cont;
	}

	/**
	 * Metodo encargado de partir los digitos ingresados y guardarlos uno a uno en un Arraylist
	 * <br>
	 * @param nn String con el numero ingresado partido en pocisiones
	 * @return ArrayList con el numero partido
	 */
	public ArrayList llenarArreglo(String nn){
		ArrayList rta=new ArrayList();
		for(int i=0;i<nn.length();i++){
			rta.add(nn.charAt(i));
		}
		return rta;

	}


	/**
	 * Metodo encargado de validar la cantidad de fijas en el 
	 * numero ingresado por el usuario
	 * <br>
	 * @param numeroGuardado,nIntento ArrayList con los numeros a comparar, el numero guardado para el jugador 1
	 * vs el numero que esta ingresando el jugador 2 tratando de adivinar
	 * 
	 * @return String con la cantidad de picas y fijas
	 */
	public String validarFija(ArrayList numeroGuardado, ArrayList nIntento){
		String rta="";
		int cantFijas=0;
		String picas=validarPicas(numeroGuardado, nIntento);
		for(int i=0;i<numeroGuardado.size();i++){
			if(numeroGuardado.get(i)==nIntento.get(i)){
				cantFijas=cantFijas+1;
			}
		}
		if(cantFijas==numeroGuardado.size()){
			rta=("ADIVINASTE");
			
		}else if((cantFijas==0) && (picas=="0")){
			rta=("NADA, Sigue Intentando");
		}else
			if((cantFijas!=0) && (picas!="0")){
				if(cantFijas==(numeroGuardado.size()-1)){
					picas=1+" PICAS";
					rta=("Tiene "+cantFijas+" FIJAS Y "+picas);
				}else{
					rta=("Tiene "+cantFijas+" FIJAS Y "+picas);
				}
				
			}else
				if(cantFijas!=0){
					rta=("Tiene "+cantFijas+" FIJAS");
				}else{
					rta=("Tiene "+picas);
				}

		
		return rta;
	}


	/**
	 * Metodo encargado de validar la cantidad de picas en el 
	 * numero ingresado por el usuario
	 * <br>
	 * @param numeroGuardado,nIntento ArrayList con los numeros a comparar, el numero guardado para el jugador 1
	 * vs el numero que esta ingresando el jugador 2 tratando de adivinar
	 * 
	 * @return String con la cantidad de picas
	 */
	public String validarPicas(ArrayList numeroGuardado, ArrayList nIntento){
		String rta="";
		int cantPicas=0;
		for(int i=0;i<numeroGuardado.size();i++){
			for(int j=0;j<numeroGuardado.size();j++){
				if(j!=i){
					if(numeroGuardado.get(i)==nIntento.get(j)){
						cantPicas=cantPicas+1;
						picas.add(numeroGuardado.get(i));
					}
				}
			}

		}

		if(cantPicas!=0){
			if (cantPicas>numeroGuardado.size()){
				rta=(numeroGuardado.size()+" PICAS");
			}else{
				rta=(cantPicas+" PICAS");
			}
		}else{
			rta="0";
		}

		return rta;

	}
	
	/**
	 * Metodo encargado de darle al usuario pistas o ayudas cuando lo solicite 
	 * <br>
	 * @param nPistas int Cantidad de pistas que ya ha pedido el usuario
	 * @return String con la ayuda o pista segun la cantidad de pistas dada
	 */
	public String pista(int nPistas){
		String rta="";
		if(nPistas == 0){
			int na= (int) Math.floor(Math.random()*(getNumeros2().size()+1));
			rta="Una pica es: "+getNumeros2().get(na);
		}else if(nPistas == 1){
			rta="La primera fija es: "+getNumeros2().get(0);
		}else if(nPistas == 2){
			rta="Las dos primeras fijas son: "+getNumeros2().get(0)+" "+getNumeros2().get(1);
		}else {
			rta="Solo tienes 3 ayudas";
		}
		return rta;
	}


	/**
	 * Metodo encargado de validar la cantidad de picas y fijas en el 
	 * numero ingresado por el usuario para el entrenamiento
	 * <br>
	 * @param numeroGuardado,nIntento ArrayList con los numeros a comparar, el numero guardado para el jugador 1
	 * vs el numero que esta ingresando el jugador 2 tratando de adivinar
	 * 
	 * @return String con la cantidad de picas y fijas
	 */
	public String validarEntrenamiento(ArrayList numeroGuardado, ArrayList nIntento){
		String rta="";
		int cantFijas=0;
		String Spicas=validarPicas(numeroGuardado, nIntento);
		for(int i=0;i<numeroGuardado.size();i++){
			if(numeroGuardado.get(i)==nIntento.get(i)){
				cantFijas=cantFijas+1;
				fijas.add(numeroGuardado.get(i));
			}
		}
		if(cantFijas==numeroGuardado.size()){
			rta=("ADIVINASTE");
			//			rta=true;
		}else if((cantFijas==0) && (Spicas=="0")){
			rta=("NADA, Sigue Intentando");
		}else
			if((cantFijas!=0) && (Spicas!="0")){
				rta=("Tiene "+cantFijas+" FIJAS: "+fijas+" Y "+Spicas+": "+picas);
			}else
				if(cantFijas!=0){
					rta=("Tiene "+cantFijas+" FIJAS: "+fijas);
				}else{
					rta=(Spicas+": "+picas);
				}

		picas.clear();
		fijas.clear();
		return rta;
	}


	/**
	 * Metodo encargado de generar un aleatorio
	 * <br>
	 * @param n Entero con los digitos deseados para el numero aleatorio
	 * @return String con el numero aleatorio
	 */
	public String aleatorio(int n){
		String rta="";

		for(int i=0;i<n;i++){
			int ale = (int)(Math.random()*10);
			rta=rta+ale;
		}

		return rta;
	}


	/**
	 * Getter para el puntaje del jugador 1
	 * <br>
	 * @return String con el puntaje del jugador 1
	 */
	public String getPuntajeJ1() {
		String pj1 ="";
		pj1= String.valueOf(puntajeJ1);
		return pj1;
	}

	/**
	 * Setter para el puntaje del jugador 1
	 * @param int con el puntaje del jugador 1
	 */
	public void setPuntajeJ1(int puntajeJ1) {
		this.puntajeJ1 = puntajeJ1;
	}


	/**
	 * Getter para el puntaje del jugador 1
	 * <br>
	 * @return String con el puntaje del jugador 1
	 */
	public String getPuntajeJ2() {
		String pj2="";
		pj2= String.valueOf(puntajeJ2);
		return pj2;
	}

	/**
	 * Setter para el puntaje del jugador 1
	 * @param int con el puntaje del jugador 1
	 */
	public void setPuntajeJ2(int puntajeJ2) {
		this.puntajeJ2 = puntajeJ2;
	}

	/**
	 * Getter para el numero ingresado a adivinar del jugador 1
	 * @return ArrayList con el numero a adivinar del jugador 1
	 */
	public ArrayList getNumeros1() {
		return numeros1;
	}

	/**
	 * Setter para el numero del jugador 1
	 * @param ArrayList con el numero del jugador 1
	 */
	public void setNumeros1(ArrayList numeros1) {
		this.numeros1 = numeros1;
	}

	/**
	 * Getter para el numero ingresado a adivinar del jugador 1
	 * @return ArrayList con el numero a adivinar del jugador 1
	 */
	public ArrayList getNumeros2() {
		return numeros2;
	}

	/**
	 * Setter para el numero del jugador 2
	 * @param ArrayList con el numero del jugador 2
	 */
	public void setNumeros2(ArrayList numeros2) {
		this.numeros2 = numeros2;
	}



}

