package com.mjc813.swim_db.models.swimpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SwimPoolService {
    @Autowired
    private SwimPoolRepository swimPoolRepository;

    public SwimPoolDto insert(SwimPoolDto insertDto) {
        SwimPoolEntity entity = (SwimPoolEntity) new SwimPoolEntity().copyMembers(insertDto, true);
        entity.setId(null); // 신규 등록이므로 ID 초기화
        SwimPoolEntity save = this.swimPoolRepository.save(entity);
        return (SwimPoolDto) new SwimPoolDto().copyMembers(save, true);
    }

    public SwimPoolDto update(SwimPoolDto updateDto) {
        SwimPoolEntity find = this.swimPoolRepository.findById(updateDto.getId()).orElseThrow();
        SwimPoolEntity updateEntity = (SwimPoolEntity) new SwimPoolEntity().copyMembers(find, true);
        updateEntity.copyMembers(updateDto, false); // 수정할 값만 복사
        SwimPoolEntity save = this.swimPoolRepository.save(updateEntity);
        return (SwimPoolDto) new SwimPoolDto().copyMembers(save, true);
    }

    public SwimPoolDto findById(Long id) {
        SwimPoolEntity find = this.swimPoolRepository.findById(id).orElseThrow();
        return (SwimPoolDto) new SwimPoolDto().copyMembers(find, true);
    }

    public SwimPoolDto deleteById(Long id) {
        SwimPoolDto find = this.findById(id);
        this.swimPoolRepository.deleteById(id);
        return find;
    }

    public Slice<SwimPoolDto> findByNameContains(String name, Pageable pageable) {
        Slice<SwimPoolEntity> slc = this.swimPoolRepository.findByNameContains(name, pageable);
        List<SwimPoolDto> list = slc.getContent().stream()
                .map(t -> (SwimPoolDto) new SwimPoolDto().copyMembers(t, true))
                .toList();
        return new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
    }
}