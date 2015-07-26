package example;

import javax.json.JsonObject;

public class WorkflowMessage {

	private JsonObject body;

	public WorkflowMessage(JsonObject body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return body.toString();
	}
}
