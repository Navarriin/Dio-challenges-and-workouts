package com.navarro.padroesprojetospring.repositories;

import com.navarro.padroesprojetospring.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
