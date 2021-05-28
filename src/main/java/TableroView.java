
public class TableroView {

    private Square casillas[][];
    public static final char[] COLUMNAS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public TableroView() {
        casillas = new Square[8][8];
    }

    public void dibujarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Control.getCasillas()[i][j].makeVisible();
            }
        }
    }

    public void dibujarFichas() {
        for (Negras ne : Control.getFichasNegras()) {
            ne.makeVisible();
        }
        for (Rojas ro : Control.getFichasRojas()) {
            ro.makeVisible();
        }
        

    }

}
