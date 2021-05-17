package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.model.AddtoCart;
import com.revature.model.CheckoutCart;
import com.revature.model.Products;

@Service
public interface CartService {
	
	//AddToCart
	List<AddtoCart> addCartbyUserIdAndProductId(long productId,long userId, int qty, double price) throws Exception;
	List<AddtoCart> getCartByUserId(long userId);
	
	List<AddtoCart> removeCartByUserIdAndCartId(long cartId,long userId);
	List<AddtoCart> removeAllCartByUserId(long userId);
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	
	
	//CheckOutCart
	Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
	List<CheckoutCart> getAllCheckoutByUserId(long userId);
	List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;

    
}
    
	
