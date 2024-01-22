/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

/**
 *
 * @author velet
 */
public class FuncionesIII {
    
    static public int generarAleatorio(int max, int min){
        int valor = (int) (Math.random()*(( max - min) + 1) + min); 
        
        return valor;
    }
    
    static public int generarAleatorio(){
        int valor = (int) (Math.random() * 100);
        return valor;
    }
    
    static public int []copiaArray(int array[]){
        int[] array_copia = new int [array.length];
        
        for (int i = 0; i < array.length; i++) {
            array_copia[i] = array [i];
        }
        
        return array_copia;
    }
    
    
    
    static public void imprimeIntArray(int array[]){
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        System.out.println("");
    } 
    
    
    static public void imprimeIntArray(int array[][]){
        
        for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }  
    
    
    static public int imprimePosMinimoArray(int array[][]){
        int minimo = array[0][0];
        int pos_minimo = 0;
    
         for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array[0].length; j++) {
                if(minimo > array[i][j]){
                    pos_minimo = i * array[0].length + j;
                    minimo = array[i][j];
                }
            }
         }
         return pos_minimo;
    }
    
    static public int imprimePosMinimoArray(int array[]){
        int minimo = array[0];
        int pos_minimo = 0;
        
        for (int i = 0; i < array.length; i++) {
            if(minimo > array[i]){
                pos_minimo = i;
                minimo = array[i];
            }
        }
        return pos_minimo;
    }
    
    static public int buscaMinimoArray(int array[][]){
        int minimo = array[0][0];
        
        for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array[0].length; j++) {
                if(minimo > array[i][j]){
                    minimo = array[i][j];
                }
            }
         }
         return minimo;
    }
    
    static public int buscaMinimoArray(int array[]){
        int minimo = array[0];
        
        for (int i = 0; i < array.length; i++) {
            if(minimo > array[i])
                minimo = array[i];
        }
        
        return minimo;
    }
    
    
    static public int imprimePosMaximoArray(int array[][]){
        int maximo = array[0][0];
        int pos_maximo = 0;
    
         for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array[0].length; j++) {
                if(maximo < array[i][j]){
                    pos_maximo = i * array[0].length + j;
                    maximo = array[i][j];
                }
            }
         }
         return pos_maximo;
    }
    
    static public int imprimePosMaximoArray(int array[]){
        int maximo = array[0];
        int pos_maximo = 0;
        
        for (int i = 0; i < array.length; i++) {
            if(maximo < array[i]){
                pos_maximo = i;
                maximo = array[i];
            }
        }
        return pos_maximo;
    }
    
    
    static public int buscaMaximoArray(int array[][]){
        int maximo = array[0][0];
        
        for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < array[0].length; j++) {
                if(maximo < array[i][j]){
                    maximo = array[i][j];
                }
            }
         }
         return maximo;
    }
    
    static public int buscaMaximoArray(int array[]){
        int maximo = array[0];
        
        for (int i = 0; i < array.length; i++) {
            if(maximo < array[i])
                maximo = array[i];
        }
        
        return maximo;
    }
    
    
    
    
    
    
    static public double mediaArray(int array[]){
        double media;
        double sumaValores = 0;
        
        for (int i = 0; i < array.length; i++) {
            sumaValores += array[i];
        }
        
        media = sumaValores / (double) array.length;     
        
        return media;
    }
    
    
    static public int buscaPosValorArray(int array[], int aBuscar){
        int indice;
        
        for (int i = 0; i < array.length; i++) {
            if(array[i] == aBuscar)
                return i;
        }
        
        return -1;
    }
    
    static public void voltearArray(int vector[]){
        int arrayVoltear[] = new int [vector.length];
        int indiceVolteado = vector.length - 1;
        
        
        for (int i = 0; i < vector.length; i++) {
            arrayVoltear[i] = vector[indiceVolteado];
            indiceVolteado--;
        }
        
        vector = FuncionesIII.copiaArray(arrayVoltear);
    }

    
    
    
    static public int []filaMatriz(int matriz[][], int fila){
        int arrayFila[] = new int[matriz[fila].length];
        
        for (int i = 0; i < matriz[fila].length; i++) {
            arrayFila[i] = matriz[fila][i];
        }
        
        return arrayFila;
    }
    
    
    static public int []columnaMatriz(int matriz[][], int columna){
        int arrayColumna[] = new int[matriz.length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(j == columna)
                    arrayColumna[i] = matriz[i][j];
            }
        }
        
        return arrayColumna;
    }
    
    static public int []coordenadaValorEnMatriz(int matriz[][], int valorBuscar){
        int coordenadas[] = new int[2];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(valorBuscar == matriz[i][j]){
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                    return coordenadas;
                }
            }
        }
        
        coordenadas[0] = -1;
        coordenadas[1] = -1;
        return coordenadas;
    }
    
    static public int [][]sumaMatrices(int matriz[][], int matriz2[][]){
        int matrizSuma[][] = new int[matriz.length][matriz[0].length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matrizSuma[i][j] = matriz[i][j] + matriz2[i][j];
            }
        }
        
        return matrizSuma;
    }
    
    
    static public int []sumaFilasMatriz(int matriz[][]){
        int vectorSumas[] = new int[matriz.length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                vectorSumas[i] += matriz[i][j];
            }
        }
        return vectorSumas;
    }
    
    static public int []sumaColumnasMatriz(int matriz[][]){
        int vectorSumas[] = new int[matriz[0].length];
        int suma = 0;
        
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                vectorSumas[j] += matriz[i][j];
            }
        }
        return vectorSumas;
    }
    
    static public int [][]traspuestaMatriz(int matriz[][]){
        int n_filas = matriz[0].length;
        int n_columnas = matriz.length;
        int traspuesta[][] = new int[n_filas][n_columnas];
        int fila = 0;
        int columna = 0;
        
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if(columna >= n_columnas){
                    fila++;
                    columna = 0;
                }
                
                traspuesta[fila][columna] = matriz[i][j];
                columna++;
            }
        }
        return traspuesta;
    }
    
}
