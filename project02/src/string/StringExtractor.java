package string;

public class StringExtractor {
	static public String extractor (String str, String data) {
		int strIdx = data.indexOf(str) + str.length();
		return data.substring(strIdx);
	}
	
	static public String extractor (String str, String end, String data) {
		int strIdx = data.indexOf(str) + str.length();
		int endIdx = data.indexOf(end);
		return data.substring(strIdx, endIdx);
	}
}
