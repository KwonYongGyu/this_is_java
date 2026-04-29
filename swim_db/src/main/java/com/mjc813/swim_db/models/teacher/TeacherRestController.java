package com.mjc813.swim_db.models.teacher;

import com.mjc813.swim_db.models.common.ApiResponse;
import com.mjc813.swim_db.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherRestController {

    @Autowired
    private TeacherService teacherService;

    // 등록
    @PostMapping
    public ResponseEntity<ApiResponse<TeacherDto>> insert(@RequestBody TeacherDto insertDto) {
        TeacherDto result = this.teacherService.insert(insertDto);
        return ResponseEntity.status(201).body(
                ApiResponse.make(ResponseCode.insert_ok, "ok", result)
        );
    }

    // 수정
    @PatchMapping
    public ResponseEntity<ApiResponse<TeacherDto>> update(@RequestBody TeacherDto updateDto) {
        TeacherDto result = this.teacherService.update(updateDto);
        return ResponseEntity.status(200).body(
                ApiResponse.make(ResponseCode.update_ok, "ok", result)
        );
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> deleteById(@PathVariable Long id) {
        TeacherDto result = this.teacherService.deleteById(id);
        return ResponseEntity.status(200).body(
                ApiResponse.make(ResponseCode.delete_ok, "ok", result)
        );
    }

    // 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> findById(@PathVariable Long id) {
        TeacherDto result = this.teacherService.findById(id);
        return ResponseEntity.status(200).body(
                ApiResponse.make(ResponseCode.select_ok, "ok", result)
        );
    }
}