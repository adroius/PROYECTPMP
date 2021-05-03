package Test;

import Proyecto.Arma;
import Proyecto.Destructor;
import Proyecto.Defensa;
import Proyecto.Propulsion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class DestructorTest {

    Destructor Nave;

    @Test
    void tripulantesTotales() {
        int tripulantes = 30;
        int resultado = Nave.tripulantesTotales(tripulantes);
        assertEquals (tripulantes, resultado);
    }

    @Test
    void sistemaDeDefensa() {
    }

    @Test
    void conjuntoDeArmas() {
    }

    @Test
    void getDefensaTotal() {
    }

    @Test
    void potenciaDeAtaque() {
    }

    @Test
    void conjuntoDePropulsion() {
    }

    @Test
    void testToString() {
    }
}