package Test;

import Proyecto.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CazaTest {
    private Caza Nave;

    @BeforeEach
    void setUp() {
        int tipoProp[] = new int[]{1,2};
        int tipoArma[]= new int[]{1,3};
        int potenciaArma[] = new int[] {100, 200};
        Nave = new Caza(1, 50, 2, tipoProp,
                        tipoArma, potenciaArma);
    }

    //Tests tripulantes()
    @Test
    void tripulantesTotalesIntroducirUno() {
        int resultado = Nave.tripulantesTotales(1);
        assertEquals(1, resultado);
    }

    @Test
    void tripulantesTotalesNoIntroducirUno(){
        int resultado = Nave.tripulantesTotales(5);
        assertEquals(1, resultado);
    }

    //Tests sistemaDeDefensa()
    @Test
    void sistemaDeDefensaEscudo() {
        List<Defensa> resultado = Nave.sistemaDeDefensa(1, 100);
        List<Defensa> expected = new ArrayList<>();
        expected.add(new Escudo(100));
        assertEquals(expected.toString(), resultado.toString());
    }

    @Test
    void sistemaDeDefensaBlindaje() {
        List<Defensa> resultado = Nave.sistemaDeDefensa(2, 3);
        List<Defensa> expected = new ArrayList<>();
        expected.add(new Blindaje(3));
        assertEquals(expected.toString(), resultado.toString());
    }

    @Test
    void sistemaDeDefensaTipoMenorUno(){
        assertThrows(IllegalStateException.class, ()->{
            Nave.sistemaDeDefensa(0, 100);
        });
    }

    @Test
    void sistemaDeDefensaTipoMayorDos(){
        assertThrows(IllegalStateException.class, ()->{
            Nave.sistemaDeDefensa(3, 100);
        });
    }


    //Test getDefensaTotal()
    @Test
    void getDefensaTotal() {
        //Nave -> tipoDef = 1, varIntroDef = 100
        assertEquals(500, Nave.getDefensaTotal());
    }

    //Tests conjuntoDeArmas()
    @Test
    void conjuntoDeArmasCantMayorDos() {
        int ArrayArmas[] = new int[]{1, 2};
        assertThrows(IllegalStateException.class, ()->{
           Nave.conjuntoDeArmas(3, ArrayArmas, ArrayArmas);
        });
    }
    @Test
    void conjuntoDeArmasCantMenorDos() {
        int ArrayArmas[] = new int[]{1, 2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDeArmas(1, ArrayArmas, ArrayArmas);
        });
    }

    //Test potenciaDeAtaque
    @Test
    void potenciaDeAtaque() {
        //Nave -> tipoArma = {1, 3}, potenciaArmas = {100, 200}
        int resultado = Nave.potenciaDeAtaque();
        assertEquals(300 ,resultado);
    }

    //Tests conjuntoDePropulsion()
    @Test
    void conjuntoDePropulsionCantidadMenorUno() {
        int tipoProp[] = new int[] {1,2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDePropulsion(0,tipoProp);
        });
    }

    @Test
    void conjuntoDePropulsionCantidadMayorDos() {
        int tipoProp[] = new int[] {1,2};
        assertThrows(IllegalStateException.class, ()->{
            Nave.conjuntoDePropulsion(3,tipoProp);
        });
    }

    @Test
        //Comprobar que la lista de Propulsion tiene los elementos que debe (1)
    void conjuntoDePropulsionCantidadUno() {
        int tipoProp[] = new int[]{0};
        List<Propulsion> resultado = Nave.conjuntoDePropulsion(1, tipoProp);
        assertEquals(1, resultado.size());
    }

    @Test
        //Comprobar que la lista de Propulsion tiene los elementos que debe (2)
    void conjuntoDePropulsionCantidadDos() {
        int tipoProp[] = new int[]{0, 2};
        List<Propulsion> resultado = Nave.conjuntoDePropulsion(2, tipoProp);
        assertEquals(2, resultado.size());
    }

}