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
		System.out.println("Adiós");
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
			System.out.println("La matrícula del coche "+numcoche+" es "+micoche[numcoche-1].devolvermatricula());
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
				System.out.println("La opción no existe, indique 1, 2 ó 3");
			break;
		}
		
	}

	private static void maxveloc(coche[] micoche) {
		int maxveloc=0;
		for (int i=0;i<micoche.length;i++){
			if (maxveloc<micoche[i].devolvervelocidad()) maxveloc=micoche[i].devolvervelocidad();
		}
		System.out.println("La velocidad máxima es " + maxveloc);
		System.out.println("Los coches que tienen dicha velocidad son:");
		for (int i=0;i<micoche.length;i++){
			if (maxveloc==micoche[i].devolvervelocidad()) System.out.println("Número: "+(i+1)+", Matrícula "+micoche[i].devolvermatricula());
		}		
	}

	private static int introducircoche() {
		int numcoche= 0;
		do{
			System.out.println("Indique el número de coche:");
			try{
				numcoche=Integer.parseInt(introducirdato());
				if (numcoche<=0 || numcoche>numcoches) System.out.println("Ese coche no existe");
			}catch(NumberFormatException ex){
				System.out.println("Por favor, introduce un número, no un carácter");
				numcoche=-1;
			}
		}while(numcoche<=0 || numcoche>numcoches);
		return numcoche;
	}

	private static int introducirvelocidad(String tipo) {
		int velocidad=0;
		do{	
			System.out.println("Introduce cuánta velocidad desea " + tipo);
			try{
				velocidad=Integer.parseInt(introducirdato());
				if (velocidad<0 || velocidad>100) System.out.println("La aceleración estará comprendida entre 0 y 100");
			}catch(NumberFormatException ex){
				System.out.println("Por favor, introduce un número, no un carácter");
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
			System.out.println("Introduce una opción");
			try{
				opcion=Integer.parseInt(introducirdato());
				if (opcion>6 || opcion<=0) System.out.println("La opción introducida no existe");
			}catch(NumberFormatException ex){
				System.out.println("Por favor, introduce un número, no un carácter");
				opcion=0;
			}
			}while(opcion>6 || opcion<=0);
		return opcion;
	}

	private static void menu() {
		System.out.println("Escoja entre las siguientes opciones:");
		System.out.println("1-Acelerar");
		System.out.println("2-Frenar");
		System.out.println("3-Devolver matrícula");
		System.out.println("4-Devolver velocidad");
		System.out.println("5. Coche con velocidad máxima");
		System.out.println("6-Salir");
	}

	private static void mostrar(coche[] micoche) {
		for (int i=0;i<micoche.length;i++){
			System.out.println("Coche número: " + (i+1) + ", velocidad: " + micoche[i].devolvervelocidad()+", matrícula " + micoche[i].devolvermatricula());
		}
	}

	private static coche[] rellenar() {
		coche[] micoche= new coche[numcoches];
		for (int i=0;i<micoche.length;i++){
			micoche[i]= new coche();
			String matricula=null;
			System.out.println("Introduce la matrícula para el coche " + (i+1));
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
					System.out.println("Por favor, introduce un número. NO un carácter");
				}
			}while(!introducido);
			micoche[i].rellenarvelocidad(velocidad);
		}
		return micoche;
	}
	
}
