package com.navarro.padroesprojetospring.repositories;

import com.navarro.padroesprojetospring.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
