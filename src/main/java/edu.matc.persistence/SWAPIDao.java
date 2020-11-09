package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.api.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class SWAPIDao {
    Response1 getResponseDao() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://api.geonames.org/postalCodeSearchJSON?postalcode=53718&country=US&username=ying");
        //WebTarget target = client.target("https://petstore.swagger.io/v2/user/login?username=ying&password=kot");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Response1 responseAPI = null;
        try {
            responseAPI = mapper.readValue(response, Response1.class);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return responseAPI;


    }
}
