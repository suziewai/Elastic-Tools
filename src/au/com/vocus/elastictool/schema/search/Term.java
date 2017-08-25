package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONObject;

public class Term implements QueryCriteria {

	private String getKey() {
		return "term";
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject json = new JSONObject();
		json.put(getKey(), null);
		return json;
	}

}
