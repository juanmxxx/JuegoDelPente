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
public class PenteFunctions {

    public static final int CASILLA_VACIA = 0;
    public static final int FICHA_CIRCULO = 1;
    public static final int FICHA_EQUIS = 2;
    public static final int RANGO_PENTE = 3;

            
    
    
    static public void normasPente(){
        System.out.println("\nA CONTINUACION SE DETALLARAN LAS NORMAS....\n");
        System.out.println("NORMA 1: MAXIMO 2 JUGADORES, Y SOLO PODRA GANAR 1\n");
        System.out.println("NORMA 2: PARA GANAR HAY 2 FORMAS --->   1.Se elige "
                + "el numero de fichas con las que se podria optar a la victoria");
        System.out.println("                                        y el jugador "
                + "que antes se coma el numero de fichas seleccionadas sera "
                + "elegido como ganador del pente\n"); 
        
        System.out.println("                                        2.Si algun "
                + "jugador consigue colocar 5 fichas contiguas tambien sera elegido");
        System.out.println("                                        como ganador del "
                + "Pente\n");
        System.out.println("NORMA 3: SI EN ALGUN MOMENTO DEL TRANSCURSO DE LA "
                + "PARTIDA NO SE DISPONE DE CASILLAS LIBRES EN EL TABLERO SE "
                + "CONSIDERARA EMPATE\n");
        System.out.println("NORMA 4: PARA CAPTURAR FICHAS DE NUESTRO OPONENTE "
                + "DEBEREMOS ENCERRAR 2 FICHAS SUYAS CONTIGUAS\n");
        System.out.println("NORMA 5: LAS FICHAS CONTIGUAS PUEDEN ESTAR EN "
                + "CUALQUIER FORMATO (diagonal, horizontalmente, verticalmente...)\n");
        System.out.println("NORMA 6: ¡A DISTRUTAR!!!!!!!!!!!!!\n");
    }
    
    
    public static void imprimeTurno(String jugador){
        System.out.println("Jugador " + jugador + " tu turno!");
        System.out.print("Indica posicion: ");
    }
    
    
    static public boolean compruebaNombreJugador(String jugador){
        
        if(jugador.length() > 2 && jugador.length() < 21)
            return true;
        
        
        return false;
    }
    
         
    static public void mostrarTablero(int tablero[][]){
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if(j == 0 || j == tablero[0].length - 1)
                    traduceFicha(tablero[i][j]);
                else{
                    System.out.print(" --- ");
                    traduceFicha(tablero[i][j]);
                    System.out.print(" --- ");
                }
            }
            
