package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.CheckoutCart;



@Repository
public interface CheckoutRepository  extends JpaRepository<CheckoutCart, Long> {
	
	@Query("Select checkCart from CheckoutCart checkCart where checkCart.user_id=:user_id")
	List<CheckoutCart> getCheckoutCartByuserId(@Param("user_id")Long user_id);
	
}


