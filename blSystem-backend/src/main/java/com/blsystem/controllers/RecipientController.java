package com.blsystem.controllers;

import com.blsystem.dto.RecipientDto;
import com.blsystem.services.RecipientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recipients")
@RequiredArgsConstructor
public class RecipientController {

    private final RecipientService recipientService;

    // http://localhost:8080/api/recipients
    @PostMapping
    public ResponseEntity<RecipientDto> addRecipient(@RequestBody @Valid RecipientDto recipientDto){
        RecipientDto savedRecipient = recipientService.addRecipient(recipientDto);
        return new ResponseEntity<>(savedRecipient, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/recipients/1
    @GetMapping("{id}")
    public ResponseEntity<RecipientDto> getRecipientById(@PathVariable("id") Long id){
        RecipientDto recipientDto = recipientService.getRecipientById(id);
        return new ResponseEntity<>(recipientDto, HttpStatus.OK);
    }

    // http://localhost:8080/api/recipients
    @GetMapping
    public ResponseEntity<List<RecipientDto>> getAllRecipients(){
        List<RecipientDto> recipientDto = recipientService.getAllRecipient();
        return new ResponseEntity<>(recipientDto, HttpStatus.OK);
    }

    // http://localhost:8080/api/recipients/1
    @PutMapping("{id}")
    public ResponseEntity<RecipientDto> updateRecipient(@Valid @PathVariable("id") Long id,
                                                          @RequestBody RecipientDto recipientDto){

        RecipientDto updatedRecipient = recipientService.updateRecipient(recipientDto, id);
        return new ResponseEntity<>(updatedRecipient, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRecipient(@PathVariable("id") Long id){
        recipientService.deleteRecipient(id);
        return new ResponseEntity<>("Recipient successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getRecipientCount() {
        long recipientCount = recipientService.getRecipientCount();
        return ResponseEntity.ok().body(recipientCount);
    }
}
