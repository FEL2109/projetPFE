package com.example.gestionconge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRHRepository extends JpaRepository<ServiceRH,Long> {
}
