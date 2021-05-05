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

    EstacionEspacial Nave;

    @BeforeEach
    void setUp(){
        int tipoProp[] = new int[] {1, 2};
        Nave = new EstacionEspacial(100,400, 3, 2, 2, tipoProp);
    }

    @Test
    void tripulantesTotales() {
        int tripulantes = 50;
        int resultado = Nave.tripulantesTotales(tripulantes);
        assertEquals(tripulantes, resultado);
    }

    @Test
    void pasajerosMax() {
        int pasajerosMaximos = 50;
        int resultado = Nave.pasajerosMax(pasajerosMaximos);
        assertEquals(pasajerosMaximos,resultado);
    }

    @Test
    void sistemaDeDefensa() {
    }

    @Test
    //No importa lo que introduzcamos debe devolver null
    void conjuntoDeArmas() {
        int tipoArma[] = new int[] {1, 5};
        int potenciaArma[] = new int[] {200, 100};
        List<Arma> resultado = Nave.conjuntoDeArmas(3, tipoArma,potenciaArma);
    }

    @Test
    void conjuntoDePropulsion() {
    }

    @Test
    void getDefensaTotal() {
    }

    @Test
    void potenciaDeAtaque() {
    }

    @Test
    void conjuntoNaves() {
    }

    @Test
    void testToString() {
    }
}