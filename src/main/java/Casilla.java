
public class Casilla extends Square {

    private String colorDeLaFicha = "";
    private int fila;
    private char columna;
    private boolean estaOcupado;

    public Casilla(String colorDeLaFicha, int fila, char columna, int xPos, int yPos) {
        super(colorDeLaFicha, xPos, yPos);
        this.colorDeLaFicha = colorDeLaFicha;
        this.fila = fila;
        this.columna = columna;
        estaOcupado = false;
        makeVisible();
    }

    public void ocuparCasilla(String colorDeLaFicha) {
        estaOcupado = true;
        this.colorDeLaFicha = colorDeLaFicha; 
    }

    public void desocuparCasilla(String colorDeLaFicha) {
        estaOcupado = false;
        colorDeLaFicha = "";
    }

    public String getColorDeLaFicha() {
        return colorDeLaFicha;
    }

    public void setColorDeLaFicha(String colorDeLaFicha) {
        this.colorDeLaFicha = colorDeLaFicha;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public boolean isEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public void setFicha(Ficha ficha) {
    }
}
