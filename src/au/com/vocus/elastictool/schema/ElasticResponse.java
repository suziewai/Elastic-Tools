package au.com.vocus.elastictool.schema;

import org.json.simple.JSONObject;

public class ElasticResponse<T extends ElasticRecord> {

	private String _scroll_id;
	private Long took;
	private Boolean timed_out;
	private Shards _shards;
	private Hits<T> hits;
	
	public ElasticResponse(JSONObject json) {
		_scroll_id = json.get("_scroll_id") == null ? null : json.get("_scroll_id").toString();
		took = (Long) json.get("took");
		timed_out = (Boolean)json.get("timed_out");
		_shards = new Shards((JSONObject)json.get("_shards"));
		hits = new Hits<T>((JSONObject)json.get("hits"));
	}

	/**
	 * @return the _scroll_id
	 */
	public String get_scroll_id() {
		return _scroll_id;
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
