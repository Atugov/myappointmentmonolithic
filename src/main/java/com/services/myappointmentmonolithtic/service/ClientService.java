package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.Client;
import com.services.myappointmentmonolithtic.repository.JPAClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {

    private final JPAClientRepository clientRepository;

    public ClientService(JPAClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(Client client){
        clientRepository.save(client);
    }
    public void deleteClient(Client client){
        clientRepository.delete(client);
    }
    public List<Client> getClientsByName(String name){
        return clientRepository.findClientsByName(name);
    }
    public List<Client> getClientsByDateOfBirth(LocalDate dateOfBirth){
        return null;
    }
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    public Client getClientById(Long id){
        return clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
