package au.com.vocus.elastictool.parser;

import java.util.ArrayList;

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
	
	
}
