package 컬렉션복습;

import java.io.FileWriter;
import java.util.ArrayList;

public class 계좌저장 {

	public void save(ArrayList<계좌> list) {
		
		for (int i = 0; i < list.size(); i++) {
			계좌 account = list.get(i);
			
			try {
				FileWriter w = new FileWriter(account.name+ ".txt");
				w.write(account.field + "\n");
				w.write(account.money+ "\n");
				w.write(account.name + "\n");
				w.close(); // 파일에다가 다 썼음.
			} catch (Exception e) {
				System.out.println("파일로 저장하다가 에러가 발생함");
			}
		}
	}

}
