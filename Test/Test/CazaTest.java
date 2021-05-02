package Test;

import Proyecto.Arma;
import Proyecto.Caza;
import Proyecto.Defensa;
import Proyecto.Propulsion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CazaTest {
    Caza Nave;

    @Test
    void tripulantesTotales() {

        int resultado = Nave.tripulantesTotales(1);
        assertEquals(1, resultado);

        resultado = Nave.tripulantesTotales(6);
        assertEquals(1, resultado);


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