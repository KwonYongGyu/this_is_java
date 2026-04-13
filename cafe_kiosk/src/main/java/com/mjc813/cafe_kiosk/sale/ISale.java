package com.mjc813.cafe_kiosk.sale;

import com.mjc813.cafe_kiosk.models.product.IProduct;

import java.time.LocalDateTime;

public interface ISale {
	Integer getId();
	void setId(Integer id);

	Integer getQty();
	void setQty(Integer qty);

	Integer getPrice();
	void setPrice(Integer price);

	IProduct getProduct();
	void setProduct(IProduct product);

	LocalDateTime getSaleTime();
	void setSaleTime(LocalDateTime saleTime);

	default ISale copyMembers(ISale source, boolean forced) {
		if ( source == null ) {
			return this;
		}
		if ( forced || source.getId() != null ) {
			this.setId(source.getId());
		}
		if ( forced || source.getQty() != null ) {
			this.setQty(source.getQty());
		}
		if ( forced || source.getPrice() != null ) {
			this.setPrice(source.getPrice());
		}
		if ( forced || source.getProduct() != null ) {
			this.setProduct(source.getProduct());
		}
		if ( forced || source.getSaleTime() != null ) {
			this.setSaleTime(source.getSaleTime());
		}
		return this;
	}
}
