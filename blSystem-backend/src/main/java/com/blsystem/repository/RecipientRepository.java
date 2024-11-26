package com.blsystem.repository;

import com.blsystem.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
