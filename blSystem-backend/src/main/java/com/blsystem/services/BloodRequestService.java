package com.blsystem.services;

import com.blsystem.dto.RequestDto;
import com.blsystem.entity.Donor;
import com.blsystem.entity.Request;
import com.blsystem.entity.enums.RequestStatus;
import com.blsystem.exceptions.NotFoundException;
import com.blsystem.mappers.RequestMapper;
import com.blsystem.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.blsystem.mappers.RequestMapper.mapToRequestDto;

@Service
@RequiredArgsConstructor
public class BloodRequestService {

    public final RequestRepository requestRepo;

    public RequestDto addRequest(RequestDto requestDto) {
        Request request = RequestMapper.mapToRequest(requestDto);
        Request saveRequest = requestRepo.save(request);
        return mapToRequestDto(saveRequest);
    }

    public RequestDto getRequestById(Long id) {
        Optional<Request> requestOpt = requestRepo.findById(id);
        Request request = requestOpt.orElseThrow(() -> new NotFoundException("Request not found"));
        return mapToRequestDto(request);
    }

    public List<RequestDto> getAllRequests() {
        List<Request> requestList = requestRepo.findAll();
        return requestList.stream().map(RequestMapper::mapToRequestDto)
                .collect(Collectors.toList());
    }

    public RequestDto updateRequest(RequestDto requestDto,  long id) {
        Request request = requestRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Request not found "));

        request.setRecipientId(requestDto.getRecipientId());
        request.setRequestDate(requestDto.getRequestDate());
        request.setBloodGroup(requestDto.getBloodGroup());
        request.setUrgent(requestDto.isUrgent());


        Request updatedRequest = requestRepo.save(request);
        return mapToRequestDto(updatedRequest);
    }

    public void deleteRequest(Long id) {
        requestRepo.deleteById(id);
    }

    public void assignDonor(Long id, Donor donor) {
        Request request = requestRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Request not found with id: " + id));

        request.setStatus(RequestStatus.ASSIGNED);

        requestRepo.save(request);
        System.out.println("Assigned donor to request with ID: " + id);
    }

    public String trackRequestStatus(Long requestId) {
        Request request = requestRepo.findById(requestId)
                .orElseThrow(() -> new NotFoundException("Request with ID " + requestId + " not found."));

        return "Request status for request ID " + requestId + ": " + request.getStatus();
    }
}