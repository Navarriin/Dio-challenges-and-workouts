package com.navarro.padroesprojetospring.PPS.service.impl;

import com.navarro.padroesprojetospring.PPS.exceptions.NotFoundException;
import com.navarro.padroesprojetospring.PPS.models.Address;
import com.navarro.padroesprojetospring.PPS.models.Client;
import com.navarro.padroesprojetospring.PPS.models.dtos.ClientDTO;
import com.navarro.padroesprojetospring.PPS.models.dtos.mapper.ClientMapper;
import com.navarro.padroesprojetospring.PPS.repositories.AddressRepository;
import com.navarro.padroesprojetospring.PPS.repositories.ClientRepository;
import com.navarro.padroesprojetospring.PPS.service.ClientService;
import com.navarro.padroesprojetospring.PPS.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final AddressRepository addressRepository;
    private final ClientRepository clientRepository;
    private final ViaCepService viaCepService;

    @Autowired
    private ClientMapper clientMapper;

    public ClientServiceImpl(
            AddressRepository addressRepository,
            ClientRepository clientRepository,
            ViaCepService viaCepService
    ) {
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public List<ClientDTO> getAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .sorted(Comparator.comparing(ClientDTO::id))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getById(Long id) {
        return clientMapper.toDto(
                clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client not found by id: " + id)));
    }

    @Override
    public ClientDTO createClient(ClientDTO body) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(saveClientWithCep(body))));
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO body) {
      return clientRepository.findById(id)
              .map(data -> {
                  ClientDTO cep = saveClientWithCep(body);
                  data.setName(body.name());
                  data.setAddress(cep.address());
                  return clientMapper.toDto(clientRepository.save(data));
      }).orElseThrow(() -> new NotFoundException("Client not found by id: " + id));

    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client not found by id: " + id)));
    }

    public ClientDTO saveClientWithCep(ClientDTO body) {
        String cep = body.address().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        Client bodyEntity = clientMapper.toEntity(body);
        bodyEntity.setAddress(address);
        return clientMapper.toDto(bodyEntity);
    }
}
