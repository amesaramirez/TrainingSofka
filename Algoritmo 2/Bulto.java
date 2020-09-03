
//Declaramos clase bulto
public class Bulto {
    //Declaramos variables
    private final static double cargamaxima=500;
    private double peso;
    private double precio;

    //Declaramos constructores
    public Bulto(){}

    public Bulto(double p, double pre){
        this.peso=p;
        this.precio=pre;
    }

    //Declaramos accesores de métodos
    public double getPeso() {
        return peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
