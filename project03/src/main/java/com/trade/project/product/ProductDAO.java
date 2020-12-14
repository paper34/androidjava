package com.trade.project.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Bean
//@Component (컴포넌트 == bean) 부모클래스!!

@Repository
public class ProductDAO implements ProductDAOInterface {

	@Autowired
	SqlSessionTemplate mybatis;//싱글톤으로 객체를 가져다 사용
    String namespace;
    SqlSessionTemplate session;
	private Object Mapper;
	@Override
	public void insert(ProductVO vo) {//service단에서 vo를 넘겨받아 
		mybatis.insert("product.insert", vo);//vo를 product_mapper 로 넘겨줌 
	}

	@Override
	public void update(ProductVO vo) {
		int result = mybatis.update("product.update", vo);
		System.out.println(result);
		mybatis.update("product.update", vo);
	}

	@Override
	public void delete(ProductVO vo) {
		mybatis.delete("product.delete", vo);
	}

	@Override
	public ProductVO one(ProductVO vo) {
		ProductVO vo2 = mybatis.selectOne("product.view", vo);
		return vo2;
	}

	@Override
	public List<ProductVO> list() {//상품 전체를 받아오는 메서드
		//service단에서 vo를 넘겨받아 product_mapper에서 selectList를 사용해 리스트에 저장
		List<ProductVO> list = mybatis.selectList("product.list");
		System.out.println("list size : " + list.size());
		return list;//list를 service로 리턴
	}

	@Override
	public List<ProductVO> list2() {//상품 전체를 받아오는 메서드
		//service단에서 vo를 넘겨받아 product_mapper에서 selectList를 사용해 리스트에 저장
		List<ProductVO> list2 = mybatis.selectList("product.list2");
		System.out.println("list size : " + list2.size());
		return list2;//list2를 service로 리턴
	}
	
	@Override
	public List<ProductVO> list1(ProductVO vo) {//상품 전체를 받아오는 메서드(검색)
		//service단에서 vo를 넘겨받아 product_mapper에서 selectList를 사용해 리스트에 저장
		List<ProductVO> list1 = mybatis.selectList("product.search", vo);
		System.out.println("list1 size : " + list1.size());
		return list1;//list1를 service로 리턴
	}
	
	@Override
	public List<ProductUserVO> list4(ProductUserVO puvo) {////상품 전체를 받아오는 메서드(나이별)
		//service단에서 vo를 넘겨받아 product_mapper에서 selectList를 사용해 리스트에 저장
		List<ProductUserVO> list4 = mybatis.selectList("product.join", puvo);
		System.out.println("list4 size : " + list4.size());
		return list4;//list1를 service로 리턴
	}
	
	@Override
	public List<ProductUserVO> one(ProductUserVO puvo) {////상품 전체를 받아오는 메서드(유저 아이디)
		//service단에서 puvo를 넘겨받아 product_mapper에서 selectList를 사용해 리스트에 저장
		ProductUserVO puvo1 = mybatis.selectOne("product.join1", puvo);
		System.out.println("다오go");
		System.out.println("vo >>>" + puvo1);
		//int로 변환하여 10을 나누어줌(나이의 앞자리만 필요함)
		int puvo2  = puvo1.getUser_age() / 10;
		System.out.println(puvo2);
		//변환한 값을 list5에 담아 줌
		List<ProductUserVO> list5 = mybatis.selectList("product.join", puvo2);
		return list5;//list5를 service로 리턴
		/* return puvo2; */
	}
	
	

	@Override
	public void count(ProductVO vo) {//service단에서 vo를 넘겨받아 
		mybatis.update("product.updatecount", vo);//vo를 product_mapper 로 넘겨줌
	}

	@Override
	public void insert1(PaymentVO vo) {//service단에서 vo를 넘겨받아 
			mybatis.insert("product.insert1", vo);//vo를 product_mapper 로 넘겨줌
			
		}
	
	@Override
	public void payupdate(PaymentVO vo) {
			mybatis.update("product.payupdate", vo);
			
		}


	

	
	
	



	/*
	 * public ProductVO one1(ProductVO vo) { ProductVO vo3 =
	 * mybatis.selectOne("product.view", vo); mybatis.selectOne("memver.one", vo);
	 * //(네임스페이스 이름.id, 입력 param) return vo3; }
	 */
}
