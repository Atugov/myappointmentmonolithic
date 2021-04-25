package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.Client;
import com.services.myappointmentmonolithtic.repository.JPAClientRepository;
import com.services.myappointmentmonolithtic.repository.JPAUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    private final JPAClientRepository clientRepository;



    private static final Logger LOG = LoggerFactory.getLogger(ClientService.class);

    public ClientService(JPAClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    public void saveClient(Client client) {
        LOG.debug("saveClient(), saving client");
        clientRepository.save(client);
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void deleteClient(Client client) {
        LOG.debug("deleteClient(), deleting client");
        clientRepository.delete(client);
    }

    public List<Client> getAllClients() {
        LOG.debug("getAllClients(), getting all clients");
        return clientRepository.findAll();

    }
}
