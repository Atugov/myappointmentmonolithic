package com.services.myappointmentmonolithtic.repository;

import com.services.myappointmentmonolithtic.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAProvidedServiceRepository extends JpaRepository<ProvidedService, String> {
}
