package com.revature.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.AddtoCart;
import com.revature.model.Products;
import com.revature.repository.AddToCartRepository;
import com.revature.repository.CheckoutRepository;

//import com.revature.repository.CheckoutRepository;

//import org.slf4j.Logger;

//import org.slf4j.LoggerFactory;

import com.revature.service.ProductServices;
import com.revature.model.CheckoutCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	AddToCartRepository addCartRepo;
	
	@Autowired
	CheckoutRepository checkOutRepo;
	
	@Autowired
	ProductServices proServices;

	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	@Override
	public List<AddtoCart> addCartbyUserIdAndProductId(long productId, long userId, int qty, double price)
			throws Exception {
		// try {
		List<AddtoCart> cartProducts = addCartRepo.findAllByProductIdAndUserId(productId, userId);
		if (cartProducts.size() > 0) {
			throw new Exception("Product already exists.");
		}
		AddtoCart obj = new AddtoCart();
		obj.setQty(qty);
		obj.setUserId(userId);
		Products pro = proServices.getProductsById(productId);
		obj.setProduct(pro);
		// TODO price has to check with qty
		obj.setPrice(price);
		addCartRepo.save(obj);
		return this.getCartByUserId(userId);
	

	}

	@Override
	public List<AddtoCart> getCartByUserId(long userId) {
		return addCartRepo.findAllByUserId(userId);
	}


	@Override
	public List<AddtoCart> removeAllCartByUserId(long userId) {
		addCartRepo.deleteAllByUserId(userId);
		return null;
	}

	@Override
	public List<AddtoCart> removeCartByUserIdAndCartId(long cartId, long userId) {
		// TODO Auto-generated method stub
		addCartRepo.deleteByUserIdAndAddCartId(userId, cartId);
		return this.getCartByUserId(userId);
	}

	@Override
	public void updateQtyByCartId(long addCartId, int qty, double price) throws Exception {
		// TODO Auto-generated method stub
		addCartRepo.updateQtyByCartId(addCartId, price, qty);
		
	}
	
	// CHECKOUT
	
	@Override
	public Boolean checkTotalAmountAgainstCart(double totalAmount, long userId) {
		// TODO Auto-generated method stub
		double total_amount = addCartRepo.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
		
	}

	@Override
	public List<CheckoutCart> getAllCheckoutByUserId(long userId) {
		// TODO Auto-generated method stub
		
		return checkOutRepo.getCheckoutCartByuserId(userId);
	}

	@Override
	public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			//get the userID from temp list
			long user_id = tmp.get(0).getUser_id();
			if(tmp.size() >0) {
				checkOutRepo.saveAll(tmp); //insert temp into checkout_cart table
				this.removeAllCartByUserId(user_id); //then empty the cart
				return this.getAllCheckoutByUserId(user_id); //return the all the entries in checkout_cart table
			}	
			else {
				throw  new Exception("Should not be empty");
			}
		}catch(Exception e) {
			throw new Exception("Error while checkout "+e.getMessage());
		}
	}

	

	

	

}
