import java.util.List;
import java.util.Random;

public abstract class Nave {
    int numidentificacion;
    public Nave() {
        this.numidentificacion=Math.abs(numaleatorios());
        //El numero de Registro tiene que tener un LNNNNLLL (L = letra, N = numero)
    }


    public int numaleatorios(){
        Random r=new Random();
        return r.nextInt();
    }

    public abstract int tripulantes(); //Numero de tripulantes de la nave
    public abstract List<Defensa> tipoDeDefensa(); //Lista de las defensas de la nave
    public abstract List<Arma> conjuntoDeArmas(); //Lista de las armas de la nave
    public abstract List<Propulsion> conjuntoDePropulsion(); //Lista de tipos de propulsion de la nave
    public abstract int numeroDeDefensasMax();

    @Override
    public String toString() {
        return "numidentificacion=" + numidentificacion;
    }
}
