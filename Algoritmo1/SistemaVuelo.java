/***
 * Autor: Alejandro Mesa Ramírez
 * Fecha: 3/09/2020
 * ***/

//Improtamos la libreria para los input
import java.util.Scanner;

//Definimos la clase principal
public class SistemaVuelo {
    //Definimos el método main

    public static void main(String[] args) {
        //Declaramos variables
        String d="",distancia="",dias="";
        Scanner input=new Scanner(System.in);
        double preciokm=35.00;
        boolean b1=true;

        //Lógica de negocio
        while(b1==true){
            System.out.println("||||| Bienvenido al sistema de precios de vuelos de Sofka |||||");
            System.out.println("Desea adquirir un tiquete?, s=Si n=No");
            d=input.next();
            if(d.equals("s")){
                System.out.println("Porfavor indice la distancia a recorrer en (Km):");
                distancia=input.next();
                //La función a continuación es una manera sencilla de verificar valores numericos
                if(distancia.chars().allMatch(Character::isDigit)){
                    System.out.println("Por favor ingrese el número de dias de estancia:");
                    dias=input.next();
                    if(dias.chars().allMatch(Character::isDigit)){
                        if(Double.parseDouble(distancia) > 1000 && Double.parseDouble(dias)>7){
                            System.out.println("El precio de su tiquete es: "+((Double.parseDouble(distancia)*preciokm)-(Double.parseDouble(distancia)*preciokm*0.3)) +" COP");
                            System.out.println("Gracias por utilizar nuestro servicio!");
                            System.out.println("");
                        }
                        else{
                            System.out.println("El precio de su tiquete es: "+Double.parseDouble(distancia)*preciokm +" COP");
                            System.out.println("Gracias por utilizar nuestro servicio!");
                            System.out.println();
                        }
                    }
                    else{
                        System.out.println("Usted ha ingresado un valor incorrecto!");
                        System.out.println("Por favor intentelo de nuevo");
                        System.out.println("");
                    }
                }
                else{
                    System.out.println("Usted ha ingresado un valor incorrecto!");
                    System.out.println("Por favor intentelo de nuevo");
                    System.out.println("");
                }
            }
            else if(d.equals("n")){
                System.out.println("Entidido, esperamos vuelva pronto");
                b1=false;
            }
            else
            {
                System.out.println("Atención! cebe ingresar s o n para proceder");
                System.out.println("");
            }

        }

    }
}
