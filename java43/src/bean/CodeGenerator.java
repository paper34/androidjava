package bean;

import java.util.Random;

public class CodeGenerator {
	StringBuffer resultSb = new StringBuffer();

	public StringBuffer generator(StringBuffer sb) {
		resultSb.append(sb);
		for (int i = 0; i < 4; i++) {
			Random rb = new Random();
			resultSb.append(rb.nextInt(10));
		}
		return resultSb;
	}

}
