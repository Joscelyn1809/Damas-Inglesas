
public class Checkers {

    public static void main(String[] args) {
        TableroView tab = new TableroView();
        Control control = new Control();
        
        System.out.println("Bienvenido a Damas Inglesas");
        
        control.crearTablero();
        tab.dibujarTablero();
        control.dibujarFichas();
        tab.dibujarFichas();
    }
}
