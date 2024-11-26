package com.blsystem.repository;

import com.blsystem.entity.Blood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRepository extends JpaRepository<Blood, Long> {
}
