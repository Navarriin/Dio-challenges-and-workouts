package com.navarro.padroesprojetospring.PPS.repositories;

import com.navarro.padroesprojetospring.PPS.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
