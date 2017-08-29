package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONObject;

public class ConstantScore implements QueryCriterion {

	@Override
	public String getKey() {
		return "constant_score";
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject value = new JSONObject();
		value.put(getKey(), null);
		return value;
	}
}
