package com.blsystem.services;

import com.blsystem.dto.DonorDto;
import com.blsystem.entity.Donor;
import com.blsystem.entity.enums.BloodGroup;
import com.blsystem.exceptions.NotFoundException;
import com.blsystem.mappers.DonorMapper;
import com.blsystem.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.blsystem.mappers.DonorMapper.mapToDonorDto;

@Service
@RequiredArgsConstructor
public class DonorService {

    private final DonorRepository donorRepo;

    public DonorDto addDonor(DonorDto donorDto) {
        Donor donor = DonorMapper.mapToDonor(donorDto);
        Donor saveDonor = donorRepo.save(donor);
        return mapToDonorDto(saveDonor);
    }

    public DonorDto getDonorById(Long id) {
        Optional<Donor> donorOptional = donorRepo.findById(id);
        Donor donor = donorOptional.orElseThrow(() -> new NotFoundException("Donor not found"));
        return mapToDonorDto(donor);
    }

    public List<DonorDto> getAllDonors() {
        List<Donor> DonorList = donorRepo.findAll();
        return DonorList.stream().map(DonorMapper::mapToDonorDto)
                .collect(Collectors.toList());
    }

    public DonorDto updateDonor(DonorDto donorDto,  long id) {
        Donor donor = donorRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Donor not found "));

        donor.setName(donor.getName());
        donor.setGender(donorDto.getGender());
        donor.setAge(donorDto.getAge());
        donor.setAddress(donor.getAddress());
        donor.setContactNumber(donorDto.getContactNumber());
        donor.setBloodGroup(donorDto.getBloodGroup());
        donor.setLastDonationDate(donorDto.getLastDonationDate());
        donor.setEligible(donorDto.isEligible());


        Donor updatedDonor = donorRepo.save(donor);
        return mapToDonorDto(updatedDonor);
    }

    public void deleteDonor(Long id) {
        donorRepo.deleteById(id);
    }

    public long getDonorCount() {
      return donorRepo.count();
    }

    public Map<String, Long> getCountByBloodGroup() {
        Map<BloodGroup, Long> countByBloodGroup = donorRepo.findAll().stream()
                .collect(Collectors.groupingBy(Donor::getBloodGroup,
                        Collectors.counting()));

        // Convert BloodGroup keys to String
        return countByBloodGroup.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().toString(), Map.Entry::getValue));
    }


}
