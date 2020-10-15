package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapi.WeatherObservation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class SWAPIDao {
    WeatherObservation getWeatherObservation() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://api.geonames.org/findNearByWeatherJSON?username=YING&lat=43.09841885827133&lng=-89.2733555956892");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);


        ObjectMapper mapper = new ObjectMapper();
        WeatherObservation weather = mapper.readValue(response, WeatherObservation.class);
        return weather;
    }

}
