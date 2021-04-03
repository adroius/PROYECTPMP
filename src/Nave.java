import java.util.List;
import java.util.Random;

public abstract class Nave {
    String numReg;
    public Nave() {
        this.numReg=crearMatricula();
        //El numero de Identificacion tiene que tener un LNNNNLLL (L = letra, N = numero)
    }
    
    public String crearMatricula(){
        String s="";
        s+=generarPalabra(1);
        s+="-";
        s+=numaleatorios();
        s+="-";
        s+=generarPalabra(3);
        return s;
    }

    public String numaleatorios(){
        int numero = (int)(Math.random()*10000+1000);
        return String.valueOf(Math.abs(numero));
    }

    public String generarPalabra(int cantidad){
        String palabra = "";
        for (int i=0; i<cantidad; i++){
            int codigoAscii = (int)Math.floor(Math.random()*(122 -
                    97)+97);
            palabra = palabra + (char)codigoAscii;
        }
        return palabra;
    }

    public abstract int tripulantes(); //Numero de tripulantes de la nave
    public abstract List<Defensa> tipoDeDefensa(); //Lista de las defensas de la nave
    public abstract List<Arma> conjuntoDeArmas(); //Lista de las armas de la nave
    public abstract List<Propulsion> conjuntoDePropulsion(); //Lista de tipos de propulsion de la nave
    public abstract int numeroDeDefensasMax();


    @Override
    public String toString() {
        return "numidentificacion=" + numReg;
    }
}
