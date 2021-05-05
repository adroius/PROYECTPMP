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
    void sistemaDeDefensa() {

    }

    @Test
    void getDefensaTotal() {
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
    void conjuntoDePropulsion() {
    }

    @Test
    void numeroDeDefensasMax(){
        //Es privado en la Clase Carguero (Tengo que mirar como se hace)
    }

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