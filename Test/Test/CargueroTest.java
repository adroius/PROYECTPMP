package Test;

import Proyecto.Arma;
import Proyecto.Carguero;
import Proyecto.Defensa;
import Proyecto.Escudo;
import Proyecto.Blindaje;
import Proyecto.Propulsion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CargueroTest {

    private Carguero Nave;

    @BeforeEach
    void setUp(){
        int propArray[] =new int[]{1};
        Nave = new Carguero(100,100,1,100,
                            1, propArray);
    }

    //Test tripulantes()
    @Test
    void tripulantesTotales() {
        int tripulantes = 50;
        int resultado = Nave.tripulantesTotales(tripulantes);

        assertEquals(tripulantes, resultado);
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
        assertEquals(1000, Nave.getDefensaTotal());
    }

    //Test conuntoDeArmas()
    @Test
    //No importan los numero que entroduzcamos, debe devolver null
    void conjuntoDeArmas() {

        int numero = 2;
        int tipoArma[] = new int[] {1, 3};
        int potenciaArma[] = new int[]{100, 200};
        List<Arma> resultado = Nave.conjuntoDeArmas(numero, tipoArma, potenciaArma);

        assertNull(resultado);
    }

    //Test potenciaDeAtaque()
    @Test
    void potenciaDeAtaque() {
        int resultado = Nave.potenciaDeAtaque();

        assertEquals(0, resultado);
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

    //Test carga()
    @Test
    void carga() {
        int carga = 5000;
        int resultado = Nave.carga(carga);

        assertEquals(carga, resultado);
    }

}