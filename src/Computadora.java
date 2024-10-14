public class Computadora {
    private String marca;
    private String modelo;
    private long codigoBarras;
    private double precioTotal;
    private double porcentajeAumento;
    private double montoFinal;
    private String[][] componentes;

    public Computadora() {
        this.componentes = new String[0][0];
    }

    public void setComponentes(int filas, int columnas) {
        this.componentes = new String[filas][columnas];
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPorcentajeAumento() {
        return porcentajeAumento;
    }

    public void setPorcentajeAumento(double porcentajeAumento) {
        this.porcentajeAumento = porcentajeAumento;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getComponentes() {
        return componentes;
    }

    public void setComponente(int fila, int columna, String valor) {
        this.componentes[fila][columna] = valor;
    }
}




