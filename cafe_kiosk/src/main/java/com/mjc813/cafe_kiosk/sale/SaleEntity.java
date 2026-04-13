package com.mjc813.cafe_kiosk.sale;

import com.mjc813.cafe_kiosk.models.product.IProduct;
import com.mjc813.cafe_kiosk.models.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "sale")
public class SaleEntity implements ISale  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JoinColumn(name = "product_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductEntity product = new ProductEntity();

	@Column(nullable = false)
	private Integer qty;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = true)
	private LocalDateTime saleTime;

	@Override
	public void setProduct(IProduct source) {
		if ( source == null ) {
			return;
		}
		this.product.copyMembers(source, true);
	}
}
