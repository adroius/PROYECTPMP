package Proyecto;

import java.util.Scanner;

//Clase Proyecto.Propulsion
public class Propulsion {
    String nombre;
    int velocidad;  //Velocidad sublumínica  Miles de Km/h

    //Constructor Proyecto.Propulsion
    public Propulsion() {
        this.nombre = nombre();
        this.velocidad = velSubLuminicaMax();
    }

    //Devuelve el nombre del Tipo de Proyecto.Propulsion
    public String getNombre() {
        return nombre;
    }

    //Devuelve la velocidad sublumínica de la Proyecto.Propulsion
    public int getVelocidad() {
        return velocidad;
    }

    //Escoger el tipo de Proyecto.Propulsion de la nave
    public String nombre(){
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.println("Que propulsion quiere elegir:");
        System.out.println("0) Compresor de Traza");
        System.out.println("1) Motor FTL");
        System.out.println("2) Vela Solar");
        System.out.println("3) MotorCurvatura");
        System.out.println("4) Motor Ionico");
        int modelo = sc.nextInt();

        //Deberiamos hacer un bucle para comprobar que el valor introducido es correcto
        switch (modelo) {
            case 0: {
                nombre = "Compresor de Traza";
                break;
            }
            case 1: {
                nombre = "Motor FTL";
                break;
            }
            case 2: {
                nombre = "Vela Solar";
                break;
            }
            case 3: {
                nombre = "Motor Curvatura";
                break;
            }
            case 4: {
                nombre = "Motor Ionico";
                break;
            }
            //Valor introducido erroneo
            default: throw new IllegalStateException("Unexpected value: " + modelo);
        }
        return nombre;
    }

    //Introducir la velocidad sublumínica en Miles de Km / hora
    public int velSubLuminicaMax(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la velocidad sublumínica maxima de la nave: ");
        int v = sc.nextInt();
        System.out.println("¡La velocidad maxima sera " + v + " miles de km/hora!");
        return v;
    }

    @Override
    public String toString() {
        return " Nombre = " + getNombre() +
                "\nVelocidad = " + getVelocidad() ;
    }
}
