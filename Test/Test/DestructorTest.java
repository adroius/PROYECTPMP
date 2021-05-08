package Test;

import Proyecto.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class DestructorTest {
    private Destructor Nave;
    @BeforeEach
    void setUp(){
        int tipoProp[] =new int[]{1, 2};
        int tipoArma[]= new int[]{2,3};
        int potenciaArmas[] = new int[] {1000, 400};
        Nave = new Destructor(60,2,1,2,tipoProp,2,tipoArma,potenciaArmas);
    }

    @Test
    void tripulantesTotales() {
        int tripulantes = 30;
        int resultado = Nave.tripulantesTotales(tripulantes);
        assertEquals (tripulantes, resultado);
    }

    @Test
    void sistemaDeDefensaEscudo() {
        List<Defensa> resultado = Nave.sistemaDeDefensa(1, 300);
        List<Defensa> expected = new ArrayList<>();
        expected.add(new Escudo(300));
        assertEquals(expected.toString(), resultado.toString());
    }

    @Test
    void sistemaDeDefensaBlindaje() {
        List<Defensa> resultado = Nave.sistemaDeDefensa(2, 4);
        List<Defensa> expected = new ArrayList<>();
        expected.add(new Blindaje(4));
        assertEquals(expected.toString(), resultado.toString());
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
    void potenciaDeAtaque() {
        //Nave -> tipoArma = {2, 3}, potenciaArmas = {1000, 200}
        int resultado = Nave.potenciaDeAtaque();
        assertEquals(1400 ,resultado);
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