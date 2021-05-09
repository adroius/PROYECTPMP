package Test;

import Proyecto.Escudo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EscudoTest {
    private Escudo escudo;

    @BeforeEach
    void setUp(){
        escudo = new Escudo(300);
    }
    @Test
    void energiaRequerida() {
        int energia = 500;
        assertEquals(energia, escudo.energiaRequerida(energia));
    }

    @Test
    void danioQueAbsorbe() {
        //escudo(300)
        assertEquals(3000, escudo.danioQueAbsorbe());
    }

    @Test
    void testToString() {
        //escudo(300)
        assertEquals("Escudo: Energia requerida= " + 300 +
                "\nDaño Absorbido= " + 3000,
                escudo.toString());
    }
}