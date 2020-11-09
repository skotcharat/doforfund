package edu.matc.persistence;
import com.api.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SWAPIDaoTest {

    @Test
    void getResponseSuccess() throws JsonProcessingException {
        SWAPIDao daoSWAP = new SWAPIDao();

        for (PostalCodesItem code : daoSWAP.getResponseDao().getPostalCodes()){
            assertEquals("Madison", code.getPlaceName());
        }

    }
}