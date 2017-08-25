package au.com.vocus.elastictool.schema.search;

import java.util.ArrayList;
import java.util.List;

public class Query {

	private List<QueryCriteria> queryList = new ArrayList<QueryCriteria>();
	
	public String getKey() {
		return "query";
	}
	
	public void addCriteria(QueryCriteria criteria) {
		queryList.add(criteria);
	}
	
	public List<QueryCriteria> getQueryList() {
		return queryList;
	}
	
}
