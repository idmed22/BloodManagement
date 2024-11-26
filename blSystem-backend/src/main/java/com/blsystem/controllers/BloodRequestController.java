package com.blsystem.controllers;

import com.blsystem.dto.RequestDto;
import com.blsystem.entity.Donor;
import com.blsystem.services.BloodRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/requests")
@RequiredArgsConstructor
public class BloodRequestController {


    public final BloodRequestService requestService;

    // http://localhost:8080/api/requests
    @PostMapping
    public ResponseEntity<RequestDto> addRequest(@RequestBody @Valid RequestDto requestDto){
        RequestDto savedRequest = requestService.addRequest(requestDto);
        return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/requests/1
    @GetMapping("{id}")
    public ResponseEntity<RequestDto> getRequestById(@PathVariable("id") Long id){
        RequestDto requestDto = requestService.getRequestById(id);
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

    // http://localhost:8080/api/requests
    @GetMapping
    public ResponseEntity<List<RequestDto>> getAllRequests(){
        List<RequestDto> requestDto = requestService.getAllRequests();
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }

    // http://localhost:8080/api/requests/1
    @PutMapping("{id}")
    public ResponseEntity<RequestDto> updateRequest(@Valid @PathVariable("id") Long id,
                                                @RequestBody RequestDto requestDto){

        RequestDto updatedRequest = requestService.updateRequest(requestDto, id);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") Long id){
        requestService.deleteRequest(id);
        return new ResponseEntity<>("Request successfully deleted!", HttpStatus.OK);
    }

    @PostMapping("/{id}/assign-donor")
    public ResponseEntity<String> assignDonor(@PathVariable("id") Long id, @RequestBody Donor donor) {
        requestService.assignDonor(id, donor);
        return ResponseEntity.ok("Donor assigned successfully to request with ID: " + id);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<String> trackRequestStatus(@PathVariable("id") Long requestId) {
        String status = requestService.trackRequestStatus(requestId);
        return ResponseEntity.ok(status);
    }
}