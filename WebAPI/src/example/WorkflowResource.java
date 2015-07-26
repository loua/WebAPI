package example;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/workflow")
public class WorkflowResource {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createWorkItem(WorkflowMessage message,
			@Context ServletContext ctx) {

		System.out.println("createWorkItem: " + message);

		return Response.ok().entity(message).build();
	}
}
