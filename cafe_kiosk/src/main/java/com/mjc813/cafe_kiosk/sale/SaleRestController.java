package com.mjc813.cafe_kiosk.sale;

import com.mjc813.cafe_kiosk.common.ApiResponse;
import com.mjc813.cafe_kiosk.common.CafeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/sale")
public class SaleRestController {

	@Autowired
	private SaleService saleService;

	@PostMapping
	public ResponseEntity<ApiResponse<SaleDto>> insert(@RequestBody SaleDto newDto) {
		SaleDto result = this.saleService.insert(newDto);
		ApiResponse<SaleDto> response = ApiResponse.make(CafeResponse.insert_success, "ok", result);
		return ResponseEntity.status(201).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<SaleDto>> findById(@PathVariable Integer id) {
		SaleDto result = this.saleService.findById(id);
		ApiResponse<SaleDto> response = ApiResponse.make(CafeResponse.select_success, "ok", result);
		return ResponseEntity.status(200).body(response);
	}

	@PatchMapping
	public ResponseEntity<ApiResponse<SaleDto>> update(@RequestBody SaleDto updateDto) {
		SaleDto result = this.saleService.update(updateDto);
		ApiResponse<SaleDto> response = ApiResponse.make(CafeResponse.update_success, "ok", result);
		return ResponseEntity.status(201).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<SaleDto>> deleteById(@RequestParam Integer id) {
		SaleDto result = this.saleService.deleteById(id);
		ApiResponse<SaleDto> response = ApiResponse.make(CafeResponse.delete_success, "ok", result);
		return ResponseEntity.status(200).body(response);
	}

	@GetMapping("/prd/{productId}")
	public ResponseEntity<ApiResponse<Slice<SaleDto>>> findByProductEquals(@PathVariable Integer productId
			, @PageableDefault(page = 0, sort="saleTime", direction = Sort.Direction.DESC, size = 10) Pageable pageable
	) {
			Slice<SaleDto> result = this.saleService.findByProductEquals(productId, pageable);
			ApiResponse<Slice<SaleDto>> response = ApiResponse.make(CafeResponse.select_success, "ok", result);
			return ResponseEntity.status(200).body(response);
	}

	@GetMapping("/data")
	public ResponseEntity<ApiResponse<Long>> sumPriceBySaleTimeAtBetween(@RequestParam LocalDate start
																		, @RequestParam LocalDate end
	) {
		Long result = this.saleService.sumPriceBySaleTimeAtBetween(start, end);
		ApiResponse<Long> response = ApiResponse.make(CafeResponse.select_success, "ok", result);
		return ResponseEntity.status(200).body(response);
		}
	}

}
