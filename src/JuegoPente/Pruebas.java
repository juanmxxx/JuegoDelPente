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
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        Scanner input = new Scanner(System.in);
        char letra = 'd';
        int tablero[][] = new int[13][13];
        int fichas = 0;
     
        meterCapturaDiagonalInferior(tablero, 6, 6);
        meterCapturaDiagonalSuperior(tablero, 6, 6);
        meterCapturaHorizontal(tablero, 6, 6);
        PenteFunctions.mostrarTablero(tablero, 6, 6);
        
        fichas = PenteFunctions.capturarFicha(tablero, 6, 6);
        System.out.println("\n\n\n");
        PenteFunctions.mostrarTablero(tablero, 6, 6);
        System.out.println(fichas);
        
        
    }
    
    
    public static void meterCapturaDiagonalSuperior(int tablero[][], int fila, int centro){
        PenteFunctions.colocarFicha(tablero, 2, fila, centro);
        
        if(fila >= 3 && centro >= 3){
            PenteFunctions.colocarFicha(tablero, 2, fila - 3, centro - 3);
            PenteFunctions.colocarFicha(tablero, 1, fila - 2, centro - 2);
            PenteFunctions.colocarFicha(tablero, 1, fila - 1, centro - 1);
        }
        
        if(fila < tablero.length - 3 && centro < tablero[0].length - 3){
            PenteFunctions.colocarFicha(tablero, 2, fila + 3, centro + 3);
            PenteFunctions.colocarFicha(tablero, 1, fila + 2, centro + 2);
            PenteFunctions.colocarFicha(tablero, 1, fila + 1, centro + 1);
        }
    }
    
    
    public static void meterCapturaDiagonalInferior(int tablero[][], int fila, int centro){
        PenteFunctions.colocarFicha(tablero, 2, fila, centro);
        
        if(fila >= 3 && centro < tablero[0].length - 3){
            PenteFunctions.colocarFicha(tablero, 2, fila - 3, centro + 3);
            PenteFunctions.colocarFicha(tablero, 1, fila - 2, centro + 2);
            PenteFunctions.colocarFicha(tablero, 1, fila - 1, centro + 1);
        }
        
        if(fila < tablero.length - 3 && centro >= 3){
            PenteFunctions.colocarFicha(tablero, 2, fila + 3, centro - 3);
            PenteFunctions.colocarFicha(tablero, 1, fila + 2, centro - 2);
            PenteFunctions.colocarFicha(tablero, 1, fila + 1, centro - 1);
        }
    }
    
    
    public static void meterCapturaHorizontal(int tablero[][], int fila, int centro){
        PenteFunctions.colocarFicha(tablero, 2, fila, centro);
        if(centro > 0) PenteFunctions.colocarFicha(tablero, 1, fila, centro - 1);
        if(centro > 1) PenteFunctions.colocarFicha(tablero, 1, fila, centro - 2);
        if(centro < tablero[0].length - 1) PenteFunctions.colocarFicha(tablero, 1, fila, centro + 1);
        if(centro < tablero[0].length - 2) PenteFunctions.colocarFicha(tablero, 1, fila, centro + 2);
        if(centro < tablero[0].length - 3) PenteFunctions.colocarFicha(tablero, 2, fila, centro + 3);
        if(centro > 2) PenteFunctions.colocarFicha(tablero, 2, fila, centro - 3);
        
    }
    
    
    public static void meterCapturaVertical(int tablero[][], int centro, int columna){
        PenteFunctions.colocarFicha(tablero, 2, centro, columna);
        if(centro > 0) PenteFunctions.colocarFicha(tablero, 1, centro - 1, columna);
        if(centro > 1) PenteFunctions.colocarFicha(tablero, 1, centro - 2, columna);
        if(centro < tablero.length - 1) PenteFunctions.colocarFicha(tablero, 1, centro + 1, columna);
        if(centro < tablero.length - 2) PenteFunctions.colocarFicha(tablero, 1, centro + 2, columna);
        if(centro < tablero.length - 3) PenteFunctions.colocarFicha(tablero, 2, centro + 3, columna);
        if(centro > 2) PenteFunctions.colocarFicha(tablero, 2, centro - 3, columna);
        
    }
    
    
    public static void meterLineaFila(int tablero[][]){
        PenteFunctions.colocarFicha(tablero, 2, 6, 5);
        PenteFunctions.colocarFicha(tablero, 2, 6, 3);
        PenteFunctions.colocarFicha(tablero, 2, 6, 6);
        PenteFunctions.colocarFicha(tablero, 2, 6, 4);
        PenteFunctions.colocarFicha(tablero, 2, 6, 9);      
    }
    
    
     public static void meterLineaColumna(int tablero[][]){
        PenteFunctions.colocarFicha(tablero, 2, 1, 6);
        PenteFunctions.colocarFicha(tablero, 2, 5, 6);
        PenteFunctions.colocarFicha(tablero, 2, 7, 6);
        PenteFunctions.colocarFicha(tablero, 2, 4, 6);
        PenteFunctions.colocarFicha(tablero, 2, 2, 6);      
    }
     
     
     public static void meterLineaDiagonalS(int tablero[][]){
         PenteFunctions.colocarFicha(tablero, 2, 9, 9);
         PenteFunctions.colocarFicha(tablero, 2, 10, 10);
         PenteFunctions.colocarFicha(tablero, 2, 11, 11);
         PenteFunctions.colocarFicha(tablero, 2, 7, 7);
         PenteFunctions.colocarFicha(tablero, 2, 3, 3);
         
     }
     
     public static void meterLineaDiagonalI(int tablero[][]){
         PenteFunctions.colocarFicha(tablero, 2, 10, 2);
         PenteFunctions.colocarFicha(tablero, 2, 9, 3);
         //PenteFunctions.colocarFicha(tablero, 2, 7, 5);
         PenteFunctions.colocarFicha(tablero, 2, 8, 4);
         PenteFunctions.colocarFicha(tablero, 2, 3, 3);
         
     }
}
