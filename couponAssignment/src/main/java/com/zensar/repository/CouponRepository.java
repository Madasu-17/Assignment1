package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	
	@Query(value = "select * from coupon where coupon_code=:code", nativeQuery = true)
	List<Coupon> test(@Param(value = "code") String couponCode);

	@Query(value = "select * from coupon where couponExpiryDate=:date", nativeQuery = true)
	List<Coupon> test2(@Param("date") String couponExpityDate);

	@Query("from Coupon c where c.couponId=:id and c.couponCode=:code")
	List<Coupon> test1(@Param("id") int couponId, @Param("code") String couponCode);

}
