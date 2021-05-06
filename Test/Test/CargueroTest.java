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
        int propArray[] =new int[]{1, 2};
        Nave = new Carguero(60,100,1,1,1, propArray);
    }

    @Test
    void tripulantesTotales() {
        int tripulantes = 50;
        int resultado = Nave.tripulantesTotales(tripulantes);

        assertEquals(tripulantes, resultado);
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

    //me no entender porque me dan error estos test, cuando miro los resultados expected y reultado son iguales.........
    @Test
    void sistemaDeDefensaEscudo() {
        List<Defensa> resultado = Nave.sistemaDeDefensa(1, 100);
        List<Defensa> expected = new ArrayList<>();
        expected.add(new Escudo(100));
        assertEquals(expected, resultado);
    }

    @Test
    void sistemaDeDefensaBlindaje() {
        List<Defensa> resultado = Nave.sistemaDeDefensa(2, 3);
        List<Defensa> expected = new ArrayList<>();
        expected.add(new Blindaje(3));
        assertEquals(expected, resultado);
    }

    @Test
    void sistemaDeDefensaMenorUno(){
        assertThrows(IllegalStateException.class, ()->{
           Nave.sistemaDeDefensa(0, 100);
        });
    }

    @Test
    void sistemaDeDefensaMayorDos(){
        assertThrows(IllegalStateException.class, ()->{
            Nave.sistemaDeDefensa(3, 100);
        });
    }

    @Test
    void getDefensaTotal() {
        int tipoProp[] = new int[]{1,1};
        Nave = new Carguero(2,200, 1, 100, 2, tipoProp);
        assertEquals(1000, Nave.getDefensaTotal());
    }

    @Test
    //No importan los numero que entroduzcamos, debe devolver null
    void conjuntoDeArmas() {

        int numero = 2;
        int tipoArma[] = new int[] {1, 3};
        int potenciaArma[] = new int[]{100, 200};
        List<Arma> resultado = Nave.conjuntoDeArmas(numero, tipoArma, potenciaArma);

        assertEquals(null, resultado);
    }

    @Test
    void potenciaDeAtaque() {
        int resultado = Nave.potenciaDeAtaque();

        assertEquals(0, resultado);
    }

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

    //@Test
    //Maldito Random
/*    void conjuntoDePropulsionCantUno() {
        int tipoProp[] = new int[]{0};
        List<Propulsion> resultado = Nave.conjuntoDePropulsion(1, tipoProp);
        List<Propulsion> expected = new ArrayList();
        expected.add(new Propulsion(0));
        assertEquals(expected, resultado);
    }
*/
    @Test
    void carga() {
        int carga = 5000;
        int resultado = Nave.carga(carga);

        assertEquals(carga, resultado);
    }

    @Test
    void testToString() {
    }
}