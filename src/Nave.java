import java.util.List;

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

    public abstract int tripulantes(); //Numero de tripulantes de la nave
    public abstract List<Defensa> tipoDeDefensa(); //Lista de las defensas de la nave
    public abstract List<Arma> conjuntoDeArmas(); //Lista de las armas de la nave
    public abstract List<Propulsion> conjuntoDePropulsion(); //Lista de tipos de propulsion de la nave
    public abstract int numeroDeDefensasMax(); //Numero máximo de Defensas de la nave
    public abstract List<Nave> conjuntoDeNaves();

}
