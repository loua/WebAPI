package example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

@javax.ws.rs.ext.Provider
@javax.ws.rs.Consumes("application/json")
@javax.ws.rs.Produces("application/json")
public class WorkflowMessageEntityProvider implements MessageBodyReader<WorkflowMessage>,
		MessageBodyWriter<Object> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return WorkflowMessage.class == type;
	}

	@Override
	public WorkflowMessage readFrom(Class<WorkflowMessage> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException {
		JsonReader reader = Json.createReader(entityStream);
		JsonObject messageBody = reader.readObject();
		return new WorkflowMessage(messageBody);
	}

	@Override
	public long getSize(Object jsonObject, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return WorkflowMessage.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(Object message, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException {
		entityStream.write(message.toString().getBytes());
	}
}