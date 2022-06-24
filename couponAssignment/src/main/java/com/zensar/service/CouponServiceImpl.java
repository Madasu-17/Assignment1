package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;
import com.zensar.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private ModelMapper modelMapper;
	private Object coupon;

	@Override
	public CouponDto getCoupon(int couponId) {
		Coupon coupon = couponRepository.findById(couponId).get();
		// CouponDto dto=mapToDto(coupon);
		return modelMapper.map(coupon, CouponDto.class);

	}

	@Override
	public List<CouponDto> getAllCoupons(int pageNumber,int pageSize, String sortBy, Direction dir) {
		// List<Coupon> listOfCoupons = couponRepository.findAll();
		List<CouponDto> listOfCouponDto = new ArrayList<CouponDto>();
		//Page<Coupon> findAll = couponRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(Direction.DESC,"couponCode")));
		//Page<Coupon> findAll = couponRepository.findAll(PageRequest.of(pageNumber, pageSize, Direction.ASC,"couponCode"));  //sortingTheDataByUsing Sort.by/Direction
		Page<Coupon> findAll = couponRepository.findAll(PageRequest.of(pageNumber, pageSize));
		List<Coupon> content = findAll.getContent();
		for (Coupon coupon : content) {
			listOfCouponDto.add(modelMapper.map(coupon, CouponDto.class));
		}

		return listOfCouponDto;
	}

	@Override
	public void updateCouponId(int couponId, CouponDto couponDto) {
		// Coupon coupon=mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		couponRepository.save(coupon);
	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {
		// Coupon coupon=mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon couponInserted = couponRepository.save(coupon);
		// CouponDto dto =mapToDto(insertedCoupon);
		return modelMapper.map(couponInserted, CouponDto.class);
		// return dto;

	}

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);

	}

	@Override
	public List<CouponDto> getByCouponCode(String couponCode) {
		List<CouponDto> listOfCouponDto = new ArrayList();
		List<Coupon> coupon = couponRepository.test(couponCode);
		for (Coupon coupons : coupon) {
			listOfCouponDto.add(modelMapper.map(coupons, CouponDto.class));
		}
		return listOfCouponDto;
	}

	@Override
	public List<CouponDto> getBycouponExpityDate(String couponExpityDate) {
		List<CouponDto> listOfCouponDtos = new ArrayList();
		List<Coupon> coupon = couponRepository.test2(couponExpityDate);
		for (Coupon coupons : coupon) {
			listOfCouponDtos.add(modelMapper.map(coupons, CouponDto.class));
		}
		return listOfCouponDtos;

	}

	@Override
	public List<CouponDto> getByCouponIdAndCouponCode(int couponId, String couponCode) {
		List<CouponDto> listOfCouponDto = new ArrayList();
		List<Coupon> coupon = couponRepository.test1(couponId, couponCode);
		for (Coupon coupons : coupon) {
			listOfCouponDto.add(modelMapper.map(coupons, CouponDto.class));
		}
		return listOfCouponDto;
	}

	/*
	 * public Coupon mapToEntity(CouponDto couponDto) { Coupon coupon = new
	 * Coupon(); coupon.setCouponId(couponDto.getCouponId());
	 * coupon.setCouponCode(couponDto.getCouponCode());
	 * coupon.setCouponExpityDate(coupon.getCouponExpityDate()); return coupon; }
	 * 
	 * public CouponDto mapToDto(Coupon coupon) { CouponDto dto = new CouponDto();
	 * dto.setCouponId(coupon.getCouponId());
	 * dto.setCouponCode(coupon.getCouponCode());
	 * dto.setCouponExpityDate(coupon.getCouponExpityDate()); return dto; }
	 */

}
