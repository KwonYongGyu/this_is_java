package com.kyg.toeicvocabulary.service;

import com.kyg.toeicvocabulary.domain.Word;
import com.kyg.toeicvocabulary.exception.WordNotFoundException;
import com.kyg.toeicvocabulary.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kyg.toeicvocabulary.dto.WordRequest;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WordService {

    private final WordRepository wordRepository;

    // 등록
    @Transactional
    public Word save(Word word) {
        return wordRepository.save(word);
    }

    // 전체 조회
    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    // 단건 조회
    public Word findById(Long id) {
        return wordRepository.findById(id)
                .orElseThrow(() -> new WordNotFoundException(id));
    }

    // 수정
    @Transactional
    public Word update(Long id, Word updateData) {
        Word word = findById(id); // 없으면 여기서 예외 발생

        word.updateWord(
                updateData.getVocabulary(),
                updateData.getMeaning(),
                updateData.getExampleSentence()
        );
        return word;
    }

    // 삭제
    @Transactional
    public void delete(Long id) {
        Word word = findById(id); // 없으면 여기서 예외 발생
        wordRepository.delete(word);
    }
    @Transactional
    public Word save(WordRequest request) {
        Word word = Word.builder()
                .vocabulary(request.getVocabulary())
                .meaning(request.getMeaning())
                .exampleSentence(request.getExampleSentence())
                .build();
        return wordRepository.save(word);
    }

    public Page<Word> search(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        if (keyword == null || keyword.isBlank()) {
            return wordRepository.findAll(pageable);
        }
        return wordRepository.findByVocabularyContainingIgnoreCaseOrMeaningContainingIgnoreCase(
                keyword, keyword, pageable);
    }

    @Transactional
    public void toggleMemorized(Long id) {
        Word word = findById(id); // 없으면 예외 발생
        word.toggleMemorized(); // 3일차에 이미 만든 메서드, 더티 체킹으로 자동 반영
    }
}
