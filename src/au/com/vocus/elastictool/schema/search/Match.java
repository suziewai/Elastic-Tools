package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONObject;

public class Match implements QueryCriterion {

	private String field;
	private String match;
	
	@Override
	public String getKey() {
		return "match";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject value = new JSONObject();
		value.put(field, match);
		return value;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the match
	 */
	public String getMatch() {
		return match;
	}

	/**
	 * @param value the value to set
	 */
	public void setMatch(String match) {
		this.match = match;
	}

}
