package com.navarro.padroesprojetospring.PPS.models.dtos;

import com.navarro.padroesprojetospring.PPS.models.Address;

public record ClientDTO(Long id, String name, Address address) {
}
