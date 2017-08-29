package au.com.vocus.elastictool.schema.search;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class Query {

	protected List<QueryCriterion> queryList = new ArrayList<QueryCriterion>();
	
	public String getKey() {
		return "query";
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getValue() {
		
		JSONObject value = new JSONObject();		
		for(QueryCriterion criterion : queryList) {
			if(criterion instanceof MultiCondition && ((MultiCondition) criterion).isArray()) {
				value.put(criterion.getKey(), ((MultiCondition)criterion).getValueArray());
			} else {
				value.put(criterion.getKey(), criterion.getValue());
			}
		}
		return value;
	}
	
	public void addCriteria(QueryCriterion criteria) {
		queryList.add(criteria);
	}
	
	public List<QueryCriterion> getQueryList() {
		return queryList;
	}
	
}
