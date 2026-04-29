package com.mjc813.swim_db.models.swimpool;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwimPoolRepository extends JpaRepository<SwimPoolEntity, Long> {
    // 이름으로 검색하는 기능 추가
    Slice<SwimPoolEntity> findByNameContains(String name, Pageable pageable);
}
