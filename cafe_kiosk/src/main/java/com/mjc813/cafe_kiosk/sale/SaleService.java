package com.mjc813.cafe_kiosk.sale;

import com.mjc813.cafe_kiosk.models.product.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
	private final SaleRepository saleRepository;

	public SaleDto insert(SaleDto newDto) {
		SaleEntity newEntity = new SaleEntity();
		newEntity.copyMembers(newDto, true);
		newEntity.setId(null);
		SaleEntity save = this.saleRepository.save(newEntity);
		SaleDto result = new SaleDto();
		result.copyMembers(save, true);
		return result;
	}

	public SaleDto findById(Integer id) {
		SaleEntity find = this.saleRepository.findById(id).orElseThrow();
		SaleDto result = new SaleDto();
		result.copyMembers(find, true);
		return result;
	}

	public SaleDto update(SaleDto updateDto) {
		SaleEntity findEntity = this.saleRepository.findById(updateDto.getId()).orElseThrow();
		SaleEntity updateEntity = new SaleEntity();
		updateEntity.copyMembers(findEntity, true);
		updateEntity.copyMembers(updateDto, false);
		SaleEntity save = this.saleRepository.save(updateEntity);
		SaleDto result = new SaleDto();
		result.copyMembers(save, true);
		return result;
	}

	public SaleDto deleteById(Integer id) {
		SaleEntity findEntity = this.saleRepository.findById(id).orElseThrow();
		SaleDto result = new SaleDto();
		result.copyMembers(findEntity, true);
		return result;
	}

	public Slice<SaleDto> findByProductEquals(Integer productId, Pageable pageable) {
		ProductEntity productEntity = ProductEntity.builder().id(productId).build();
		Slice<SaleEntity> findList = this.saleRepository.findByProductEquals(productEntity, pageable);
		List<SaleDto> list = findList.getContent().stream()
				.map(x -> (SaleDto)new SaleDto().copyMembers(x, true))
				.toList();
		Slice<SaleDto> result = new SliceImpl<SaleDto>(list, findList.getPageable(), findList.hasNext());
		return result;
	}

	public Long sumPriceBySaleTimeAtBetween(LocalDate start, LocalDate end) {
		LocalDateTime startOfDay = start.atStartOfDay();
		LocalDateTime endOfDay = end.plusDays(1).atStartOfDay();
		Long result = this.saleRepository.sumPriceBySaleTimeAtBetween(startOfDay, endOfDay);
		return result;
	}
}
