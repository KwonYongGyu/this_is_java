package com.kyg.toeicvocabulary.controller;

import com.kyg.toeicvocabulary.domain.Word;
import com.kyg.toeicvocabulary.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    // 등록
    @PostMapping
    public ResponseEntity<Word> create(@RequestBody Word word) {
        Word saved = wordService.save(word);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<Word>> findAll() {
        return ResponseEntity.ok(wordService.findAll());
    }

    // 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<Word> findById(@PathVariable Long id) {
        return ResponseEntity.ok(wordService.findById(id));
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<Word> update(@PathVariable Long id, @RequestBody Word updateData) {
        Word updated = wordService.update(id, updateData);
        return ResponseEntity.ok(updated);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        wordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
