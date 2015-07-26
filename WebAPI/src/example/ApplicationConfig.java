package example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(JSONResource.class,
				JSONObjectResource.class,
				WorkflowResource.class,
				WorkflowMessageEntityProvider.class,
				JSONEntityProvider.class));
	}
}
