package com.navarro.padroesprojetospring.PPS.repositories;

import com.navarro.padroesprojetospring.PPS.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
