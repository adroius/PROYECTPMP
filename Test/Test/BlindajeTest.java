package Test;

import Proyecto.Blindaje;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlindajeTest {
    private Blindaje blindaje;

    @BeforeEach
    void setUp(){
        blindaje = new Blindaje(2);
    }
    @Test
    void danioQueAbsorbe() {
        blindaje = new Blindaje(0);
        assertEquals(1832732, blindaje.danioQueAbsorbe());
        blindaje = new Blindaje(1);
        assertEquals(329473, blindaje.danioQueAbsorbe());
        blindaje = new Blindaje(2);
        assertEquals(7324823, blindaje.danioQueAbsorbe());
        blindaje = new Blindaje(3);
        assertEquals(321091, blindaje.danioQueAbsorbe());
        blindaje = new Blindaje(4);
        assertEquals(4398453, blindaje.danioQueAbsorbe());
        blindaje = new Blindaje(5);
        assertEquals(74910132, blindaje.danioQueAbsorbe());
    }

    @Test
    void materialEscogido() {
        assertEquals("Adamantium", blindaje.materialEscogido(0));
        assertEquals("Hierro", blindaje.materialEscogido(1));
        assertEquals("Plata", blindaje.materialEscogido(2));
        assertEquals("Platino", blindaje.materialEscogido(3));
        assertEquals("Oro", blindaje.materialEscogido(4));
        assertEquals("Diamante", blindaje.materialEscogido(5));
    }


    @Test
    void materialEscogidoMenorCero() {
        assertThrows(IllegalStateException.class, ()->{
            blindaje.materialEscogido(-1);
        });
    }
    @Test
    void materialEscogidoMayorCinco() {
        assertThrows(IllegalStateException.class, ()->{
            blindaje.materialEscogido(6);
        });
    }

    @Test
    void testToString() {
        //Blindaje(2)
        assertEquals("  Blindaje: " +
                "\nMaterial ='" + blindaje.materialEscogido(2) +
                "\nDanio Que Absorbe =" + blindaje.danioQueAbsorbe() +
                "\nPeso = " + blindaje.danioQueAbsorbe()*10,

                blindaje.toString());
    }
}