package com.trade.project.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	

	@Autowired
	ProductDAOInterface dao;

	public void insert(ProductVO vo) {
		dao.insert(vo);//vo값을 dao로 넘겨줌
	}

	public void delete(ProductVO vo) {
		dao.delete(vo);//vo값을 dao로 넘겨줌
		
	}
	public void update(ProductVO vo) {
		dao.update(vo);//vo값을 dao로 넘겨줌
		
	}
	public ProductVO one(ProductVO vo) {
		return dao.one(vo);//dao에서받은 값을 controller로 return 시켜줌
		
	}
	public List<ProductVO> list() {//최신순 메인
		
		return dao.list();
		//controller에서 받은 List<ProductVO> dao에 값을 전달
		//dao에서받은 값을 controller로 return 시켜줌
		
	}
	public List<ProductVO> list2() {//인기순
		return dao.list2();//dao에서받은 값을 controller로 return 시켜줌
		//controller에서 받은 List<ProductVO> dao에 값을 전달
		//dao에서받은 값을 controller로 return 시켜줌
	}
	public List<ProductVO> list1(ProductVO vo) {//검색 
		return dao.list1(vo);//dao에서받은 값을 controller로 return 시켜줌
		//controller에서 받은 List<ProductVO>의 vo를 dao에 값을 전달
		//dao에서받은 값을 controller로 return 시켜줌
	}
	
	public List<ProductUserVO> list4(ProductUserVO puvo) {//나이대
		return dao.list4(puvo);//dao에서받은 값을 controller로 return 시켜줌
		//controller에서 받은 List<ProductVO>의 puvo를 dao에 값을 전달
		//dao에서받은 값을 controller로 return 시켜줌
	}
	public List<ProductUserVO> one(ProductUserVO puvo1) {// 유저 아이디의 나이가져오기
		System.out.println("서비스go");
		System.out.println(puvo1);
		System.out.println("아이go");
		List<ProductUserVO> list5 = dao.one(puvo1);//유저 나이가져온것을 list5에 담는다.
		//이차원배열선언
		//int[해당아이디][조회수] 
		//int[list5.size()전체사이즈][배열의 갯수2]
		int[][] age = new int[list5.size()][2];
		for (int i = 0; i < list5.size(); i++) {
			//배열은 0부터 시작을 하여 0(getProduct_id())과1(getProduct_count())을 가져옴
			age[i][0] = list5.get(i).getProduct_id();
			age[i][1] = list5.get(i).getProduct_count();
		}
		//킥솔트 0부터 마지막까지 내림차순으로 정렬함
		QickSort.quickSort(age, 0, list5.size()-1);
		//제일 최고점수
		System.out.println(age[0][0] +" : " + age[0][1]);
		//다시 필터링 하기위하여 list6를 선언하여 
		List<ProductUserVO> list6 = new ArrayList<ProductUserVO>();
		//list5와 list6를 갯수를 맞추려고
		for (int i = 0; i < list5.size(); i++) {
			for (int j = 0; j < list5.size(); j++) {
				if(age[i][0] == list5.get(j).getProduct_id()) {
					list6.add(list5.get(j));
					break;
				}
			}
		}
		return list6;//dao에서받은 값을 controller로 return 시켜줌
		//controller에서 받은 List<ProductVO>의 puvo2을  dao에 값을 전달
		//dao에서받은 값을 controller로 return 시켜줌
	}
	
	public List<ProductUserVO> list5(ProductUserVO puvo2) {//유저아이디의 해당나이대
		return dao.one(puvo2);//dao에서받은 값을 controller로 return 시켜줌
		//controller에서 받은 List<ProductVO>의 puvo2을 dao에 값을 전달
		//dao에서받은 값을 controller로 return 시켜줌
		
	}

	
	public void count(ProductVO vo) {//조회수
		dao.count(vo);//vo값을 dao로 넘겨줌
		
	}


	public void insert1(PaymentVO vo) {
		dao.insert1(vo);//vo값을 dao로 넘겨줌

	
	}
	
	public void payupdate(PaymentVO vo) { 
		dao.payupdate(vo); // 

	
	}

}

