import java.util.List;

public abstract class Nave {
    public Nave() {
    }
    public abstract int tripulantes();
    public abstract List<Defensa> tipoDeDefensa();
    public abstract List<Arma> conjuntoDeArmas();
    public abstract List<Propulsion> conjuntoDePropulsion();
}
