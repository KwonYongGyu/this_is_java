package com.kyg.toeicvocabulary.exception;

public class WordNotFoundException extends RuntimeException {
    public WordNotFoundException(Long id) {
        super("해당 ID의 단어를 찾을 수 없습니다: " + id);
    }
}
