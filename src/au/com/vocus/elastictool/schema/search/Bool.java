package au.com.vocus.elastictool.schema.search;

public class Bool extends Query implements QueryCriterion {

	@Override
	public String getKey() {
		return "bool";
	}

}
