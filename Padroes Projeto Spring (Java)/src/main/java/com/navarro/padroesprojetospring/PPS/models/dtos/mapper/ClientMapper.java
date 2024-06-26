package com.navarro.padroesprojetospring.PPS.models.dtos.mapper;

import com.navarro.padroesprojetospring.PPS.models.Client;
import com.navarro.padroesprojetospring.PPS.models.dtos.ClientDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
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
