package com.kyg.toeicvocabulary.service;

import com.kyg.toeicvocabulary.domain.Word;
import com.kyg.toeicvocabulary.exception.WordNotFoundException;
import com.kyg.toeicvocabulary.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kyg.toeicvocabulary.dto.WordRequest;
import java.util.List;

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
}
