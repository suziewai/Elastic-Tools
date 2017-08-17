package au.com.vocus.elastictool.schema;

import org.json.simple.JSONObject;

public class ElasticResponse<T extends ElasticRecord> {

	private Long took;
	private Boolean timed_out;
	private Shards _shards;
	private Hits<T> hits;
	
	public ElasticResponse(JSONObject json) {
		
		took = (Long) json.get("took");
		timed_out = (Boolean)json.get("timed_out");
		_shards = new Shards((JSONObject)json.get("_shards"));
		hits = new Hits<T>((JSONObject)json.get("hits"));
	}

	/**
	 * @return the took
	 */
	public Long getTook() {
		return took;
	}

	/**
	 * @return the timed_out
	 */
	public boolean isTimed_out() {
		return timed_out;
	}

	/**
	 * @return the _shards
	 */
	public Shards getShards() {
		return _shards;
	}

	/**
	 * @return the hits
	 */
	public Hits<T> getHits() {
		return hits;
	}
}
