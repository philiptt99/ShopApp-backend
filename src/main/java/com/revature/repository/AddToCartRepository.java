package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.AddtoCart;

@Repository
public interface AddToCartRepository extends JpaRepository<AddtoCart, Long> {
	
		//getCartByuserId
		//@Modifying
		@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.userId=:userId")
		List<AddtoCart> findAllByUserId(@Param("userId")Long userId);
		
		//@Modifying
		//@Transactional
		@Query("SELECT addCart FROM AddtoCart addCart WHERE addCart.product.product_id=:productId and addCart.userId=:userId")
		List<AddtoCart> findAllByProductIdAndUserId(@Param("productId")Long productId,@Param("userId")Long userId);
		
		
		
//		@Modifying
	    @Transactional
		//@Query("delete addCart from AddtoCart where addCart_id =cart_id and addCart.user_id=user_id")
		void deleteByUserIdAndAddCartId(Long userId, Long addCartId);
		
		
		
//		@Modifying
	    @Transactional
		//@Query("delete addCart from AddtoCart addCart where addCart.user_id=user_id")
		void deleteAllByUserId(Long userId);
		
		
		
		@Modifying
		@Transactional
		@Query("UPDATE AddtoCart addCart SET addCart.qty=:qty,addCart.price=:price WHERE addCart.addCartId = :addCartId")
		void updateQtyByCartId(@Param("addCartId")long addCartId,@Param("price")double price,@Param("qty")Integer qty);

		
		@Query("Select sum(addCart.price) FROM AddtoCart addCart WHERE addCart.userId=:userId")
		double getTotalAmountByUserId(@Param("userId")Long userId);
		
		
				
		

		

}
