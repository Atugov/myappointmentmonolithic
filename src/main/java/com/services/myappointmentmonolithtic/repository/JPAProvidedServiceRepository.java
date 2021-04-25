package com.services.myappointmentmonolithtic.repository;

import com.services.myappointmentmonolithtic.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAProvidedServiceRepository extends JpaRepository<ProvidedService, String> {
    List<ProvidedService> findAllByEmployeeId(String id);
}
