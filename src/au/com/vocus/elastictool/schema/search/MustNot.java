package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONObject;

public class MustNot implements QueryCriteria {

	private String getKey() {
		return "must_not";
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject json = new JSONObject();
		json.put(getKey(), null);
		return json;
	}

}
