package com.blsystem.services;

import com.blsystem.dto.RecipientDto;
import com.blsystem.entity.Recipient;
import com.blsystem.exceptions.NotFoundException;
import com.blsystem.mappers.RecipientMapper;
import com.blsystem.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.blsystem.mappers.RecipientMapper.mapToRecipientDto;


@Service
@RequiredArgsConstructor
public class RecipientService {

    private final RecipientRepository RecipientRepo;

    public RecipientDto addRecipient(RecipientDto recipientDto) {
        Recipient recipient = RecipientMapper.mapToRecipient(recipientDto);
        Recipient saveRecipient = RecipientRepo.save(recipient);
        return mapToRecipientDto(saveRecipient);
    }

    public RecipientDto getRecipientById(Long id) {
        Optional<Recipient> RecipientOptional = RecipientRepo.findById(id);
        Recipient recipient = RecipientOptional.orElseThrow(() -> new NotFoundException("recipient not found"));
        return mapToRecipientDto(recipient);
    }

    public List<RecipientDto> getAllRecipient() {
        List<Recipient> recipientList = RecipientRepo.findAll();
        return recipientList.stream().map(RecipientMapper::mapToRecipientDto)
                .collect(Collectors.toList());
    }

    public RecipientDto updateRecipient(RecipientDto recipientDto,  long id) {
        Recipient recipient = RecipientRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Recipient not found "));

        recipient.setName(recipientDto.getName());
        recipient.setGender(recipientDto.getGender());
        recipient.setAge(recipientDto.getAge());
        recipient.setAddress(recipientDto.getAddress());
        recipient.setBenefitDate(recipientDto.getBenefitDate());
        recipient.setBloodGroup(recipientDto.getBloodGroup());
        recipient.setContactNumber(recipientDto.getContactNumber());
        recipient.setUrgent(recipientDto.isUrgent());   


        Recipient updatedRecipient = RecipientRepo.save(recipient);
        return mapToRecipientDto(updatedRecipient);
    }

    public void deleteRecipient(Long id) {
        RecipientRepo.deleteById(id);
    }

    public long getRecipientCount() {
        return RecipientRepo.count();
    }
}
