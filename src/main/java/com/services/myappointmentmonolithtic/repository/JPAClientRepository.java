package com.services.myappointmentmonolithtic.repository;

import com.services.myappointmentmonolithtic.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface JPAClientRepository extends JpaRepository<Client, Long> {
//    @Query(value = "SELECT * FROM clients WHERE name = name1")
    List<Client> findClientsByName(String name);
//    List<Client> findClientByDateOfBirth(LocalDate dateOfBirth);

}
