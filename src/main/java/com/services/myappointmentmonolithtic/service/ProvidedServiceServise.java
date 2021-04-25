package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.ProvidedService;
import com.services.myappointmentmonolithtic.repository.JPAProvidedServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProvidedServiceServise {
    private JPAProvidedServiceRepository serviceRepository;


    ProvidedServiceServise(JPAProvidedServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void saveProvidedService(ProvidedService providedService) {
        serviceRepository.save(providedService);
    }

    public void deleteProvidedService(ProvidedService providedService) {
        serviceRepository.delete(providedService);
    }

    public List<ProvidedService> getAllProvidedServices() {
        return serviceRepository.findAll();
    }

    public List<ProvidedService> getAllProvidedServicesByEmployeeId(String id) {
        return serviceRepository.findAllByEmployeeId(id);
    }

    public ProvidedService getProvidedServiceById(String id) {
        return serviceRepository.findById(id).orElseThrow(NullPointerException::new);
    }

}
