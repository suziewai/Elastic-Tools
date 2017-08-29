package au.com.vocus.elastictool.schema.search;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class Range implements QueryCriterion {

	private String field;
	private Map<PARAM, String> range = new HashMap<PARAM, String>();
	
	public enum PARAM {
		gte,
		gt,
		lte,
		lt,
		boost,
		format,
		time_zone
	}
	
	@Override
	public String getKey() {
		return "range";
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject value = new JSONObject();
		JSONObject params = new JSONObject();
		
		for(PARAM key : range.keySet()) {
			params.put(key.name(), range.get(key));
		}
		
		value.put(field, params);
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
	 * @return the range
	 */
	public Map<PARAM, String> getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(Map<PARAM, String> range) {
		this.range = range;
	}
	
	public void addRange(PARAM oper, String value) {
		range.put(oper, value);
	}

}
