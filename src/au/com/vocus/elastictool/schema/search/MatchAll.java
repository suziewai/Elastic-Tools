package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONObject;

public class MatchAll implements QueryCriterion {
	
	@Override
	public String getKey() {
		return "match_all";
	}

	@Override
	public JSONObject getValue() {
		return null;
	}

}
