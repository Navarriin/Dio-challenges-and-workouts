package com.navarro.padroesprojetospring.service;

import com.navarro.padroesprojetospring.models.Client;

public interface ClientService {

    Iterable<Client> getAll();
    Client getById(Long id);
    Client createClient(Client body);
    Client updateClient(Long id, Client body);
    void deleteClient(Long id);

}
