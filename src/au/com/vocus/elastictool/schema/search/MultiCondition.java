package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public abstract class MultiCondition extends Query implements QueryCriterion {

	@Override
	public abstract String getKey();
		
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject value = new JSONObject();
		value.put(queryList.get(0).getKey(), queryList.get(0).getValue());
		return value;
	}

	public boolean isArray() {
		return queryList.size() > 1;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getValueArray() {
		JSONArray values = new JSONArray();
		for(QueryCriterion criterion : queryList) {
			JSONObject obj = new JSONObject();
			obj.put(criterion.getKey(), criterion.getValue());
			values.add(obj);
		}
		return values;
	}

}
