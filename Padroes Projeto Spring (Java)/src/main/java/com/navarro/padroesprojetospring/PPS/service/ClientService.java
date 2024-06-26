package com.navarro.padroesprojetospring.PPS.service;

import com.navarro.padroesprojetospring.PPS.models.dtos.ClientDTO;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getAll();
    ClientDTO getById(Long id);
    ClientDTO createClient(ClientDTO body);
    ClientDTO updateClient(Long id, ClientDTO body);
    void deleteClient(Long id);

}
