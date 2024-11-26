package com.blsystem.repository;

import com.blsystem.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {

}
