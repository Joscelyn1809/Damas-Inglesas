
public class Ficha extends Circle {

    public Ficha(int xPos,int yPos, String color) {
        super(color, xPos, yPos);
    }

    public void mover(int x, int y) {
            moveHorizontal(x);
            moveVertical(y);
    }
}