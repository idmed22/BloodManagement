package com.blsystem.controllers;

import com.blsystem.dto.BloodDto;
import com.blsystem.dto.DonorDto;
import com.blsystem.services.BloodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bloods")
@RequiredArgsConstructor
public class BloodController {

    private final BloodService service;

    @PostMapping
    public ResponseEntity<BloodDto> addBlood(@RequestBody @Valid BloodDto bloodDto){
        BloodDto saveBlood = service.addBlood(bloodDto);
        return new ResponseEntity<>(saveBlood, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BloodDto> getBloodById(@PathVariable("id") Long id) {
        BloodDto bloodDto = service.getBloodById(id);
        return new ResponseEntity<>(bloodDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BloodDto>> getAllBloods(){
        List<BloodDto> bloodDto = service.getAllBloods();
        return new ResponseEntity<>(bloodDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BloodDto> updateBlood(@Valid @PathVariable("id") Long id,
                                                @RequestBody BloodDto bloodDto){

        BloodDto updatedBlood = service.updateBlood(bloodDto, id);
        return new ResponseEntity<>(updatedBlood, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBlood(@PathVariable("id") Long id){
        service.deleteBlood(id);
        return new ResponseEntity<>("Blood successfully deleted!", HttpStatus.OK);
    }





}
