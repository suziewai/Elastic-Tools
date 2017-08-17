package au.com.vocus.elastictool.test;

import au.com.vocus.elastictool.parser.ElasticParser;

public class testMain {

	public static void main(String[] args) {
		ElasticParser parser = new ElasticParser();
		parser.parse(getTestSearch());
	}
	
	private static String getTestSearch() {
		return "";
	}
}
