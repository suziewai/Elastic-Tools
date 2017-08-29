package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONObject;

public interface QueryCriterion {

	public String getKey();
	public JSONObject getValue();
}
