/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPente;
import Functions.PenteFunctions;
import java.util.Scanner;
/**
 *
 * @author velet
 */
public class JuegoPente {
    public static final int CASILLA_VACIA = 0;
    public static final int FICHA_CIRCULO = 1;
    public static final int FICHA_EQUIS = 2;
    
    public static final int TAMANIO_MAX_TABLERO = 19;
    public static final int TAMANIO_MIN_TABLERO = 10;
    public static final int VICTORIA_MIN_FICHAS = 5;
    public static final int VICTORIA_MAX_FICHAS = 10;


    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int filas_tablero = 0, columnas_tablero = 0;
        int fichas_victoria = 0;
        int fila_ficha = 0, columna_ficha = 0;
        
        String jugador1, jugador2;
        
        
        
        System.out.println("    ¡HOLA!");
        System.out.println("BIENVENIDO AL JUEGO DEL PENTE");
        Functions.PenteFunctions.normasPente();
        /*
            Pedimos la dimension del tablero, la misma tanto para columnas como
            para filas
        */
        do{
            System.out.print("Por favor: Introduce la dimension (filas y columnas)"
                    + " del tablero (minimo dimension 10, maximo dimension 19): ");
            filas_tablero = input.nextInt();
            columnas_tablero = input.nextInt();
        }while((filas_tablero < TAMANIO_MIN_TABLERO || 
                filas_tablero > TAMANIO_MAX_TABLERO) || 
                (columnas_tablero < TAMANIO_MIN_TABLERO || 
                columnas_tablero > TAMANIO_MAX_TABLERO));
        
        
        //Creamos e inicializaremos el tablero de la dimension deseada
        int tablero[][] = new int[filas_tablero][columnas_tablero];
        PenteFunctions.inicializaTablero(tablero);        
        

        //Pedimos el numero de fichas para obtener la victoria
        do{
            System.out.print("Por favor: Introduce el maximo de fichas para "
                    + "obtener la victoria (minimo 5, maximo 10): ");
            fichas_victoria = input.nextInt();
        }while(fichas_victoria < VICTORIA_MIN_FICHAS || 
                fichas_victoria > VICTORIA_MAX_FICHAS);
        
        //Limpiamos buffer
        input.nextLine();
        
        
        //Pedimos el nombre a los 2 jugadores y comprobamos que sean del tamaño deseado
        do{
            System.out.print("Por favor: Jugador1, introduzca su nombre (minimo 3 "
                    + "caracteres, maximo 20 caracteres): ");
            jugador1 = input.nextLine();
        }while(!PenteFunctions.compruebaNombreJugador(jugador1)); 
        
        System.out.println("Bienvenido Jugador1: " + jugador1);
        //Al jugador 1 se le asignara la ficha FICHA_CIRCULO
        int ficha_jugador_1 = FICHA_CIRCULO;
        
        
        
        do{
            System.out.print("Por favor: Jugador2, introduzca su nombre (minimo 3 "
                    + "caracteres, maximo 20 caracteres): ");
            jugador2 = input.nextLine();
        }while(!PenteFunctions.compruebaNombreJugador(jugador2)); 
        
        System.out.println("Bienvenido Jugador2: " + jugador2);
        //Al jugador 2 se le asignara la ficha FICHA_EQUIS
        int ficha_jugador_2 = FICHA_EQUIS;
        
        int fichas_capturadas_j2 = 0;
        int fichas_capturadas_j1 = 0;
        
        boolean victoria_captura = fichas_capturadas_j2 == fichas_victoria || 
                fichas_capturadas_j1 == fichas_victoria;
        
        //Programa OK
        
        
        
        
        do{
            System.out.println("Jugador: " + jugador1 + " ,por favor introduzca la"
                    + " posicion donde desea colocar la ficha: ");
            fila_ficha = input.nextInt();
            columna_ficha = input.nextInt();

            while(!PenteFunctions.estaLibre(tablero, fila_ficha, columna_ficha)){
                System.out.println("Posicion ya ocupada, por favor introduzca "
                        + "nuevamente la ficha");
                fila_ficha = input.nextInt();
                columna_ficha = input.nextInt();
            }

            PenteFunctions.colocarFicha(tablero, ficha_jugador_1, fila_ficha, columna_ficha);        
            PenteFunctions.mostrarTablero(tablero, fila_ficha, columna_ficha);

            System.out.println("Jugador: " + jugador2 + " ,por favor introduzca la"
                    + " posicion donde desea colocar la ficha: ");
            fila_ficha = input.nextInt();
            columna_ficha = input.nextInt();

            while(!PenteFunctions.estaLibre(tablero, fila_ficha, columna_ficha)){
                System.out.println("Posicion ya ocupada, por favor introduzca "
                        + "nuevamente la ficha");
                fila_ficha = input.nextInt();
                columna_ficha = input.nextInt();
            }

            PenteFunctions.colocarFicha(tablero, ficha_jugador_2, fila_ficha, columna_ficha);     
            PenteFunctions.mostrarTablero(tablero, fila_ficha, columna_ficha);
        }while(PenteFunctions.casillasLibres(tablero));
        
    }
    
}

