package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
/*@NamedQueries(value = { @NamedQuery(name = "Coupon.test", query = "From Coupon c Where c.couponCode=?1"),
		@NamedQuery(name = "Coupon.test1", query = "from Coupon c where c.couponId=?1 and c.couponCode=?1")*/


//@NamedQuery(name = "Coupon.test", query = "select * from where coupon_code=?1", resultClass=coupon.class)
public class Coupon {
	@Id
	private int couponId;
	private String couponCode;
	private String couponExpityDate;

	public Coupon() {
		super();
	}

	public Coupon(int couponId, String couponCode, String couponExpityDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.couponExpityDate = couponExpityDate;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponExpityDate() {
		return couponExpityDate;
	}

	public void setCouponExpityDate(String couponExpityDate) {
		this.couponExpityDate = couponExpityDate;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", couponExpityDate=" + couponExpityDate
				+ "]";
	}

}
