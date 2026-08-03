package com.kyg.toeicvocabulary.repository;

import com.kyg.toeicvocabulary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WordRepository extends JpaRepository<Word, Long> {
}
