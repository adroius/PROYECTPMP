package Proyecto;

import java.util.Scanner;

//Clase Arma
public class Arma {

    String nombre;
    int potencia;

    //Constructor Arma
    public Arma(int modelo, int potencia) {
        this.nombre = nombre(modelo);
        this.potencia = potencia(potencia);
    }

    //Nombre del arma de la nave
    public String nombre(int modelo) {
        //Seleccion del tipo de Arma de la nave
        switch (modelo) {
            case 0:
                nombre = "PEM";
                isPEM(nombre);
                break;
            case 1:
                nombre = "Misil Termonuclear";
                isMisilTermonuclear(nombre);
                break;
            case 2:
                nombre = "Rayo Laser";
                isRayoLaser(nombre);
                break;
            case 3:
                nombre = "Cañon de Plasma";
                isCañonPlasma(nombre);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + modelo);
        }
        System.out.println("¡Ha elegido " + nombre + "!");
        return nombre;
    }

    //Introducir la potencia del Arma
    public static int potencia(int potencia) {
        System.out.println("¡La potencia de su arma será " + potencia + " !");
        return potencia;
    }


    //Guardar el tipo de arma
    private boolean isPEM(String tipoArma) {
        return tipoArma == "PEM";
    }

    private boolean isMisilTermonuclear(String tipoArma) {
        return tipoArma == "Misil Termonuclear";
    }

    private boolean isRayoLaser(String tipoArma) {
        return tipoArma == "Rayo Laser";
    }

    private boolean isCañonPlasma(String tipoArma) {
        return tipoArma == "Cañon de plasma";
    }

    @Override
    public String toString() {
        return "La potencia del " + nombre + " es de " + potencia+ " GigaJulios";
    }
}