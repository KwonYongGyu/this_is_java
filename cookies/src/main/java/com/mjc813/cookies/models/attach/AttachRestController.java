package com.mjc813.cookies.models.attach;

import com.mjc813.cookies.models.common.ApiResponse;
import com.mjc813.cookies.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attach")
public class AttachRestController {
	@Autowired
	private AttachService attachService;

	@PostMapping
	public ResponseEntity<ApiResponse<AttachDto>> insert(@RequestBody AttachDto insertDto) {
		AttachDto result = this.attachService.insert(insertDto);
		return ResponseEntity.status(201).body(
				ApiResponse.make(ResponseCode.insert_ok, "ok", result)
		);
	}
}
