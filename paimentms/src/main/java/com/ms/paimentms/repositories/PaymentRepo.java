package com.ms.paimentms.repositories;

import com.ms.paimentms.entities.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Paiment,Integer> {
}
