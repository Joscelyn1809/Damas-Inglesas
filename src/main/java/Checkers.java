
import java.util.Scanner;


public class Checkers {

    public static void main(String[] args) {
        TableroView tab = new TableroView();
        Control control = new Control();
        Scanner scan=new Scanner(System.in);
        
        control.crearTablero();
        tab.dibujarTablero();
        control.crearFichas();
        tab.dibujarFichas();
        
        boolean turno=true;
        
        System.out.println("Bienvenido a Damas Inglesas");
        
        for(int i=0;i<5;i++){
            if(turno) System.out.println("\n\f\tTURNO DE ROJAS.");
            else System.out.println("\n\f\tTURNO DE NEGRAS.");
            
            //Se lee la fila de la ficha a mover
            System.out.println("Ingrese fila de ficha a mover(1-8): ");
            int filaOrigen=scan.nextInt()-1;
            scan.nextLine();//Se limpia buffer
            
            //Se lee la columna de la ficha a mover
            System.out.println("Ingrese columna de ficha a mover(a-h): ");
            String col=scan.nextLine().toLowerCase();
            char columnaOrigen=col.toCharArray()[0];//Esta es la columna a mover
            
            //Se lee la fila de la casilla destino
            System.out.println("Ingrese la fila destino(1-8): ");
            int filaDest=scan.nextInt()-1;
            scan.nextLine();
            
            //Se lee la columna del destino
            System.out.println("Ingrese columna de ficha a mover(a-h): ");
            col=scan.nextLine().toLowerCase();
            char colDest=col.toCharArray()[0];//Esta es la columna destino
            
            int posColOrigen = new String(Control.COLUMNAS).indexOf(columnaOrigen);
            int posColDest = new String(Control.COLUMNAS).indexOf(colDest);
            
            if(turno){
                if(control.moverFichaRoja(filaOrigen,posColOrigen,filaDest,posColDest)){
                    turno=!turno;
                }
                else{
                    System.out.println("MOVIMIENTO NO VALIDO.");
                    i--;
                }
            }else {
                if(control.moverFichasNegras(filaOrigen, posColOrigen, filaDest, posColDest)){
                    turno=!turno;
                }else{
                    System.out.println("MOVIMIENTO NO VALIDO.");
                    i--;
                }
                
            }
        }
        System.out.println("FIN DEL JUEGO");
        control.verificarGanador();
    }
}
