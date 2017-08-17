package au.com.vocus.elastictool.schema;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Hits<T extends ElasticRecord>{
	private Long total;
	private Double max_score;
	private JSONArray hits;
	private List<T> records;
	
	public Hits(JSONObject json) {
		total = (Long)json.get("total");
		max_score = (Double)json.get("max_score");
		hits = (JSONArray)json.get("hits");
	}
	
	public JSONArray getHits() {
		return hits;
	}
	
	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @return the max_score
	 */
	public Double getMax_score() {
		return max_score;
	}

	/**
	 * @return the records
	 */
	public List<T> getRecords() {
		return records;
	}
	
	/**
	 * @param records the records to set
	 */
	public void setRecords(List<T> records) {
		this.records = records;
	}
}
