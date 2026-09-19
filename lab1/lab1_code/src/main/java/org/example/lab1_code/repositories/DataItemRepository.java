package org.example.lab1_code.repositories;

import org.example.lab1_code.entities.DataItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataItemRepository extends JpaRepository<DataItem, Long> {
}