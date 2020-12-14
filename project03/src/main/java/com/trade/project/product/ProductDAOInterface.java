package com.trade.project.product;

import java.util.List;

public interface ProductDAOInterface {

	void insert(ProductVO vo);

	void update(ProductVO vo);

	void delete(ProductVO vo);

	ProductVO one(ProductVO vo);

	List<ProductVO> list();

	List<ProductVO> list2();

	List<ProductVO> list1(ProductVO vo);

	List<ProductUserVO> list4(ProductUserVO puvo);

	List<ProductUserVO> one(ProductUserVO puvo);

	void count(ProductVO vo);

	void insert1(PaymentVO vo);

	void payupdate(PaymentVO vo);
}