package au.com.vocus.elastictool.schema.search;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class QueryString implements QueryCriteria {

	private String query;
	private List<String> default_field;
	private String defaultOperator;
	private String analyzer;
	private Boolean allowLeadingWilcard = null;
	private Boolean enablePositionIncrements = null;
	private Integer fuzzyMaxExpansions;
	private String fuzziness;
	private Integer fuzzyPrefixLength;
	private Integer phraseSlop;
	private Double boost;
	private Boolean autoGeneratePhraseQueries = null;
	private Boolean analyzeWildcard = null;
	private Integer maxDeterminizedStates;
	private Integer minShouldMatch;
	private Boolean lenient = null;
	private String timezone;
	private String quoteFieldSuffix;
	private Boolean splitOnWhilespace = null;
	private Boolean allFields = null;
	
			
	private String getKey() {
		return "query_string";
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getValue() {
		JSONObject value = new JSONObject();
		JSONObject jsonObj = new JSONObject();
		addCriteria(jsonObj, "query", query);
		addCriteria(jsonObj, "default_field", default_field);
		addCriteria(jsonObj, "defaultOperator", defaultOperator);
		addCriteria(jsonObj, "analyzer", analyzer);
		addCriteria(jsonObj, "allowLeadingWilcard", allowLeadingWilcard);
		addCriteria(jsonObj, "enablePositionIncrements", enablePositionIncrements);
		addCriteria(jsonObj, "fuzzyMaxExpansions", fuzzyMaxExpansions);
		addCriteria(jsonObj, "fuzziness", fuzziness);
		addCriteria(jsonObj, "fuzzyPrefixLength", fuzzyPrefixLength);
		addCriteria(jsonObj, "phraseSlop", phraseSlop);
		addCriteria(jsonObj, "boost", boost);
		addCriteria(jsonObj, "autoGeneratePhraseQueries", boost);
		addCriteria(jsonObj, "analyzeWildcard", analyzeWildcard);
		addCriteria(jsonObj, "maxDeterminizedStates", maxDeterminizedStates);
		addCriteria(jsonObj, "minShouldMatch", minShouldMatch);
		addCriteria(jsonObj, "lenient", lenient);
		addCriteria(jsonObj, "timezone", timezone);
		addCriteria(jsonObj, "quoteFieldSuffix", quoteFieldSuffix);
		addCriteria(jsonObj, "splitOnWhilespace", splitOnWhilespace);
		addCriteria(jsonObj, "allFields", allFields);
		value.put(getKey(), jsonObj);
		return value;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the default_field
	 */
	public List<String> getDefault_field() {
		return default_field;
	}

	/**
	 * @param default_field the default_field to set
	 */
	public void setDefault_field(List<String> default_field) {
		this.default_field = default_field;
	}

	/**
	 * @return the defaultOperator
	 */
	public String getDefaultOperator() {
		return defaultOperator;
	}

	/**
	 * @param defaultOperator the defaultOperator to set
	 */
	public void setDefaultOperator(String defaultOperator) {
		this.defaultOperator = defaultOperator;
	}

	/**
	 * @return the analyzer
	 */
	public String getAnalyzer() {
		return analyzer;
	}

	/**
	 * @param analyzer the analyzer to set
	 */
	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}

	/**
	 * @return the allowLeadingWilcard
	 */
	public Boolean getAllowLeadingWilcard() {
		return allowLeadingWilcard;
	}

	/**
	 * @param allowLeadingWilcard the allowLeadingWilcard to set
	 */
	public void setAllowLeadingWilcard(Boolean allowLeadingWilcard) {
		this.allowLeadingWilcard = allowLeadingWilcard;
	}

	/**
	 * @return the enablePositionIncrements
	 */
	public Boolean getEnablePositionIncrements() {
		return enablePositionIncrements;
	}

	/**
	 * @param enablePositionIncrements the enablePositionIncrements to set
	 */
	public void setEnablePositionIncrements(Boolean enablePositionIncrements) {
		this.enablePositionIncrements = enablePositionIncrements;
	}

	/**
	 * @return the fuzzyMaxExpansions
	 */
	public Integer getFuzzyMaxExpansions() {
		return fuzzyMaxExpansions;
	}

	/**
	 * @param fuzzyMaxExpansions the fuzzyMaxExpansions to set
	 */
	public void setFuzzyMaxExpansions(Integer fuzzyMaxExpansions) {
		this.fuzzyMaxExpansions = fuzzyMaxExpansions;
	}

	/**
	 * @return the fuzziness
	 */
	public String getFuzziness() {
		return fuzziness;
	}

	/**
	 * @param fuzziness the fuzziness to set
	 */
	public void setFuzziness(String fuzziness) {
		this.fuzziness = fuzziness;
	}

	/**
	 * @return the fuzzyPrefixLength
	 */
	public Integer getFuzzyPrefixLength() {
		return fuzzyPrefixLength;
	}

	/**
	 * @param fuzzyPrefixLength the fuzzyPrefixLength to set
	 */
	public void setFuzzyPrefixLength(Integer fuzzyPrefixLength) {
		this.fuzzyPrefixLength = fuzzyPrefixLength;
	}

	/**
	 * @return the phraseSlop
	 */
	public Integer getPhraseSlop() {
		return phraseSlop;
	}

	/**
	 * @param phraseSlop the phraseSlop to set
	 */
	public void setPhraseSlop(Integer phraseSlop) {
		this.phraseSlop = phraseSlop;
	}

	/**
	 * @return the boost
	 */
	public Double getBoost() {
		return boost;
	}

	/**
	 * @param boost the boost to set
	 */
	public void setBoost(Double boost) {
		this.boost = boost;
	}

	/**
	 * @return the autoGeneratePhraseQueries
	 */
	public Boolean getAutoGeneratePhraseQueries() {
		return autoGeneratePhraseQueries;
	}

	/**
	 * @param autoGeneratePhraseQueries the autoGeneratePhraseQueries to set
	 */
	public void setAutoGeneratePhraseQueries(Boolean autoGeneratePhraseQueries) {
		this.autoGeneratePhraseQueries = autoGeneratePhraseQueries;
	}

	/**
	 * @return the analyzeWildcard
	 */
	public Boolean getAnalyzeWildcard() {
		return analyzeWildcard;
	}

	/**
	 * @param analyzeWildcard the analyzeWildcard to set
	 */
	public void setAnalyzeWildcard(Boolean analyzeWildcard) {
		this.analyzeWildcard = analyzeWildcard;
	}

	/**
	 * @return the maxDeterminizedStates
	 */
	public Integer getMaxDeterminizedStates() {
		return maxDeterminizedStates;
	}

	/**
	 * @param maxDeterminizedStates the maxDeterminizedStates to set
	 */
	public void setMaxDeterminizedStates(Integer maxDeterminizedStates) {
		this.maxDeterminizedStates = maxDeterminizedStates;
	}

	/**
	 * @return the minShouldMatch
	 */
	public Integer getMinShouldMatch() {
		return minShouldMatch;
	}

	/**
	 * @param minShouldMatch the minShouldMatch to set
	 */
	public void setMinShouldMatch(Integer minShouldMatch) {
		this.minShouldMatch = minShouldMatch;
	}

	/**
	 * @return the lenient
	 */
	public Boolean getLenient() {
		return lenient;
	}

	/**
	 * @param lenient the lenient to set
	 */
	public void setLenient(Boolean lenient) {
		this.lenient = lenient;
	}

	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the quoteFieldSuffix
	 */
	public String getQuoteFieldSuffix() {
		return quoteFieldSuffix;
	}

	/**
	 * @param quoteFieldSuffix the quoteFieldSuffix to set
	 */
	public void setQuoteFieldSuffix(String quoteFieldSuffix) {
		this.quoteFieldSuffix = quoteFieldSuffix;
	}

	/**
	 * @return the splitOnWhilespace
	 */
	public Boolean getSplitOnWhilespace() {
		return splitOnWhilespace;
	}

	/**
	 * @param splitOnWhilespace the splitOnWhilespace to set
	 */
	public void setSplitOnWhilespace(Boolean splitOnWhilespace) {
		this.splitOnWhilespace = splitOnWhilespace;
	}

	/**
	 * @return the allFields
	 */
	public Boolean getAllFields() {
		return allFields;
	}

	/**
	 * @param allFields the allFields to set
	 */
	public void setAllFields(Boolean allFields) {
		this.allFields = allFields;
	}
	
	@SuppressWarnings("unchecked")
	private void addCriteria(JSONObject parent, String key, Object value) {
		if(value == null)
			return;
		
		if(value instanceof List<?>) {
			JSONArray list = new JSONArray();
			for(Object element : (List<?>)value) {
				list.add(element);
			}
			parent.put(key, list);
		} else {
			parent.put(key, value);
		}
			
	}

}
