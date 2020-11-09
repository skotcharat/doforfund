package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/greeting")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    @Path("/{param}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces({"text/plain"})
    public Response getMessageText(@PathParam("param") String msg) {
        // Return a simple message
        String outputString = "Hello(text): "+ msg;
        return Response.status(200).entity(outputString).build();
    }

    // The Java method will process HTTP GET requests
    @GET
    @Path("/{param}")
    // The Java method will produce content identified by the MIME Media type "text/html"
    @Produces({"text/html"})
    public Response getMessageHTML(@PathParam("param") String msg) {

        String outputHtml = "<html><body><h1>Hello(HTML): "+ msg + "</h1></body></html>";
        return Response.status(200).entity(outputHtml).build();
    }

    // The Java method will process HTTP GET requests
    @GET
    @Path("/{param}")
    // The Java method will produce content identified by the MIME Media type "application/json"
    @Produces({"application/json"})
    public Response getMessageJason(@PathParam("param") String msg) {
        String outputJason = "{\"Hello(Jason)\":\"" + msg + "\"}";
        return Response.status(200).entity(outputJason).build();
    }
}