            System.out.println("");
        }
    }
    
    
    static public void inicializaTablero(int tablero[][]){
              
        for (int i = 0; i < tablero.length; i++) {
            
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = CASILLA_VACIA;
            }
        }
    }
    
    
    static public boolean estaLibre(int tablero[][], int fila, int columna){
        
        if(tablero[fila][columna] == CASILLA_VACIA)
            return true;
        
        return false;
    }
    
    
    static public boolean colocarFicha(int tablero[][], int ficha, int fila, int columna){
        
        if(estaLibre(tablero, fila, columna)){
            tablero[fila][columna] = ficha;
            return true;
        }
        
        return false;
    }
    
    
    static public int eliminaFicha(int tablero[][], int fila, int columna){
        final int FICHAS_ELIMINADAS = 1;
        if(!estaLibre(tablero, fila, columna)){
            tablero[fila][columna] = CASILLA_VACIA;
        }
         
        return FICHAS_ELIMINADAS;
    }
  
    public static void mostrarTablero(int tablero[][], int fila, int columna){
        char ficha_destacada = traduceFicha(tablero, fila, columna);
        //Pasamos la ficha a mayuscula
        ficha_destacada = cambiaMayuscula(ficha_destacada);
         
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                
                if((j == 0 || j == tablero[0].length - 1) && (i == fila && j == columna)){
                    System.out.print("*" + ficha_destacada + "*");
                    
                }else{
                    if(j == 0 || j == tablero[0].length - 1){
                        traduceFicha(tablero[i][j]);
                    }else{                                              
                        if(i == fila && j == columna){
                            System.out.print(" --- *" + ficha_destacada + "* --- ");
                        }else{
                            System.out.print(" --- ");
                            traduceFicha(tablero[i][j]);
                            System.out.print(" --- ");
                        }
                    }                    
                }              
            }
            
            System.out.println("");
        }
    }
    
    
    
    public static boolean casillasLibres(int tablero[][]){       
        boolean estaLibre = false;
        
        
        for (int i = 0; i < tablero.length; i++) {
            
            for (int j = 0; j < tablero[0].length && !estaLibre; j++) {
                if(tablero[i][j] == CASILLA_VACIA)
                    estaLibre = true;
            }
        }
        
        return estaLibre;
    }
   
    public static int [][]extraerSubmatriz(int tablero[][], int fila_inicio, 
            int columna_inicio, int fila_final, int columna_final){
        int filas = fila_final - fila_inicio;
        int columnas = columna_final - columna_inicio;
        
        int subTablero[][] = new int[filas][columnas];
        
        for (int i = 0; i < subTablero.length; i++) {
            for (int j = 0; j < subTablero[0].length; j++) {
                subTablero[i][j] = tablero[fila_inicio + i][columna_inicio + j];
            }
        }
        
        
        return subTablero;
    }
   
    public static int capturarFicha(int tablero[][], int fila, int columna){
        int fichas_capturadas = 0;
        
        fichas_capturadas += capturaHorizontalPente(tablero, fila, columna);
        
        fichas_capturadas += capturaVerticalPente(tablero, fila, columna);
        
        fichas_capturadas += capturaDiagonalSuperiorPente(tablero, fila, columna);
        
        fichas_capturadas += capturaDiagonalInferiorPente(tablero, fila, columna);
        
        return fichas_capturadas;
    }
   
    /*
        Funcion boolean que comprueba en la horizontal, vertical, diagonal superior, 
        diagonal inferior de una posicion si se llega al numero requerido para hacer linea
    */
    public static boolean comprobarLinea(int tablero[][], int fila, int columna){
        boolean hayLinea = false;
        int FICHA = tablero[fila][columna];
        final int MINIMO_LINEA = 5;     
        int contador_fichas = 0;
        int inicio_columna = columna - 4;
        int inicio_fila = fila - 4;
        
        if(inicio_columna < 0){
            inicio_columna = 0;
        }
        
        if(inicio_fila < 0){
            inicio_fila = 0;
        }
        
        
        //Comprobamos la horizontal si no hay linea 
        for(int i = inicio_columna; i < columna+5 && !hayLinea && i <tablero[0].length; i++){
            
            if(tablero[fila][i] == FICHA){
                contador_fichas++;
            }else{
                contador_fichas = 0;
            }
            
            if(contador_fichas == MINIMO_LINEA)
                hayLinea = true;
        }
        
        contador_fichas = reiniciaContadorA0();
        
        
        
        //Comprobamos la vertical si no hay linea
        for(int i = inicio_fila; i < fila+5 && !hayLinea && i < tablero.length; i++){
            
            if(tablero[i][columna] == FICHA){
                contador_fichas++;
            }else{
                contador_fichas = 0;
            }
            
            if(contador_fichas == MINIMO_LINEA)
                hayLinea = true;
        }
        
        contador_fichas = reiniciaContadorA0();
        
        
        
        //Comprobamos la diagonal superior si no hay linea
        int filas_diagonal_superior = inicio_fila;
        for(int i = inicio_columna; i < columna + 5 && !hayLinea && i < tablero[0].length
                && filas_diagonal_superior < tablero.length; i++){
            
            if(tablero[filas_diagonal_superior][i] == FICHA){
                contador_fichas++;
            }else{
                contador_fichas = 0;
            }
            
            if(contador_fichas == MINIMO_LINEA)
                hayLinea = true;
            
            filas_diagonal_superior++;
        }
        contador_fichas = reiniciaContadorA0();
        
        
        //Comprobamos la diagonal inferior si no hay linea
        int columnas_diagonal_inferior = columna + 4;
        
        if(columna + 4 > tablero[0].length){
            columnas_diagonal_inferior = columna + (tablero[0].length - 1 - columna);
        }
               
        for(int i = inicio_fila; i < fila + 5 && !hayLinea && i < tablero.length; i++){
            
            if(tablero[i][columnas_diagonal_inferior] == FICHA){
                contador_fichas++;
            }else{
                contador_fichas = 0;
            }
            
            if(contador_fichas == MINIMO_LINEA){
                hayLinea = true;
            }
            
            columnas_diagonal_inferior--;
        }
        
        contador_fichas = reiniciaContadorA0();
           
        
        return hayLinea;
    }
    
    public static int reiniciaContadorA0(){
        final int ZERO = 0;
        
        return ZERO;
    }
    
    
    public static char traduceFicha(int tablero[][], int fila, int columna){
        char ficha = ' ';
        if(tablero[fila][columna] == 0){
            ficha = '_';
        }
        
        if(tablero[fila][columna] == 1){
            ficha = 'o';
        }
        
        if(tablero[fila][columna] == 2){
            ficha = 'x';
        }
        
        return ficha;
    }
  
    public static void traduceFicha(int ficha){
        if(ficha == CASILLA_VACIA)
            System.out.print("_");
        
        if(ficha == FICHA_CIRCULO)
            System.out.print("o");
        
        if(ficha == FICHA_EQUIS)
            System.out.print("x");
       
    }
    
    //OK
    public static char cambiaMayuscula(char letra){
        int aux = letra;
        aux-=32;
        letra = (char) aux;
        
        return letra;
    }

    public static int devuelveFichaContraria(int tablero[][], int fila, int columna){
        int ficha_contraria = CASILLA_VACIA;
        final int FICHA = tablero[fila][columna];
        
        
        if(FICHA == FICHA_EQUIS){
            ficha_contraria = FICHA_CIRCULO;
        }else
            ficha_contraria = FICHA_EQUIS;
        
        return ficha_contraria;
    }
    
    /*
        BRIEF: funcion que directamente mirando sobre el tablero, dada una fila y una
        columna comprueba a partir de ahi si hay 2 fichas encerradas del oponente entre
        las nuestras
    */
    public static int capturaHorizontalPente(int tablero[][], int fila,
            int columna){
        int fichas_capturadas = 0;
        final int FICHA = tablero[fila][columna];
        final int INICIO = columna - RANGO_PENTE;
        final int FINAL = columna + RANGO_PENTE;
        boolean esContraria = true;
        int ficha_contraria = devuelveFichaContraria(tablero, fila, columna);
     
        /*
            Comienza comprobando si se podria dar dentro del tablero por la parte
            izquierda
        */
        if(INICIO >= 0){
            /*
                Comprobamos hacia atras si al final del supuesto
                que haya 2 fichas contrarias hay una nuestra
            */
            if(tablero[fila][INICIO] == FICHA){
                /*
                    Si se cumple la condicion comprueba que las fichas que hay 
                    entre nuestras fichas son fichas del oponente 
                */               
                for(int i = INICIO + 1; i < columna && esContraria; i++){
                    if(tablero[fila][i] != ficha_contraria){
                        esContraria = false;
                    }
                }
                /*
                    Si se resulta que hay 2 fichas del oponente entre las nuestras
                    se eliminan del tablero y aumenta el contador de fichas eliminadas
                */
                if(esContraria){
                    for(int i = INICIO + 1; i < columna; i++){
                       fichas_capturadas += eliminaFicha(tablero, fila, i);
                    }
                }else
                    esContraria = true;
            }
        }
        
        /*
            Comienza comprobando si se puede dar dentro del tablero por la parte
            derecha y hace el mismo proceso que el IF anterior solo que comprueba
            hacia delante
        */
        if(FINAL < tablero[0].length){
            if(tablero[fila][FINAL] == FICHA){

                for (int i = columna + 1; i < FINAL && esContraria; i++) {
                    if(tablero[fila][i] != ficha_contraria){
                        esContraria = false;
                    }
                }

                if(esContraria){
                    for (int i = columna + 1; i < FINAL; i++) {
                        fichas_capturadas += eliminaFicha(tablero, fila, i);
                    }
                }
            }
        }
        
        //Devuelve el total de fichas eliminadas
        return fichas_capturadas;           
    }
    
    /*
        Funcion muy similar a capturaHorizontalPente solo que juega en esta 
        ocasion con las filas en vez las columnas, pero el prodemiento es el
        mismo
    */
    public static int capturaVerticalPente(int tablero[][], int fila, int columna){
        final int INICIO = fila - RANGO_PENTE;
        final int FINAL = fila + RANGO_PENTE;
        final int FICHA = tablero[fila][columna];
        
        int fichas_capturadas = 0;
        int ficha_contraria = devuelveFichaContraria(tablero, fila, columna);
        boolean esContraria = true;
        
        if(INICIO >= 0){
            if(tablero[INICIO][columna] == FICHA && INICIO >= 0){

                for (int i = INICIO + 1; i < fila && esContraria; i++) {
                    if(tablero[i][columna] != ficha_contraria)
                        esContraria = false;
                }
                if(esContraria){

                for (int i = INICIO + 1; i < fila; i++) 
                    fichas_capturadas += eliminaFicha(tablero, i, columna);

                }else
                    esContraria = true;
            }      
        }
        
        
        if(FINAL < tablero.length){
            if(tablero[FINAL][columna] == FICHA && FINAL < tablero.length){
                for (int i = fila + 1; i < FINAL && esContraria; i++) {
                    if(tablero[i][columna] != ficha_contraria){
                        esContraria = false;
                    }
                }


                if(esContraria){

                    for (int i = fila + 1; i < FINAL; i++) 
                        fichas_capturadas += eliminaFicha(tablero, i, columna);
                    
                }
            }
        }       
        return fichas_capturadas;
    }
    
    
    public static int capturaDiagonalSuperiorPente(int tablero[][], int fila,
            int columna){        
        final int INICIO_COLUMNA = columna - RANGO_PENTE;
        final int INICIO_FILA = fila - RANGO_PENTE;
        
        final int FINAL_COLUMNA = columna + RANGO_PENTE;
        final int FINAL_FILA = fila + RANGO_PENTE;
        
        final int FICHA = tablero[fila][columna];
        
        int fichas_capturadas = 0;
        int ficha_contraria = devuelveFichaContraria(tablero, fila, columna);
        boolean esContraria = true;
        
        
        if(INICIO_COLUMNA >= 0 && INICIO_FILA >= 0){
            if(tablero[INICIO_FILA][INICIO_COLUMNA] == FICHA){
                
                int recorre_inicio_fila = INICIO_FILA + 1;
                for (int i = INICIO_COLUMNA + 1; i < columna && esContraria; i++) {
                    
                    if(tablero[recorre_inicio_fila][i] != ficha_contraria)
                        esContraria = false;
                    
                    recorre_inicio_fila++;
                }
                
                if(esContraria){
                    
                    recorre_inicio_fila = INICIO_FILA + 1;
                    for (int i = INICIO_COLUMNA + 1; i < columna; i++) {
                        fichas_capturadas += eliminaFicha(tablero, recorre_inicio_fila,
                                i);
                        
                        recorre_inicio_fila++;
                    }
                }else
                    esContraria = true;                
            }                        
        }
        
        if(FINAL_COLUMNA < tablero[0].length && FINAL_FILA < tablero.length){
            if(tablero[FINAL_FILA][FINAL_COLUMNA] == FICHA){
                
                int recorre_inicio_fila = fila + 1;
                for (int i = columna + 1; i < FINAL_COLUMNA && esContraria; i++) {
                    
                    if(tablero[recorre_inicio_fila][i] != ficha_contraria)
                        esContraria = false;
                    
                    recorre_inicio_fila++;
                }
                
                if(esContraria){
                    
                    recorre_inicio_fila = fila + 1;
                    for (int i = columna + 1; i < FINAL_COLUMNA; i++) {
                        fichas_capturadas += eliminaFicha(tablero, recorre_inicio_fila,
                                i);
                        
                        recorre_inicio_fila++;
                    }
                }               
            }           
        }
        return fichas_capturadas;
    }
    
    
    
    
    
    
    public static int capturaDiagonalInferiorPente(int tablero[][], int fila,
            int columna){ 
        final int INICIO_COLUMNA = columna + RANGO_PENTE;
        final int INICIO_FILA = fila - RANGO_PENTE;
        
        final int FINAL_COLUMNA = columna - RANGO_PENTE;
        final int FINAL_FILA = fila + RANGO_PENTE;
        
        final int FICHA = tablero[fila][columna];
        
        int fichas_capturadas = 0;
        int ficha_contraria = devuelveFichaContraria(tablero, fila, columna);
        boolean esContraria = true;
        
        
        if(INICIO_FILA >= 0 && INICIO_COLUMNA < tablero[0].length){
            if(tablero[INICIO_FILA][INICIO_COLUMNA] == FICHA){
                
                int recorre_inicio_fila = INICIO_FILA + 1; 
                for (int i = INICIO_COLUMNA - 1; i > columna && esContraria; i--) {
                    
                    if(tablero[recorre_inicio_fila][i] != ficha_contraria)
                        esContraria = false;
                    
                    recorre_inicio_fila++;
                }
                
                if(esContraria){
                    recorre_inicio_fila = INICIO_FILA + 1;
                    
                    for(int i = INICIO_COLUMNA - 1; i > columna; i--){
                        fichas_capturadas += eliminaFicha(tablero, recorre_inicio_fila, i);
                        
                        recorre_inicio_fila++;
                    }                    
                }else
                    esContraria = true;
            }
        }
            
            
        if(FINAL_FILA < tablero.length && FINAL_COLUMNA >= 0){
            if(tablero[FINAL_FILA][FINAL_COLUMNA] == FICHA){
                    
                int recorre_inicio_fila = fila + 1;
                    for (int i = columna - 1; i > FINAL_COLUMNA && esContraria; i--) {
                        
                        if(tablero[recorre_inicio_fila][i] != ficha_contraria)
                            esContraria = false;
                        
                        recorre_inicio_fila++;
                    }
                    
                    
                    if(esContraria){
                        recorre_inicio_fila = fila + 1;
                        
                        for (int i = columna - 1; i > FINAL_COLUMNA; i--) {
                            
                            fichas_capturadas += eliminaFicha(tablero, recorre_inicio_fila,
                                    i);
                            
                            recorre_inicio_fila++;
                        }
                    }
                }
            }         
        return fichas_capturadas;
    }
    
}
