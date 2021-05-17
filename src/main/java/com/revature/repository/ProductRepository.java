package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{
	//@Query("select pro from products pro where pro.category_id=cat_id")
	List<Products> findByCategoryId(String cat_id);

}
