package com.mjc813.swim_db.models.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherDto insert(TeacherDto insertDto) {
        TeacherEntity entity = (TeacherEntity) new TeacherEntity().copyMembers(insertDto, true);
        entity.setId(null);
        TeacherEntity save = this.teacherRepository.save(entity);
        return (TeacherDto) new TeacherDto().copyMembers(save, true);
    }

    public TeacherDto update(TeacherDto updateDto) {
        TeacherEntity find = this.teacherRepository.findById(updateDto.getId()).orElseThrow();
        TeacherEntity updateEntity = (TeacherEntity) new TeacherEntity().copyMembers(find, true);
        updateEntity.copyMembers(updateDto, false);
        TeacherEntity save = this.teacherRepository.save(updateEntity);
        return (TeacherDto) new TeacherDto().copyMembers(save, true);
    }

    public TeacherDto findById(Long id) {
        TeacherEntity find = this.teacherRepository.findById(id).orElseThrow();
        return (TeacherDto) new TeacherDto().copyMembers(find, true);
    }

    public TeacherDto deleteById(Long id) {
        TeacherDto find = this.findById(id);
        this.teacherRepository.deleteById(id);
        return find;
    }

    public Slice<TeacherDto> findByNameContains(String name, Pageable pageable) {
        Slice<TeacherEntity> slc = this.teacherRepository.findByNameContains(name, pageable);
        List<TeacherDto> list = slc.getContent().stream()
                .map(t -> (TeacherDto) new TeacherDto().copyMembers(t, true))
                .toList();
        return new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
    }
}