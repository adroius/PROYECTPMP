import java.util.List;

public abstract class Nave {
    public Nave() {
    }

    //Hay que añadir un numero de registro!
    public abstract int tripulantes(); //Numero de tripulantes de la nave
    public abstract List<Defensa> tipoDeDefensa(); //Lista de las defensas de la nave
    public abstract List<Arma> conjuntoDeArmas(); //Lista de las armas de la nave
    public abstract List<Propulsion> conjuntoDePropulsion(); //Lista de tipos de propulsion de la nave
}
