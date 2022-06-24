package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.print.attribute.standard.Media;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;
import com.zensar.service.CouponService;

@RestController
@RequestMapping(value = "/coupon-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CouponController {
	@Autowired
	private CouponService couponService;

	@GetMapping("/coupons/{couponId}")
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponId") int couponId) {
		return new ResponseEntity(couponService.getCoupon(couponId), HttpStatus.OK);
	}

	// http://localhost:8181/coupon-api/coupons -- AllCoupons
	// http://localhost:8181/coupon-api/coupons?pageNumber=0&pageSize=4 --
	// forRetrevingParticulaNumberOfRecords
	@GetMapping("/coupons")
	public ResponseEntity<List<CouponDto>> getAllCoupons(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "couponCode") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "DESC") Direction dir) {
		// return couponService.getCoupons();
		return new ResponseEntity<List<CouponDto>>(couponService.getAllCoupons(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);
	}

	// http://localhost:8181/coupon-api/coupons -- Insert
	@PostMapping("/coupons")
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto) {
		return new ResponseEntity(couponService.insertCoupon(couponDto), HttpStatus.CREATED);
	}

	// http://localhost:8181/coupon-api/coupons -- Update
	@PutMapping("/coupons")
	public ResponseEntity<String> updateCouponId(@PathVariable("couponId") int couponId,
			@RequestBody CouponDto couponDto) {
		couponService.updateCouponId(couponId, couponDto);
		return new ResponseEntity<String>("Coupon Updated SuccessFullyy..!!!", HttpStatus.OK);

	}

	// http://localhost:8181/coupon-api/coupons -- Delete
	@DeleteMapping("/coupons")
	public ResponseEntity<String> deleteCoupon(@PathVariable("coupodId") int couponId) {
		couponService.deleteCoupon(couponId);
		return new ResponseEntity<String>("Coupon Deleted Successfully..!!!", HttpStatus.OK);
	}

	// http://localhost:8181/coupon-api/coupon/code/101 --
	// getTheCouponCodeResultsByCode
	@GetMapping("/coupons/code/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponCode(@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity(couponService.getByCouponCode(couponCode), HttpStatus.OK);
	}

	// http://localhost:8181/coupon-api/coupons/date/22-02-2002 --
	// getTheDataByExpiryDate
	@GetMapping("/coupons/date/{couponExpiryDate}")
	public ResponseEntity<CouponDto> getBycouponExpityDate(@PathVariable("couponExpiryDate") String couponExpiryDate) {
		return new ResponseEntity(couponService.getBycouponExpityDate(couponExpiryDate), HttpStatus.OK);
	}

	// http://localhost:8181/coupon-api/coupons/101/trynow --
	// getTheStudentsByCouponIdAndCouponCode
	@GetMapping("/coupons/{couponId}/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponIdAndCouponCode(@PathVariable("couponId") int couponId,
			@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity(couponService.getByCouponIdAndCouponCode(couponId, couponCode), HttpStatus.OK);

	}
}
