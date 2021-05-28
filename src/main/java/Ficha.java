
public class Ficha extends Circle {
    private int fila;
    private int columna;

    public Ficha(int xPos,int yPos, String color) {
        super(color, xPos, yPos);
    }

    public void mover(int x, int y) {
        moveHorizontal(y);
        moveVertical(x);
    }
}