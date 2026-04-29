package com.mjc813.swim_db.models.teacher;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    Slice<TeacherEntity> findByNameContains(String name, Pageable pageable);
}