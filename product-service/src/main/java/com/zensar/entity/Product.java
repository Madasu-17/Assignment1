package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private String discription;
	private Double price;
	@Transient
	private String couponCode;
	public Product() {
		super();
	}	
	
	public Product(int productId, String productName, String discription, Double price, String couponCode) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.discription = discription;
		this.price = price;
		this.couponCode = couponCode;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", discription=" + discription
				+ ", price=" + price + ", couponCode=" + couponCode + "]";
	}
	
	
	
	
	

}
