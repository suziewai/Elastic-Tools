package au.com.vocus.elastictool.schema.search;

public class MustNot extends MultiCondition {

	@Override
	public String getKey() {
		return "must_not";
	}

}
