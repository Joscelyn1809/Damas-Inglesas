
import java.util.ArrayList;

public class Control {

    private static ArrayList<Negras> fichasNegras;
    private static ArrayList<Rojas> fichasRojas;
    private static Casilla[][] casillas;
    public static final char[] COLUMNAS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public Control() {
        fichasNegras = new ArrayList();
        fichasRojas = new ArrayList();
        casillas = new Casilla[8][8];

    }

    public void crearFichas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if (casillas[i][j].getColor().equals("cafe")) {
                    Negras fichaNe = new Negras(casillas[i][j].getxPosition(), casillas[i][j].getyPosition());
                    fichasNegras.add(fichaNe);
                    casillas[i][j].ocuparCasilla("black");
                }
            }
        }
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (casillas[i][j].getColor().equals("cafe")) {
                    Rojas fichaRo = new Rojas(casillas[i][j].getxPosition(), casillas[i][j].getyPosition());
                    fichasRojas.add(fichaRo);
                    casillas[i][j].ocuparCasilla("red");
                }
            }
        }
    }

    public void crearTablero() {

        boolean col = false;
        String color;

        int yPos = 100;

        for (int i = 0; i < 8; i++) {
            int xPos = 100;
            for (int j = 0; j < 8; j++) {
                if (col) {
                    color = "cafe";
                } else {
                    color = "cafe claro";
                }
                col = !col;
                Casilla casilla = new Casilla(color, i, COLUMNAS[j], xPos, yPos);
                casillas[i][j] = casilla;

                xPos += 50;
            }
            col = !col;

            yPos += 50;
        }
    }

    public static Casilla[][] getCasillas() {
        return casillas;
    }

    public static ArrayList<Negras> getFichasNegras() {
        return fichasNegras;
    }

    public static ArrayList<Rojas> getFichasRojas() {
        return fichasRojas;
    }
    
    public Rojas getFichaRoja(int x, int y){
        Rojas fichaBuscar=null;
        for(Rojas ficha:fichasRojas){
            if(ficha.getxPosition()==x && ficha.getyPosition()==y)
                fichaBuscar=ficha;
        }
        return fichaBuscar;
    }
    
    public Negras getFichaNegra(int x, int y){
        Negras fichaBuscar=null;
        for(Negras ficha:fichasNegras){
            if(ficha.getxPosition()==x && ficha.getyPosition()==y)
                fichaBuscar=ficha;
        }
        return fichaBuscar;
    }
    
    public void borrarFichaNegra(int x, int y){
        Ficha fichaBorrar=null;
        for(Negras ficha:fichasNegras){
            if(ficha.getxPosition()==x && ficha.getyPosition()==y)
                fichaBorrar=ficha;
        }
        int posFicha=fichasNegras.indexOf(fichaBorrar);
        fichasNegras.get(posFicha).makeInvisible();
    }
    
    public void borrarFichaRoja(int x, int y){
        Ficha fichaBorrar=null;
        for(Rojas ficha:fichasRojas){
            if(ficha.getxPosition()==x && ficha.getyPosition()==y)
                fichaBorrar=ficha;
        }
        int posFicha=fichasRojas.indexOf(fichaBorrar);
        fichasRojas.get(posFicha).makeInvisible();
    }

    public boolean moverFichaRoja(int filaOrigen, int colOrigen, int filaDest, int colDest) {
        Casilla casillaOrigen=casillas[filaOrigen][colOrigen];
        Casilla casillaDestino=casillas[filaDest][colDest];
        Rojas ficha=getFichaRoja(casillaOrigen.getxPosition(),casillaOrigen.getyPosition());
        boolean exito=false;
        
        
        //Que la casilla destino no este ocupada y la ficha exista
        if (!casillaDestino.isEstaOcupado() && ficha != null) {
            //Como la ficha si existe, queremos saber en que pos del arraylist esta
            int posFicha=fichasRojas.indexOf(ficha);
            //Que el movimiento sea para avanzar
            if (filaOrigen - 1 == filaDest) {
                //Si el movimiento es a la derecha
                if (colOrigen + 1 == colDest) {
                    fichasRojas.get(posFicha).mover(-60, 60);
                    exito=true;
                }
                else if(colOrigen - 1 == colDest){
                    fichasRojas.get(posFicha).mover(-60, -60);
                    exito=true;
                }
            }
            
            else if(filaOrigen - 2 == filaDest){
                if (colOrigen + 2 == colDest && 
                    casillas[filaOrigen-1][colOrigen+1].isEstaOcupado() &&
                    casillas[filaOrigen-1][colOrigen+1].getColorDeLaFicha().equals("black")){
                    
                    //Se mueve la ficha
                    fichasRojas.get(posFicha).mover(-120, 120);
                    //Se desocupa la casilla de la ficha comida
                    casillas[filaOrigen-1][colOrigen+1].desocuparCasilla();
                    //Se borra la ficha comida
                    Casilla casillaComida=casillas[filaOrigen-1][colOrigen+1];
                    borrarFichaNegra(casillaComida.getxPosition(),casillaComida.getyPosition());
                    exito=true;
                }
                else if (colOrigen - 2 == colDest && 
                    casillas[filaOrigen-1][colOrigen-1].isEstaOcupado() &&
                    casillas[filaOrigen-1][colOrigen-1].getColorDeLaFicha().equals("black")){
                    
                    //Se mueve la ficha
                    fichasRojas.get(posFicha).mover(-120, -120);
                    //Se desocupa la casilla de la ficha comida
                    casillas[filaOrigen-1][colOrigen-1].desocuparCasilla();
                    //Se borra la ficha comida
                    Casilla casillaComida=casillas[filaOrigen-1][colOrigen-1];
                    borrarFichaNegra(casillaComida.getxPosition(),casillaComida.getyPosition());
                    exito=true;
                }
            }
        }
        
        if(exito){
            casillas[filaOrigen][colOrigen].desocuparCasilla();
            casillas[filaDest][colDest].ocuparCasilla("red");
        }
        
        return exito;
    }

    public boolean moverFichasNegras(int filaOrigen, int colOrigen, int filaDest, int colDest) {
        Casilla casillaOrigen=casillas[filaOrigen][colOrigen];
        Casilla casillaDestino=casillas[filaDest][colDest];
        Negras ficha=getFichaNegra(casillaOrigen.getxPosition(),casillaOrigen.getyPosition());
        boolean exito=false;
        
        if (!casillaDestino.isEstaOcupado() && ficha != null) {
            //Como la ficha si existe, queremos saber en que pos del arraylist esta
            int posFicha=fichasNegras.indexOf(ficha);
            //Que el movimiento sea para avanzar
            if (filaOrigen + 1 == filaDest) {
                //Si el movimiento es a la derecha
                if (colOrigen - 1 == colDest) {
                    fichasNegras.get(posFicha).mover(60, 60);
                    exito=true;
                }
                else if(colOrigen + 1 == colDest){
                    fichasNegras.get(posFicha).mover(60, -60);
                    exito=true;
                }
            }
            
            else if(filaOrigen + 2 == filaDest){
                if (colOrigen - 2 == colDest && 
                    casillas[filaOrigen+1][colOrigen-1].isEstaOcupado() &&
                    casillas[filaOrigen+1][colOrigen-1].getColorDeLaFicha().equals("red")){
                    
                    //Se mueve la ficha
                    fichasRojas.get(posFicha).mover(120, 120);
                    //Se desocupa la casilla de la ficha comida
                    casillas[filaOrigen+1][colOrigen-1].desocuparCasilla();
                    //Se borra la ficha comida
                    Casilla casillaComida=casillas[filaOrigen+1][colOrigen-1];
                    borrarFichaRoja(casillaComida.getxPosition(),casillaComida.getyPosition());
                    exito=true;
                }
                else if (colOrigen + 2 == colDest && 
                    casillas[filaOrigen+1][colOrigen+1].isEstaOcupado() &&
                    casillas[filaOrigen+1][colOrigen+1].getColorDeLaFicha().equals("red")){
                    
                    //Se mueve la ficha
                    fichasNegras.get(posFicha).mover(120, -120);
                    //Se desocupa la casilla de la ficha comida
                    casillas[filaOrigen+1][colOrigen+1].desocuparCasilla();
                    //Se borra la ficha comida
                    Casilla casillaComida=casillas[filaOrigen+1][colOrigen+1];
                    borrarFichaRoja(casillaComida.getxPosition(),casillaComida.getyPosition());
                    exito=true;
                }
            }
        }
        
        if(exito){
            casillas[filaOrigen][colOrigen].desocuparCasilla();
            casillas[filaDest][colDest].ocuparCasilla("black");
        }
        
        return exito;
    }
}
