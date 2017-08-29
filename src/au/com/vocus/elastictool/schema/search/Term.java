package au.com.vocus.elastictool.schema.search;

import org.json.simple.JSONObject;

public class Term implements QueryCriterion {

	private String field;
	private String term;
	
	@Override
	public String getKey() {
		return "term";
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject value = new JSONObject();
		value.put(field, term);
		return value;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term the match to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}

}
