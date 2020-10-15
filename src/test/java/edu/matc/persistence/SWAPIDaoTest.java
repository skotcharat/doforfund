package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SWAPIDaoTest {

    @Test
    void getResponseSuccess() throws JsonProcessingException {
        SWAPIDao daoSWAP = new SWAPIDao();
        String expectResponse = "unknown";
        assertEquals(expectResponse, daoSWAP.getResponse().getType());


    }
}