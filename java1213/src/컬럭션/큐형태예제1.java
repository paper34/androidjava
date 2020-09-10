package 컬럭션;

import java.util.LinkedList;

public class 큐형태예제1 {

	public static void main(String[] args) {
		LinkedList exam = new LinkedList();
		exam.add("국어");
		exam.add("수학");
		exam.add("영어");
		exam.add("컴퓨터");
		
		for (int i = 0; i < exam.size(); i++) {
			System.out.print(exam.get(i) + " " );
		}
		System.out.println();
		exam.remove();
		
		for (int i = 0; i < exam.size(); i++) {
			System.out.print( exam.get(i) + " ");
		}
		System.out.println();
		exam.remove();
		
		for (int i = 0; i < exam.size(); i++) {
			System.out.print(exam.get(i) + " ");
		}
		exam.remove();
		exam.remove();
		for (int i = 0; i < exam.size(); i++) {
			System.out.print(exam.get(i) + " ");
		}
	}

}
