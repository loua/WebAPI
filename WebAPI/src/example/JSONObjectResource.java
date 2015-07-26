package example;

import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/jsonobj")
public class JSONObjectResource {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createSignedJwt(JsonObject jsonObj,
			@Context ServletContext ctx) {

		System.out.println(jsonObj);
		System.out.println(jsonObj.getString("test"));
		System.out.println(jsonObj.getJsonObject("complex").getString("foo"));

		return Response.ok().entity(jsonObj).build();
	}

}
