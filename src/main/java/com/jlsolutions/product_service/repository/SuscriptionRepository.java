package com.jlsolutions.product_service.repository;

import com.jlsolutions.product_service.model.Suscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuscriptionRepository extends JpaRepository<Suscription, Long> {
}