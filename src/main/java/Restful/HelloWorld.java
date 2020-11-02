package Restful;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/greeting")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")

    public Response getMessage() {
        // Return a simple message
        String output = "Hello World";
        //status(200) mean everything ok
        // build restful  response and sent it back
        return Response.status(200).entity(output).build();
    }
}