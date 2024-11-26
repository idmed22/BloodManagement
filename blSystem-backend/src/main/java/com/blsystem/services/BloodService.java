package com.blsystem.services;

import com.blsystem.dto.BloodDto;
import com.blsystem.entity.Blood;
import com.blsystem.exceptions.NotFoundException;
import com.blsystem.mappers.BloodMapper;
import com.blsystem.repository.BloodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.blsystem.mappers.BloodMapper.mapToBloodDto;

@Service
@RequiredArgsConstructor
public class BloodService {

    public final BloodRepository bloodRepo;

    public BloodDto addBlood(BloodDto bloodDto) {
        Blood blood = BloodMapper.mapToBlood(bloodDto);
        Blood saveBlood = bloodRepo.save(blood);
        return mapToBloodDto(saveBlood);
    }

    public BloodDto getBloodById(Long id) {
        Optional<Blood> bloodOpt = bloodRepo.findById(id);
        Blood blood = bloodOpt.orElseThrow(() -> new NotFoundException("Blood not found"));
        return mapToBloodDto(blood);
    }


    public List<BloodDto> getAllBloods() {
        List<Blood> bloodList = bloodRepo.findAll();
        return bloodList.stream().map(BloodMapper::mapToBloodDto)
                .collect(Collectors.toList());
    }

    public BloodDto updateBlood(BloodDto bloodDto, long id) {
        Blood blood = bloodRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Blood not found"));

        blood.setType(bloodDto.getType());
        blood.setComponent(bloodDto.getComponent());
        blood.setCollectionDate(bloodDto.getCollectionDate());
        blood.setExpiryDate(bloodDto.getExpiryDate());
        blood.setStatus(bloodDto.getStatus());

        Blood  updateBlood = bloodRepo.save(blood);
        return mapToBloodDto(updateBlood);
    }

    public void deleteBlood(Long id) {
        bloodRepo.deleteById(id);
    }



}
