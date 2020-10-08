package edu.matc.persistence;

import org.junit.jupiter.api.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://api.geonames.org/postalCodeLookupJSON?postalcode=53718&country=US&username=ying");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("{\"postalcodes\":[{\"adminCode2\":\"025\",\"adminCode1\":\"WI\",\"adminName2\":\"Dane\",\"lng\":-89.2733555956892,\"countryCode\":\"US\",\"postalcode\":\"53718\",\"adminName1\":\"Wisconsin\",\"placeName\":\"Madison\",\"lat\":43.09841885827133}]}", response);
    }
}