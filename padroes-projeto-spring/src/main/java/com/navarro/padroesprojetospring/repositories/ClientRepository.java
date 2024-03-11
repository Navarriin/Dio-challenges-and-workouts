package com.navarro.padroesprojetospring.repositories;

import com.navarro.padroesprojetospring.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
