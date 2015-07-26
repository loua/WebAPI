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
public class JSONEntityProvider implements MessageBodyReader<JsonObject>,
		MessageBodyWriter<Object> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return JsonObject.class == type;
	}

	@Override
	public JsonObject readFrom(Class<JsonObject> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException {
		JsonReader reader = Json.createReader(entityStream);
		JsonObject result = reader.readObject();
		return result;
	}

	@Override
	public long getSize(Object jsonObject, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return JsonObject.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(Object jsonObject, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException {
		entityStream.write(jsonObject.toString().getBytes());
	}
}