package Proyecto;

import java.util.Scanner;

//Clase Kromagg
public class Kromagg{

    protected static boolean licencia; //LicenciaEspecial de los Kromagg
    //Constructor Kromagg introduciendo datos por pantalla
    public Kromagg() {
        int numero = licenciaMenu();
        licencia = licencia(numero);
    }

    //Constructor Kromagg sin introducir datos por pantalla
    public Kromagg(int numero){
        licencia = licencia(numero);
    }

    //Comprobar si tiene licencia
    //Esto no tiene ningun tipo de seguridad...
    protected static int licenciaMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tienes licencia?");
        System.out.println("1) Si");
        System.out.println("2) No");
        return sc.nextInt();
    }

    public static boolean licencia(int numero) {
        boolean confirmacion;
        switch (numero) {
            case 1: {
                confirmacion = true;
                break;
            }
            case 2: {
                confirmacion = false;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + numero);
        }
        
        return confirmacion;
    }

    protected static boolean getLicencia(){
        return licencia;
    }

}
