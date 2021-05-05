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

    @BeforeEach
    void setUp() {
        int tipoProp[] = new int[]{1,2};
        int tipoArma[]= new int[]{1,2};
        int potenciaArma[] = new int[] {100, 200};
        Nave = new Caza(1, 2, 2, tipoProp, tipoArma, potenciaArma);
    }

    @Test
    void tripulantesTotales() {
        //Introducir 1
        int resultado = Nave.tripulantesTotales(1);
        assertEquals(1, resultado);

        //Introducir cualquier numero excepto 1
        resultado = Nave.tripulantesTotales(3);
        assertEquals(1,resultado);
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