import java.util.List;
import java.util.Scanner;

public abstract class Nave {
    String numReg;//Numero de Registro de la nave
    //Tiene un formato LNNNNLLL (L = letra, N = número)

    //Constructor Nave
    public Nave() {
        this.numReg=crearMatricula();
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
    public String numaleatorios(){
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

    public String propietario(){
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.println("Quien es el propietario?");
        nombre = sc.next();
        return nombre;
    }

    public abstract int tripulantesTotales(); //Numero de tripulantes de la nave

    public abstract List<Defensa> sistemaDeDefensa(); //Lista de las defensas de la nave

    public int getDefensaTotal() //Lista de las armas de la nave
    {
        return 0;
    }

    public int potenciaDeAtaque() //Lista de las armas de la nave
    {
        return 0;
    }

    public abstract List<Propulsion> conjuntoDePropulsion(); //Lista de tipos de propulsion de la nave

}
