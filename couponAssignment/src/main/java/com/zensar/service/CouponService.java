package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

public interface CouponService {
	
	public CouponDto getCoupon(int couponId);
	public List<CouponDto> getAllCoupons(int pageNuber, int pageSize, String sortBy, Direction dir);
	public void updateCouponId(int couponId, CouponDto couponDto);
	public CouponDto insertCoupon(CouponDto couponDto);
	public void deleteCoupon(int couponId);
	List<CouponDto>getByCouponCode(String couponCode);
	List<CouponDto> getByCouponIdAndCouponCode(int couponId, String couponCode);
	List<CouponDto> getBycouponExpityDate(String couponExpityDate);
}
