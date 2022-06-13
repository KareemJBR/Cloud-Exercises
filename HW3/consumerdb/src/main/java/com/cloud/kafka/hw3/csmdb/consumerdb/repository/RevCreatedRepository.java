package com.cloud.kafka.hw3.csmdb.consumerdb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cloud.kafka.hw3.csmdb.consumerdb.entities.RevCreated;

public interface RevCreatedRepository extends JpaRepository<RevCreated, Long> {
    
}
