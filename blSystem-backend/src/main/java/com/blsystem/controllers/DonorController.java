package com.blsystem.controllers;

import com.blsystem.dto.DonorDto;
import com.blsystem.entity.enums.BloodGroup;
import com.blsystem.repository.DonorRepository;
import com.blsystem.services.DonorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;
    private final DonorRepository repo;

    // http://localhost:8080/api/donors
    @PostMapping
    public ResponseEntity<DonorDto> addDonor(@RequestBody @Valid DonorDto donorDto){
        DonorDto savedDonor = donorService.addDonor(donorDto);
        return new ResponseEntity<>(savedDonor, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/donors/1
    @GetMapping("{id}")
    public ResponseEntity<DonorDto> getDonorById(@PathVariable("id") Long id){
        DonorDto donorDto = donorService.getDonorById(id);
        return new ResponseEntity<>(donorDto, HttpStatus.OK);
    }

    // http://localhost:8080/api/donors
    @GetMapping
    public ResponseEntity<List<DonorDto>> getAllDonors(){
        List<DonorDto> donorDto = donorService.getAllDonors();
        return new ResponseEntity<>(donorDto, HttpStatus.OK);
    }

    // http://localhost:8080/api/donors/1
    @PutMapping("{id}")
    public ResponseEntity<DonorDto> updateDonor(@Valid @PathVariable("id") Long id,
                                                    @RequestBody DonorDto donorDto){

        DonorDto updatedDonor = donorService.updateDonor(donorDto, id);
        return new ResponseEntity<>(updatedDonor, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDonor(@PathVariable("id") Long id){
        donorService.deleteDonor(id);
        return new ResponseEntity<>("Donor successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getDonorCount() {
        long donorCount = donorService.getDonorCount();
        return ResponseEntity.ok().body(donorCount);
    }

    @GetMapping("/countByBloodGroup")
    public ResponseEntity<Map<String, Long>> getCountByBloodGroup() {
        return ResponseEntity.ok(donorService.getCountByBloodGroup());
    }





}
