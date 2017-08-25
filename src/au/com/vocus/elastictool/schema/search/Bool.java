package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONObject;

public class Bool implements QueryCriteria {

	private String getKey() {
		return "bool";
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject json = new JSONObject();
		json.put(getKey(), null);
		return json;
	}

}
