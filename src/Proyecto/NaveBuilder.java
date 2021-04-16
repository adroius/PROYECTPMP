package Proyecto;

import java.util.Scanner;

//Clase Proyecto.NaveBuilder hereda de Proyecto.Nave
public abstract class NaveBuilder extends Nave{

    //Escoger que clase de nave se va a crear
    public static Nave CrearNave(){
        Nave n;
        System.out.println("Que nave desea registrar:");
        System.out.println("1) Proyecto.Caza");
        System.out.println("2) Proyecto.Destructor");
        System.out.println("3) Proyecto.Carguero");
        System.out.println("4) Estacion espacial");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        //Seleccion del tipo de Proyecto.Nave que se va a registrar
        switch (s) {
            case 1: {
                System.out.println("Ha seleccionada Proyecto.Caza");
                n = new Caza(); //Constructor de Proyecto.Caza
                break;
            }
            case 2: {
                System.out.println("Ha seleccionada Proyecto.Destructor");
                n = new Destructor(); //Constructor de Proyecto.Destructor
                break;
            }
            case 3: {
                System.out.println("Ha seleccionada Proyecto.Carguero");
                n = new Carguero(); //Constructor de Proyecto.Carguero
                break;
            }
            case 4: {
                System.out.println("Ha seleccionada Estacion Espacial");
                n = new EstacionEspacial(); //Constructor de Proyecto.EstacionEspacial
                break;
            }
            //Valor introducido incorrecto
            default:
                throw new IllegalStateException("Unexpected value: " + s); //Ha introducido un numero incorrecto
        }
        return n;
    }

    //Elegir que nave se va a crear para especie Proyecto.Kromagg sin LicenciaEspecial
    public static Nave CrearNaveEspecial(){
        Nave n;
        System.out.println("Que nave desea registrar:");
        System.out.println("1) Proyecto.Caza");
        System.out.println("2) Proyecto.Carguero");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        //Seleccion del tipo de Proyecto.Nave que se va a registrar
        switch (s) {
            case 1: {
                System.out.println("Ha seleccionada Proyecto.Caza");
                n = new Caza(); //Constructor de Proyecto.Caza
                break;
            }
            case 2: {
                System.out.println("Ha seleccionada Proyecto.Carguero");
                n = new Carguero(); //Constructor de Proyecto.Carguero
                break;
            }
            //Valor introducido incorrecto
            default:
                throw new IllegalStateException("Unexpected value: " + s); //Ha introducido un numero incorrecto
        }
        return n;
    }
}
