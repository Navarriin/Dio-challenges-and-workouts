package com.navarro.padroesprojetospring.models.dtos.mapper;

import com.navarro.padroesprojetospring.models.Client;
import com.navarro.padroesprojetospring.models.dtos.ClientDTO;

import java.util.Objects;

public class ClientMapper {

    public ClientDTO toDto(Client client) {
        if(Objects.isNull(client)) return null;

        return new ClientDTO(client.getId(), client.getName(), client.getAddress());
    }

    public Client toEntity(ClientDTO clientDTO) {
        if(Objects.isNull(clientDTO)) return null;

        Client client = new Client();

        if(Objects.nonNull(clientDTO.id())) client.setId(clientDTO.id());

        client.setName(clientDTO.name());
        client.setAddress(clientDTO.address());
        return client;
    }
}
