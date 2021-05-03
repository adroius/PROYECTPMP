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
    void conjuntoDeArmas() {
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