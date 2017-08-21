package au.com.vocus.elastictool.schema;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ElasticRecord {
	private String _index;
	private String _type;
	private String _id;
	private Long score;
	protected JSONObject _source;
	
	public void setMembers(JSONObject json) {
		_index = (String)json.get("_index");
		_type = (String)json.get("_type");
		_id = (String)json.get("_id");
		score = (Long)json.get("score");
		_source = (JSONObject)json.get("_source");
	}

	/**
	 * @return the _index
	 */
	public String get_index() {
		return _index;
	}

	/**
	 * @return the _type
	 */
	public String get_type() {
		return _type;
	}

	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * @return the score
	 */
	public Long getScore() {
		return score;
	}

	/**
	 * @return the _source
	 */
	public JSONObject get_source() {
		return _source;
	}
}
