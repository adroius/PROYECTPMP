package Test;

import Proyecto.Propulsion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropulsionTest {
    private Propulsion propulsion;

    @BeforeEach
    void setUp(){
      propulsion = new Propulsion(2);
    }

    @Test
    void getNombre() {
        propulsion = new Propulsion(0);
        assertEquals("Compresor de Traza", propulsion.getNombre());

        propulsion = new Propulsion(1);
        assertEquals("Motor FTL", propulsion.getNombre());

        propulsion = new Propulsion(2);
        assertEquals("Vela Solar", propulsion.getNombre());

        propulsion = new Propulsion(3);
        assertEquals("Motor Curvatura", propulsion.getNombre());

        propulsion = new Propulsion(4);
        assertEquals("Motor Ionico", propulsion.getNombre());

    }

    //Basados en un random, no se me ocurre una manera de hacer el test
    /*
    @Test
    void getVelocidad() {

    }
    @Test
    void velSubLuminicaMax() {
    }
    */

    @Test
    void nombre() {
        assertEquals("Compresor de Traza", propulsion.nombre(0));
        assertEquals("Motor FTL", propulsion.nombre(1));
        assertEquals("Vela Solar", propulsion.nombre(2));
        assertEquals("Motor Curvatura", propulsion.nombre(3));
        assertEquals("Motor Ionico", propulsion.nombre(4));
    }

    @Test
    void nombreMenorCero(){
        assertThrows(IllegalStateException.class, ()-> {
            propulsion.nombre(-1);
        });
    }

    @Test
    void nombreMayorCuatro(){
        assertThrows(IllegalStateException.class, ()-> {
            propulsion.nombre(5);
        });
    }

    @Test
    void testToString() {
        //propulsion(2)
        assertEquals(" Nombre = " + propulsion.getNombre() +
                            "\nVelocidad = " + propulsion.getVelocidad(),
                    propulsion.toString());
    }
}