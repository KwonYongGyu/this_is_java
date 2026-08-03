package com.kyg.toeicvocabulary.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "word_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String vocabulary;

    @Column(nullable = false, length = 255)
    private String meaning;

    @Column(name = "example_sentence", nullable = false, length = 500)
    private String exampleSentence;

    @Column(name = "is_memorized", nullable = false)
    private boolean memorized = false;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Builder
    public Word(String vocabulary, String meaning, String exampleSentence) {
        this.vocabulary = vocabulary;
        this.meaning = meaning;
        this.exampleSentence = exampleSentence;
        this.memorized = false;
    }

    public void toggleMemorized() {
        this.memorized = !this.memorized;
    }

    public void updateWord(String vocabulary, String meaning, String exampleSentence) {
        this.vocabulary = vocabulary;
        this.meaning = meaning;
        this.exampleSentence = exampleSentence;
    }

}
