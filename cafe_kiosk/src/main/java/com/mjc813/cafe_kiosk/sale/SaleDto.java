package com.mjc813.cafe_kiosk.sale;

import com.mjc813.cafe_kiosk.models.product.IProduct;
import com.mjc813.cafe_kiosk.models.product.ProductDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDto implements ISale {
	private Integer id;
	private ProductDto product = new ProductDto();;
	private Integer qty;
	private Integer price;
	private LocalDateTime saleTime;

	@Override
	public void setProduct(IProduct source) {
		if ( source == null ) {
			return;
		}
		this.product.copyMembers(source, true);
	}
}
