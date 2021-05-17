package com.revature.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.ProductServices;
import com.revature.dto.ProductsByCategoryDTO;
import com.revature.model.Category;
import com.revature.model.Products;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value= "product")
public class ProductController {
	
	@Autowired
	ProductServices productServices;
	
	@RequestMapping("/getAll")
	public List<Products> getAllProducts(){
		return productServices.getAllProducts();
	}
	
	@RequestMapping("getAllCategory")
	public List<Category> getAllCategory(){
		return productServices.getAllCategory();
	}
	
	//@GetMapping(value = "/user/{name}")
	@RequestMapping("/getProductsByCategory")
	public List<Products> getProductsByCategory(@RequestBody ProductsByCategoryDTO dto){
		//String category_id = request.get("cat_id");	
		System.out.println("Category ID is " + dto.getCategory());
		return productServices.getProductsByCategory(dto.getCategory());
	}
	
	
	
	@GetMapping( value = "/getimage/{img_name}",produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable("img_name") String img_name) throws IOException {
	    InputStream in = getClass().getResourceAsStream("/images/"+img_name);
	    return IOUtils.toByteArray(in);
	}

}
