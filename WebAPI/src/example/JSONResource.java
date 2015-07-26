package example;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/json")
public class JSONResource {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createSignedJwt(String jsonObj, @Context ServletContext ctx) {
		System.out.println("String jsonObj: " + jsonObj);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode jn = mapper.readValue(jsonObj, JsonNode.class);
			String value = jn.findValue("test").textValue();
			String foo = jn.get("complex").get("foo").textValue();
			System.out.println(value);
			System.out.println(foo);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.ok().entity(jsonObj).build();
		
	}
}
