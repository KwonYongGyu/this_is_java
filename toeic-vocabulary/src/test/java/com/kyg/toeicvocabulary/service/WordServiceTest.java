package com.kyg.toeicvocabulary.service;

import com.kyg.toeicvocabulary.domain.Word;
import com.kyg.toeicvocabulary.exception.WordNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class WordServiceTest {

    @Autowired
    private WordService wordService;

    @Autowired
    private com.kyg.toeicvocabulary.repository.WordRepository wordRepository;

    @AfterEach
    void tearDown() {
        wordRepository.deleteAll();
    }

    @Test
    void 단어를_등록하고_조회한다() {
        Word word = Word.builder()
                .vocabulary("persistent")
                .meaning("끈질긴")
                .exampleSentence("He is persistent in his efforts.")
                .build();

        Word saved = wordService.save(word);
        Word found = wordService.findById(saved.getId());

        assertThat(found.getVocabulary()).isEqualTo("persistent");
    }

    @Test
    void 존재하지_않는_단어를_조회하면_예외가_발생한다() {
        assertThatThrownBy(() -> wordService.findById(999L))
                .isInstanceOf(WordNotFoundException.class);
    }

    @Test
    void 단어를_수정한다() {
        Word word = wordService.save(Word.builder()
                .vocabulary("old")
                .meaning("옛날의")
                .exampleSentence("old sentence")
                .build());

        Word updateData = Word.builder()
                .vocabulary("new")
                .meaning("새로운")
                .exampleSentence("new sentence")
                .build();

        wordService.update(word.getId(), updateData);
        Word result = wordService.findById(word.getId());

        assertThat(result.getVocabulary()).isEqualTo("new");
    }

    @Test
    void 단어를_삭제한다() {
        Word word = wordService.save(Word.builder()
                .vocabulary("delete_me")
                .meaning("삭제될 단어")
                .exampleSentence("this will be deleted")
                .build());

        wordService.delete(word.getId());

        assertThatThrownBy(() -> wordService.findById(word.getId()))
                .isInstanceOf(WordNotFoundException.class);
    }
}
