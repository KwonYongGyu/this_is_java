package com.mjc813.petapp.pet.cntr;

import com.mjc813.petapp.pet.PetResponseDto;
import com.mjc813.petapp.pet.dto.PetDto;
import com.mjc813.petapp.pet.dto.PetEntity;
import com.mjc813.petapp.pet.svc.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pet")
public class PetRestController {
    @Autowired
    public PetService petService;

    @PostMapping
    public ResponseEntity<PetResponseDto> insertPet(@RequestBody PetDto petDto) {
        try {
            PetDto result = this.petService.insert(petDto);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }
}
