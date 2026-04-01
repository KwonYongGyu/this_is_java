package com.mjc813.petapp.pet.svc;

import com.mjc813.petapp.pet.dto.PetDto;
import com.mjc813.petapp.pet.dto.PetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public PetDto insert(PetDto petDto) {
        PetEntity petEntity = new PetEntity();
        petEntity.setId(null);
        petEntity.setName(petDto.getName());
        petEntity.setBirth(petDto.getBirth());
        petEntity.setBreed(petDto.getBreed());
        petEntity.setGender(petDto.getGender());
        petEntity.setImgFile(petDto.getImgFile());
        petEntity.setSpecies(petDto.getSpecies());

        this.petRepository.save(petEntity);

        petDto.setId(petEntity.getId());
        return petDto;
    }

    public PetDto update(PetDto petDto) {
        PetEntity petEntity = new PetEntity();
        petEntity.setId(petDto.getId());
        petEntity.setName(petDto.getName());
        petEntity.setBirth(petDto.getBirth());
        petEntity.setBreed(petDto.getBreed());
        petEntity.setGender(petDto.getGender());
        petEntity.setImgFile(petDto.getImgFile());
        petEntity.setSpecies(petDto.getSpecies());

        this.petRepository.save(petEntity);

        PetDto result = new PetDto();
        result.setId(petEntity.getId());
        result.setName(petEntity.getName());
        result.setBirth(petEntity.getBirth());
        result.setBreed(petEntity.getBreed());
        result.setGender(petEntity.getGender());
        result.setImgFile(petEntity.getImgFile());
        result.setSpecies(petEntity.getSpecies());
        return result;
    }
}
