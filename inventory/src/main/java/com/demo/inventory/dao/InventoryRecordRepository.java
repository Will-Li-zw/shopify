package com.demo.inventory.dao;

import com.demo.inventory.model.InventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRecordRepository extends JpaRepository<InventoryRecord, Long> {
    InventoryRecord findInventoryRecordByInventoryId(Long id);
    InventoryRecord findInventoryRecordByInventoryName(String name);
    String deleteInventoryRecordByInventoryName(String name);
}
