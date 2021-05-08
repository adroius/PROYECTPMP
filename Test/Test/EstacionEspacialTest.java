package Test;

import Proyecto.Arma;
import Proyecto.EstacionEspacial;
import Proyecto.Defensa;
import Proyecto.Propulsion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class EstacionEspacialTest {

    private EstacionEspacial Nave;

    @BeforeEach
    void setUp(){
        int tipoProp[] = new int[] {1, 2};
        int tipoDef[] = new int[] {1, 2, 1};
        int varIntroDef[] = new int[]{100, 3, 200};
        Nave = new EstacionEspacial(100,400, 3,
                                    tipoDef, varIntroDef, 2, tipoProp);
    }

    //Test tripulantesTotales()
    @Test
    void tripulantesTotales() {
        int tripulantes = 50;
        int resultado = Nave.tripulantesTotales(tripulantes);
        assertEquals(tripulantes, resultado);
    }

    //Test pasajerosMax()
    @Test
    void pasajerosMax() {
        int pasajerosMaximos = 50;
        int resultado = Nave.pasajerosMax(pasajerosMaximos);
        assertEquals(pasajerosMaximos,resultado);
    }

    //Tests Cantidad Defensas
    @Test
    void cantidadDefensasMenorUno(){
        int Array[] = new int[]{2, 3};
        assertThrows(IllegalStateException.class, ()->{
           Nave = new EstacionEspacial(10, 30, 0,
                                        Array, Array, 2, Array);
        });
    }

    @Test
    void cantidadDefensasMayorTres(){
        int Array[] = new int[]{2, 3};
        assertThrows(IllegalStateException.class, ()->{
            Nave = new EstacionEspacial(10, 30, 4,
                    Array, Array, 2, Array);
        });
    }

    //Tests sistemaDeDefensa()
    @Test
    void sistemaDeDefensa() {
    }

    //Test getDefensaTotal()
    @Test
    void getDefensaTotal() {
        //Nave -> cantidadDef = 3, tipoDef = {1, 2, 1}, varIntroVar = {100, 3, 200}
        int resultado = Nave.getDefensaTotal();
        assertEquals(3000 + 321091, resultado);
    }

    //Test conjuntoDeArmas()
    @Test
    //No importa lo que introduzcamos debe devolver null
    void conjuntoDeArmas() {
        int tipoArma[] = new int[] {1, 5};
        int potenciaArma[] = new int[] {200, 100};
        List<Arma> resultado = Nave.conjuntoDeArmas(3, tipoArma,potenciaArma);
        assertNull(resultado);
    }

    //Test potenciaDeAtaque()
    @Test
    void potenciaDeAtaque() {
        int resultado = Nave.potenciaDeAtaque();
        assertEquals(0, resultado);
    }

    //Tests conjuntoDePropulsion()
    @Test
    void conjuntoDePropulsionCantidadMenorUno() {
        int tipoProp[] = new int[] {1,2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDePropulsion(0,tipoProp);
        });
    }

    @Test
    void conjuntoDePropulsionCantidadMayorDos() {
        int tipoProp[] = new int[] {1,2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDePropulsion(3,tipoProp);
        });
    }

    @Test
        //Comprobar que la lista de Propulsion tiene los elementos que debe (1)
    void conjuntoDePropulsionCantidadUno() {
        int tipoProp[] = new int[]{0};
        List<Propulsion> resultado = Nave.conjuntoDePropulsion(1, tipoProp);
        assertEquals(1, resultado.size());
    }

    @Test
        //Comprobar que la lista de Propulsion tiene los elementos que debe (2)
    void conjuntoDePropulsionCantidadDos() {
        int tipoProp[] = new int[]{0, 2};
        List<Propulsion> resultado = Nave.conjuntoDePropulsion(2, tipoProp);
        assertEquals(2, resultado.size());
    }

    //Test conjuntoNaves()
    @Test
    void conjuntoNaves() {
    }

}