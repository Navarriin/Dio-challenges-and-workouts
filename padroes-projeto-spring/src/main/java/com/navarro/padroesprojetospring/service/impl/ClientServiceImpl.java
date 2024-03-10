package com.navarro.padroesprojetospring.service.impl;

import com.navarro.padroesprojetospring.models.Client;
import com.navarro.padroesprojetospring.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public Iterable<Client> getAll() {
        return null;
    }

    @Override
    public Client getById(Long id) {
        return null;
    }

    @Override
    public Client createClient(Client body) {
        return null;
    }

    @Override
    public Client updateClient(Long id, Client body) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }
}
