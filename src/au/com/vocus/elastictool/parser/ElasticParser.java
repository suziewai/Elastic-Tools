package au.com.vocus.elastictool.parser;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import au.com.vocus.elastictool.schema.ElasticRecord;
import au.com.vocus.elastictool.schema.ElasticResponse;
import au.com.vocus.elastictool.schema.search.Query;
import au.com.vocus.elastictool.schema.search.QueryCriteria;

public class ElasticParser {
	
	JSONParser parser = new JSONParser();
	
	private <T extends ElasticRecord> ElasticResponse<T> parseResponse(String json) {
		ElasticResponse<T> elastic = null;
		try {
			Object obj = parser.parse(json);
			elastic = new ElasticResponse<T>((JSONObject) obj);
			
		} catch(ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
		}	
		return elastic;
	}
		
	public ElasticResponse<ElasticRecord> parse(String json) {
		return parse(json, ElasticRecord.class);
	}
	
	public <T extends ElasticRecord> ElasticResponse<T> parse(String json, Class<T> type) {
		ElasticResponse<T> eObj = parseResponse(json);
		try {
			parseSource(eObj, type);
		} catch (InstantiationException | IllegalAccessException e) {
			eObj.getHits().setRecords(null);
		}
		return eObj;
	}
	
	private <T extends ElasticRecord> void parseSource(ElasticResponse<T> eObj, Class<T> type) throws InstantiationException, IllegalAccessException {
		
		eObj.getHits().setRecords(new ArrayList<T>());
		
		for(Object element : (JSONArray) eObj.getHits().getHits()) {
			T source = (T) type.newInstance();
			source.setMembers((JSONObject)element);
			eObj.getHits().getRecords().add(source);
		}
		
	}
	
	public void parseSource(JSONObject source) {
		
		if(source == null) return;
				
		for(Object key : source.keySet()) {
			Object value = source.get(key);		
			if(value instanceof JSONArray) {
				for(Object element : (JSONArray)value) {
					parseSource((JSONObject)element);
				}
			} else if (value instanceof JSONObject) {
				parseSource((JSONObject)value);
			} else {
				System.out.println(key + ": " + value);
			}
		}
	}
	
	public Hashtable<String, Object> toDotNotation(JSONObject source, String parentKey) {
		return toDotNotation(source, parentKey, false);
	}
	
	public Hashtable<String, Object> toDotNotation(JSONObject source, String parentKey, boolean flatTable) {	
		if(source == null) return null;
		if(parentKey == null || parentKey == "") 
			parentKey = "";
		else
			parentKey += ".";
		Hashtable<String, Object> table = new Hashtable<String, Object>();
				
		for(Object key : source.keySet()) {
			String newKey = parentKey + key;
			Object value = source.get(key);		
			if(value instanceof JSONArray) {
				if(flatTable)
					table.putAll(toFlatTable(newKey, (JSONArray)value));
				else
					table.put(newKey, toTable((JSONArray)value));
			} else if (value instanceof JSONObject) {
				table.putAll(toDotNotation((JSONObject)value, newKey, flatTable));
			} else {
				table.put(newKey, value.toString());
			}
		}		
		return table;
	}
	
	private Hashtable<String, Object> toFlatTable(String key, JSONArray table) {
		int i = 0;
		Hashtable<String, Object> subTable = new Hashtable<String, Object>();
		for(Object element : table) {
			subTable.putAll(toDotNotation((JSONObject)element, key + "[" + i + "]", true));
			i++;
		}
		return subTable;
	}
	
	private List<Hashtable<String, Object>> toTable(JSONArray table) {
		List<Hashtable<String, Object>> subTable = new ArrayList<Hashtable<String, Object>>();
		for(Object element : table) {
			subTable.add(toDotNotation((JSONObject)element, null, false));
		}
		return subTable;
	}
	
	@SuppressWarnings("unchecked")
	public static String getSearchQuery(Query q) {
		JSONObject json = new JSONObject();
		if(q.getQueryList().size() == 1) {
			json.put("query", q.getQueryList().get(0).getValue());
		} else {
			JSONArray child = new JSONArray();
			for(QueryCriteria criteria : q.getQueryList()) {
				child.add(criteria.getValue());
			}
		}
		return json.toJSONString();
	}
}
