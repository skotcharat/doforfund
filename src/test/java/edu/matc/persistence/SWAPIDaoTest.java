package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SWAPIDaoTest {

    @Test
    void getPlanet() throws JsonProcessingException {
        SWAPIDao daoSWAP = new SWAPIDao();
        String expectPlanet = "Tatooine";
        assertEquals(expectPlanet, daoSWAP.getPlanet().getName());

    }
}