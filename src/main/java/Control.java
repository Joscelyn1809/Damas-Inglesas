
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

    public void dibujarFichas() {
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
    
}
