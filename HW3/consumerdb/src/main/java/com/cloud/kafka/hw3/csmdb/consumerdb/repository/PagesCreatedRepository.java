package com.cloud.kafka.hw3.csmdb.consumerdb.repository;
import com.cloud.kafka.hw3.csmdb.consumerdb.entities.PagesCreated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagesCreatedRepository extends JpaRepository<PagesCreated, Long> {
    
}