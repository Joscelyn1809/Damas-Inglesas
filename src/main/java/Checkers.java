
public class Checkers {

    public static void main(String[] args) {
        TableroView tab = new TableroView();
        Control control = new Control();
        control.crearTablero();
        tab.dibujarTablero();
        control.dibujarFichas();
        tab.dibujarFichas();
    }
}
