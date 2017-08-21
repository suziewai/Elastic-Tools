package au.com.vocus.elastictool.parser;

import java.util.ArrayList;
import java.util.Hashtable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import au.com.vocus.elastictool.schema.ElasticRecord;
import au.com.vocus.elastictool.schema.ElasticResponse;

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
	
	public Hashtable<String, String> toDotNotation(JSONObject source, String parentKey) {	
		if(source == null) return null;
		if(parentKey == null || parentKey == "") 
			parentKey = "";
		else
			parentKey += ".";
		Hashtable<String, String> table = new Hashtable<String, String>();
				
		for(Object key : source.keySet()) {
			Object value = source.get(key);		
			if(value instanceof JSONArray) {
				int i = 0;
				for(Object element : (JSONArray)value) {
					table.putAll(toDotNotation((JSONObject)element, parentKey + key + "[" + i + "]"));
					i++;
				}
			} else if (value instanceof JSONObject) {
				table.putAll(toDotNotation((JSONObject)value, parentKey + key));
			} else {
				table.put(parentKey + key, value.toString());
			}
		}		
		return table;
	}
}
