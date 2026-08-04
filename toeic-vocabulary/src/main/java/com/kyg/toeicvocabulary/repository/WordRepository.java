package com.kyg.toeicvocabulary.repository;

import com.kyg.toeicvocabulary.domain.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {

    // 단어 또는 뜻에 검색어가 포함된 항목을 페이징 조회 (대소문자 무시)
    Page<Word> findByVocabularyContainingIgnoreCaseOrMeaningContainingIgnoreCase(
            String vocabularyKeyword, String meaningKeyword, Pageable pageable);

    // 검색어 없을 때 전체 페이징 조회는 JpaRepository의 findAll(Pageable)을 그대로 사용
}
