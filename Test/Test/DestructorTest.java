package Test;

import Proyecto.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class DestructorTest {

    private Destructor Nave;
    @BeforeEach
    void setUp(){
        int TArray[] =new int[]{1, 2};
        Nave = new Destructor(60,2,1,2,TArray,2,TArray,TArray);
    }
    @Test
    void tripulantesTotales() {
        int tripulantes = 30;
        int resultado = Nave.tripulantesTotales(tripulantes);
        assertEquals (tripulantes, resultado);
    }

    @Test
    void sistemaDeDefensaCantMenorUno() {
        assertThrows(IllegalStateException.class, ()->{
            Nave.sistemaDeDefensa(0, 1);
        });
    }
    @Test
    void sistemaDeDefensaCantMayorDos() {
        assertThrows(IllegalStateException.class, ()->{
            Nave.sistemaDeDefensa(3, 1);
        });
    }
    @Test
    void conjuntoDePropulsionCantidadMenorUno() {
        int TArray[] = new int[] {1,2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDePropulsion(0,TArray);
        });
    }
    @Test
    void conjuntoDePropulsionCantidadMayorDos() {
        int TArray[] = new int[] {1,2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDePropulsion(3,TArray);
        });
    }
    @Test
    void conjuntoDeArmasCantidadMenorUno() {
        int TArray[] = new int[] {1,2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDeArmas(0,TArray,TArray);
        });
    }
    @Test
    void tipoArma() {
        int TArray[] = new int[] {1,2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDeArmas(0,TArray,TArray);
        });
    }
//    @Test
//    void getDefensaTotal() {
//    }

//    @Test
//    void potenciaDeAtaque() {
//        int resultado = Nave.potenciaDeAtaque();
//
//        assertEquals(0, resultado);
//    }

    @Test
    void testToString() {
    }
}