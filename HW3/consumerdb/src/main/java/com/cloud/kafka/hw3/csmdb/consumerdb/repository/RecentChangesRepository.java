package com.cloud.kafka.hw3.csmdb.consumerdb.repository;
import com.cloud.kafka.hw3.csmdb.consumerdb.entities.RecentChanges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentChangesRepository extends JpaRepository<RecentChanges, Long> {
    
}

