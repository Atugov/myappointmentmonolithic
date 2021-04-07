package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.ProvidedService;
import com.services.myappointmentmonolithtic.repository.JPAProvidedServiceRepository;

import java.util.List;

public class ProvidedServiceRepository {

    private final JPAProvidedServiceRepository providedServiceRepository;

    public ProvidedServiceRepository(JPAProvidedServiceRepository providedServiceRepository) {
        this.providedServiceRepository = providedServiceRepository;
    }

    public void saveProvidedService(ProvidedService providedService) {
        providedServiceRepository.save(providedService);
    }

    public void deleteProvidedService(ProvidedService providedService) {
        providedServiceRepository.delete(providedService);
    }

    public ProvidedService getProvidedServiceById(String id) {
        return providedServiceRepository.getOne(id);
    }

    public List<ProvidedService> getAllProvidedServices() {
        return providedServiceRepository.findAll();
    }

}
