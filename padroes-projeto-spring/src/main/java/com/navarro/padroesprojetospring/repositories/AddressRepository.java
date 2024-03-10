package com.navarro.padroesprojetospring.repositories;

import com.navarro.padroesprojetospring.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
