/***
 * Autor: Alejandro Mesa Ramírez
 * Fecha: 3/09/2020
 * ***/

//Improtamos la libreria para los input

import java.util.ArrayList;
import java.util.Scanner;


//Declaramos clase principal
public class Principal {
    //Declaramos main
    public static void main(String[] args) {
        //Declaramos lógica de negocio
        String op="";
        boolean b=true;
        boolean b2=true;
        double peso,valor;
        int cbultos=0;
        Scanner input=new Scanner(System.in);

        System.out.println("||| Bienvendio al sistema de carga para un BOING 747 |||");
        System.out.println("");
        System.out.println("Le recordamos que la carga máxima del avion son 18.000kg");
        System.out.println("También le recordamos que la carga máxima de los butlos es de 500kg");
        System.out.println("");
        ArrayList<Bulto> bultos = new ArrayList<Bulto>();
        while(b){
            valor=0;
            System.out.println("Ingrese el tamaño del bulto");
            peso=input.nextDouble();
            if(peso<=500){
                cbultos++;
                System.out.println("Bultos ingresados: "+cbultos);
                if (peso>=0 && peso <=25){
                    valor=0;
                }
                else if(peso>=26 && peso<=300){
                    valor=1500*peso;
                }
                else if(peso>=301 && peso<=500){
                    valor=2500*peso;
                }
                Bulto obj=new Bulto(peso,valor);
                //System.out.println("precio"+obj.getPrecio());
                bultos.add(obj);
                //System.out.println("Precio Actual:"+ calcularPrecio(bultos));
                //System.out.println("Peso Actual:"+ calcularPeso(bultos));
                if(calcularPeso(bultos)<=18000)
                {
                    System.out.println("Peso disponible en el avión: "+(18000-calcularPeso(bultos)));
                    System.out.println("Deseas continuar con otros bultos? s=si n=no");
                    op=input.next();
                    if(op.equals("n")){
                        b=false;
                    }

                }
                else if (calcularPeso(bultos)==18000)
                {
                    System.out.println("Haz alcansado el límite de peso para los bultos!");
                    b=false;
                }
                else{
                    System.out.println("Haz superado el límite de peso de bultos, por favor intenta de nuevo");
                    b=false;
                    b2=false;
                }
            }
            else{
                System.out.println("El peso ingresado no es permitido");
                b=false;
                b2=false;

            }

        }

        if (b2==true){
            System.out.println("Cantidad bultos en el avion: "+cbultos);
            System.out.println("Peso del bulto mas pesado: "+bultoPesado(bultos));
            System.out.println("Peso del bulto mas liviano: "+bultoLiviano(bultos));
            System.out.println("Peso promedio de los bultos: "+calcularPromedio(bultos));
            System.out.println("Ingreso en pesos: "+calcularPrecio(bultos));
            System.out.println("Ingreso en dolares:"+(calcularPrecio(bultos)*0.0002742));
        }
        else{
            System.out.println("Usted debe organizar los bultos en orden que cumpla las reglas de peso para obtener la información.");
        }



    }

    public static double calcularPrecio(ArrayList<Bulto> lista){
        double valor=0;
        for (int i=0;i<=lista.size()-1;i++){
            Bulto obj=lista.get(i);
            valor=valor+obj.getPrecio();
        }
        return valor;
    }

    public static double calcularPeso(ArrayList<Bulto> lista){
        double valor=0;
        for (int i=0;i<=lista.size()-1;i++){
            Bulto obj=lista.get(i);
            valor=valor+obj.getPeso();
        }
        return valor;
    }

    public static double bultoPesado(ArrayList<Bulto> lista){
        double valor=0;
        for (int i=0;i<=lista.size()-1;i++){
            Bulto obj=lista.get(i);
            if (obj.getPeso()>valor){
                valor=obj.getPeso();
            }

        }
        return valor;
    }

    public static double bultoLiviano(ArrayList<Bulto> lista){
        double valor=500;
        for (int i=0;i<=lista.size()-1;i++){
            Bulto obj=lista.get(i);
            if (obj.getPeso()<valor){
                valor=obj.getPeso();
            }

        }
        return valor;
    }

    public static double calcularPromedio(ArrayList<Bulto> lista){
        double valor=0;
        for (int i=0;i<=lista.size()-1;i++){
            Bulto obj=lista.get(i);
            valor=valor+obj.getPeso();
        }
        return valor/lista.size();
    }
}




