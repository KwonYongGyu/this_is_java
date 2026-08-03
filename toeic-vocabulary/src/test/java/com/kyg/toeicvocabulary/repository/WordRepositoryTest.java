package com.kyg.toeicvocabulary.repository;

import com.kyg.toeicvocabulary.domain.Word;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class WordRepositoryTest {

@Autowired
    private WordRepository wordRepository;

    @AfterEach
    void tearDown() {
        wordRepository.deleteAll();
    }

    @Test
    void 단어를_저장하고_조회한다() {
        Word word = Word.builder()
                .vocabulary("abandon")
                .meaning("버리다, 포기하다")
                .exampleSentence("He abandoned his car in the snow.")
                .build();

        wordRepository.save(word);
        List<Word> words = wordRepository.findAll();

        assertThat(words).hasSize(1);
        assertThat(words.get(0).getVocabulary()).isEqualTo("abandon");
        assertThat(words.get(0).getMeaning()).isEqualTo("버리다, 포기하다");
        assertThat(words.get(0).isMemorized()).isFalse();
    }

    @Test
    void 암기_여부를_토글한다() {
        Word word = Word.builder()
                .vocabulary("diligent")
                .meaning("근면한")
                .exampleSentence("She is a diligent student.")
                .build();
        wordRepository.save(word);

        word.toggleMemorized();
        wordRepository.save(word);

        Word found = wordRepository.findAll().get(0);
        assertThat(found.isMemorized()).isTrue();
    }
}
