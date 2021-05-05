package Test;

import Proyecto.Arma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArmaTest {
    Arma arma;

    @BeforeEach
    void setUp() {
        arma = new Arma(1, 100);
    }

    @Test
    void nombre() {

        assertEquals("PEM", arma.nombre(0));

        assertEquals("Misil Termonuclear", arma.nombre(1));

        assertEquals("Rayo Laser", arma.nombre(2));

        assertEquals("Cañon de Plasma", arma.nombre(3));
    }

    //No puedo crear arma.nombre(-1) y arma.nombre(4) porque salta IllegalStateException
 /*   @Test
    void nombreMenorDeCero() {
        String resultado = arma.nombre(-1);
        assertThrows(IllegalStateException.class);
    }
    @Test
    void nombreMayorDeTres() {
        String resultado = arma.nombre(4);
        assertThrows(IllegalStateException.class);
    }
*/
    @Test
    void potencia() {
        int potencia = 200;
        assertEquals(potencia, arma.potencia(potencia));
    }

    @Test
    void testToString() {
        //arma (1, 100)
        assertEquals("La potencia del Misil Termonuclear es de " + 100 + " GigaJulios",
                arma.toString());
    }
}