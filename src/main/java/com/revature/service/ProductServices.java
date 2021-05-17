package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.CategoryRepository;
import com.revature.repository.ProductRepository;
import com.revature.model.Category;
import com.revature.model.Products;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository cateRepo;
	
	public List<Products>getAllProducts(){
		return productRepo.findAll();
	}
	public List<Products> getProductsByCategory(String product_id){
		return productRepo.findByCategoryId(product_id);
	}
	
	public List<Category>getAllCategory(){
		return cateRepo.findAll();
	}
	
	public Products getProductsById(long productId) throws Exception {
		return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}
	
	
}