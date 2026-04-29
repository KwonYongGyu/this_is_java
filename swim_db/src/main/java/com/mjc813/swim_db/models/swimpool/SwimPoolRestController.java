package com.mjc813.swim_db.models.swimpool;

import com.mjc813.swim_db.models.common.ApiResponse; // 패키지 경로는 프로젝트에 맞게 수정하세요
import com.mjc813.swim_db.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/swimpool")
public class SwimPoolRestController {

    @Autowired
    private SwimPoolService swimPoolService;

    // 등록 (Create)
    @PostMapping
    public ResponseEntity<ApiResponse<SwimPoolDto>> insert(@RequestBody SwimPoolDto insertDto) {
        SwimPoolDto result = this.swimPoolService.insert(insertDto);
        return ResponseEntity.status(201).body(
                ApiResponse.make(ResponseCode.insert_ok, "ok", result)
        );
    }

    // 수정 (Update)
    @PatchMapping
    public ResponseEntity<ApiResponse<SwimPoolDto>> update(@RequestBody SwimPoolDto updateDto) {
        SwimPoolDto result = this.swimPoolService.update(updateDto);
        return ResponseEntity.status(200).body(
                ApiResponse.make(ResponseCode.update_ok, "ok", result)
        );
    }

    // 삭제 (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SwimPoolDto>> deleteById(@PathVariable Long id) {
        SwimPoolDto result = this.swimPoolService.deleteById(id);
        return ResponseEntity.status(200).body(
                ApiResponse.make(ResponseCode.delete_ok, "ok", result)
        );
    }

    // 단일 조회 (Read One)
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SwimPoolDto>> findById(@PathVariable Long id) {
        SwimPoolDto result = this.swimPoolService.findById(id);
        return ResponseEntity.status(200).body(
                ApiResponse.make(ResponseCode.select_ok, "ok", result)
        );
    }
}