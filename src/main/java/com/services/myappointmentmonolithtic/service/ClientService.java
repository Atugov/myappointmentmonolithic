package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.Client;
import com.services.myappointmentmonolithtic.repository.JPAClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ClientService {

    private final JPAClientRepository clientRepository;

    private static final Logger LOG = LoggerFactory.getLogger(ClientService.class);

    public ClientService(JPAClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(Client client){
        LOG.debug("saveClient(), saving client");
        clientRepository.save(client);
    }
    public void deleteClient(Client client){
        LOG.debug("deleteClient(), deleting client");
        clientRepository.delete(client);
    }
    public List<Client> getClientsByName(String name){
        LOG.debug("getClientsByName(), getting clients by name");
        return clientRepository.findClientsByName(name);
    }
    public List<Client> getClientsByDateOfBirth(LocalDate dateOfBirth){
        LOG.debug("getClientsByDateOfBirth(), getting clients by date of birth");
        return null;
    }
    public List<Client> getAllClients(){
        LOG.debug("getAllClients(), getting all clients");
        return clientRepository.findAll();
    }
    public Client getClientById(Long id){
        LOG.debug("getClientById(), getting clients by id");
        return clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
