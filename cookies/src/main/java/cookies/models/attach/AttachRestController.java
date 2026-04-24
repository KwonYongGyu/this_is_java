package cookies.models.attach;

import com.mjc813.cookies.models.attach.AttachDto;
import com.mjc813.cookies.models.attach.AttachService;
import com.mjc813.cookies.models.common.ApiResponse;
import com.mjc813.cookies.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attach")
public class AttachRestController {
	@Autowired
	private AttachService attachService;

	@PostMapping
	public ResponseEntity<ApiResponse<com.mjc813.cookies.models.attach.AttachDto>> insert(@RequestBody com.mjc813.cookies.models.attach.AttachDto insertDto) {
		com.mjc813.cookies.models.attach.AttachDto result = this.attachService.insert(insertDto);
		return ResponseEntity.status(201).body(
				ApiResponse.make(ResponseCode.insert_ok, "ok", result)
		);
	}

	@PatchMapping
	public ResponseEntity<ApiResponse<com.mjc813.cookies.models.attach.AttachDto>> update(@RequestBody com.mjc813.cookies.models.attach.AttachDto updateDto) {
		com.mjc813.cookies.models.attach.AttachDto result = this.attachService.update(updateDto);
		return ResponseEntity.status(200).body(
				ApiResponse.make(ResponseCode.update_ok, "ok", result)
		);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<com.mjc813.cookies.models.attach.AttachDto>> deleteById(@PathVariable Long id) {
		com.mjc813.cookies.models.attach.AttachDto result = this.attachService.deleteById(id);
		return ResponseEntity.status(200).body(
				ApiResponse.make(ResponseCode.delete_ok, "ok", result)
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<com.mjc813.cookies.models.attach.AttachDto>> findById(@PathVariable Long id) {
		com.mjc813.cookies.models.attach.AttachDto result = this.attachService.findById(id);
		return ResponseEntity.status(200).body(
				ApiResponse.make(ResponseCode.select_ok, "ok", result)
		);
	}

	@GetMapping("/cookie/{cookieId}")
	public ResponseEntity<ApiResponse<List<com.mjc813.cookies.models.attach.AttachDto>>> findAllByCookieId(@PathVariable Long cookieId) {
		List<AttachDto> result = this.attachService.findAllByCookieId(cookieId);
		return ResponseEntity.status(200).body(
				ApiResponse.make(ResponseCode.select_ok, "ok", result)
		);
	}
}
