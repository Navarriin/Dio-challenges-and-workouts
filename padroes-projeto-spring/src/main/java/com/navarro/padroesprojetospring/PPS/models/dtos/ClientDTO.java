package com.navarro.padroesprojetospring.models.dtos;

import com.navarro.padroesprojetospring.models.Address;

public record ClientDTO(Long id, String name, Address address) {
}
