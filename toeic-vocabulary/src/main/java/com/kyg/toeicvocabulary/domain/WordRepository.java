package com.kyg.toeicvocabulary.domain;

import com.kyg.toeicvocabulary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WordRepository extends JpaRepository<Word, Long> {
}
