package au.com.vocus.elastictool.schema;

import org.json.simple.JSONObject;

public class Shards {
	private Long total;
	private Long successful;
	private Long failed;
	
	public Shards(JSONObject json) {
		total = (Long)json.get("total");
		successful = (Long)json.get("successful");
		failed = (Long)json.get("failed");
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @return the successful
	 */
	public Long getSuccessful() {
		return successful;
	}

	/**
	 * @return the failed
	 */
	public Long getFailed() {
		return failed;
	}
}
