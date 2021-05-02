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

    Carguero Nave;

    @BeforeEach
    void setUp(){
    Nave = new Carguero(60,100,1,1,1,1);
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
    void conjuntoDeArmas() {
        List<Arma> resultado = Nave.conjuntoDeArmas();

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