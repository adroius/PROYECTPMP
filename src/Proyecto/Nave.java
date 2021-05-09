package Proyecto;

import java.util.List;
import java.util.Scanner;

public abstract class Nave {
    String numReg;//Numero de Registro de la nave
    //Tiene un formato LNNNNLLL (L = letra, N = número)

    //Constructor Nave
    public Nave() {
        this.numReg=crearMatricula();
    }

    public int numeroIntroducido(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //Crear el numero de Registro (Formato LNNNNLLL)
    public String crearMatricula(){
        String s="";
        s+=generarPalabra(1);
        s+="-";
        s+=numaleatorios();
        s+="-";
        s+=generarPalabra(3);
        return s;
    }

    //Parte numerica del Numero de Registro
    public static String numaleatorios(){
        int numero = (int)(Math.random()*10000+1000);
        return String.valueOf(Math.abs(numero));
    }

    //Parte literal del Numero de Registro
    public String generarPalabra(int cantidad){
        String palabra = "";
        for (int i=0; i<cantidad; i++){
            int codigoAscii = (int)Math.floor(Math.random()*(122 -
                    97)+97);
            palabra = palabra + (char)codigoAscii;
        }
        return palabra;
    }

    //Absorcion de Danio Total de la Nave
    public int getDefensaTotal()
    {
        return 0;
    }

    //Numero de tripulantes de la nave
    public abstract int tripulantesTotales(int tripulantes);

    //Lista de las defensas de la nave
    public abstract List<Defensa> sistemaDeDefensa(int tipoDef, int varIntroducir);

    //Danio que producen las armas de la nave
    public int potenciaDeAtaque()
    {
        return 0;
    }

    //Lista de Armas de la nave
    public abstract List<Arma> conjuntoDeArmas(int numeroArmas, int tipoArmas[], int potenciaArmas[]);

    //Lista de tipos de propulsion de la nave
    public abstract List<Propulsion> conjuntoDePropulsion(int cantidadProp, int tipoProp[]);

}
