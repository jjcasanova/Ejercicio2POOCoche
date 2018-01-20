import java.io.*;

public class principal {

	private static int numcoches=20;
	
	public static void main(String[] args) {
		coche[] micoche= new coche[numcoches];
		micoche=rellenar();
		mostrar(micoche);
		int opcion;
		do{
			menu();
			opcion=opcion();
			enrutamiento(opcion,micoche);
		}while(opcion!=6);
		System.out.println("Adi�s");
	}

	private static void enrutamiento(int opcion, coche[] micoche) {
		int velocidad=0, numcoche=0;
		switch(opcion){
		case 1:
			velocidad=introducirvelocidad("acelerar");
			numcoche=introducircoche();
			micoche[numcoche-1].acelerar(velocidad);
			break;
		case 2:
			velocidad=introducirvelocidad("frenar");
			numcoche=introducircoche();
			micoche[numcoche-1].frenar(velocidad);			
			break;
		case 3:
			numcoche=introducircoche();
			System.out.println("La matr�cula del coche "+numcoche+" es "+micoche[numcoche-1].devolvermatricula());
			break;
		case 4:
			numcoche=introducircoche();
			System.out.println("La velocidad del coche "+numcoche+" es "+micoche[numcoche-1].devolvervelocidad());
			break;
		case 5:
			maxveloc(micoche);
			break;
		case 6:
			System.out.println("Salimos del programa");
			break;
			default:
				System.out.println("La opci�n no existe, indique 1, 2 � 3");
			break;
		}
		
	}

	private static void maxveloc(coche[] micoche) {
		int maxveloc=0;
		for (int i=0;i<micoche.length;i++){
			if (maxveloc<micoche[i].devolvervelocidad()) maxveloc=micoche[i].devolvervelocidad();
		}
		System.out.println("La velocidad m�xima es " + maxveloc);
		System.out.println("Los coches que tienen dicha velocidad son:");
		for (int i=0;i<micoche.length;i++){
			if (maxveloc==micoche[i].devolvervelocidad()) System.out.println("N�mero: "+(i+1)+", Matr�cula "+micoche[i].devolvermatricula());
		}		
	}

	private static int introducircoche() {
		int numcoche= 0;
		do{
			System.out.println("Indique el n�mero de coche:");
			try{
				numcoche=Integer.parseInt(introducirdato());
				if (numcoche<=0 || numcoche>numcoches) System.out.println("Ese coche no existe");
			}catch(NumberFormatException ex){
				System.out.println("Por favor, introduce un n�mero, no un car�cter");
				numcoche=-1;
			}
		}while(numcoche<=0 || numcoche>numcoches);
		return numcoche;
	}

	private static int introducirvelocidad(String tipo) {
		int velocidad=0;
		do{	
			System.out.println("Introduce cu�nta velocidad desea " + tipo);
			try{
				velocidad=Integer.parseInt(introducirdato());
				if (velocidad<0 || velocidad>100) System.out.println("La aceleraci�n estar� comprendida entre 0 y 100");
			}catch(NumberFormatException ex){
				System.out.println("Por favor, introduce un n�mero, no un car�cter");
				velocidad=-1;
			}
		}while(velocidad<0 || velocidad>100);
		return velocidad;
	}

	private static String introducirdato() {
		String teclado=null;
		BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
		try{
			teclado=leer.readLine();
		}catch(IOException ex){
			System.out.println("No he podido leer el dato");
		}
		return teclado;
	}

	private static int opcion() {
		int opcion=0;
		do{
			System.out.println("Introduce una opci�n");
			try{
				opcion=Integer.parseInt(introducirdato());
				if (opcion>6 || opcion<=0) System.out.println("La opci�n introducida no existe");
			}catch(NumberFormatException ex){
				System.out.println("Por favor, introduce un n�mero, no un car�cter");
				opcion=0;
			}
			}while(opcion>6 || opcion<=0);
		return opcion;
	}

	private static void menu() {
		System.out.println("Escoja entre las siguientes opciones:");
		System.out.println("1-Acelerar");
		System.out.println("2-Frenar");
		System.out.println("3-Devolver matr�cula");
		System.out.println("4-Devolver velocidad");
		System.out.println("5. Coche con velocidad m�xima");
		System.out.println("6-Salir");
	}

	private static void mostrar(coche[] micoche) {
		for (int i=0;i<micoche.length;i++){
			System.out.println("Coche n�mero: " + (i+1) + ", velocidad: " + micoche[i].devolvervelocidad()+", matr�cula " + micoche[i].devolvermatricula());
		}
	}

	private static coche[] rellenar() {
		coche[] micoche= new coche[numcoches];
		for (int i=0;i<micoche.length;i++){
			micoche[i]= new coche();
			String matricula=null;
			System.out.println("Introduce la matr�cula para el coche " + (i+1));
			matricula=introducirdato();
			micoche[i].rellenarmatricula(matricula);
			int velocidad=0;
			boolean introducido=false;
			do{
				System.out.println("Introduce la velocidad para el coche " + (i+1));
				try{
					velocidad=Integer.parseInt(introducirdato());
					if (velocidad>0 && velocidad <=300)introducido=true;
				}catch(NumberFormatException ex){
					System.out.println("Por favor, introduce un n�mero. NO un car�cter");
				}
			}while(!introducido);
			micoche[i].rellenarvelocidad(velocidad);
		}
		return micoche;
	}
	
}
