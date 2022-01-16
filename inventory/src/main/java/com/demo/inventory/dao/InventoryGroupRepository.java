
package com.demo.inventory.dao;
import com.demo.inventory.model.InventoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryGroupRepository extends JpaRepository<InventoryGroup, Long> {
    InventoryGroup findInventoryGroupByGroupId(Long id);
    InventoryGroup findInventoryGroupByName(String name);
}
