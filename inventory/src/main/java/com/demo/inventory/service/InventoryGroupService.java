package com.demo.inventory.service;
import com.demo.inventory.dao.InventoryGroupRepository;
import com.demo.inventory.dao.InventoryRecordRepository;
import com.demo.inventory.model.InventoryGroup;
import com.demo.inventory.model.InventoryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
public class InventoryGroupService {
    @Autowired
    private InventoryGroupRepository inventoryGroupRepository;
    @Autowired
    private InventoryRecordRepository inventoryRecordRepository;

    @Transactional
    public InventoryGroup addGroup(InventoryGroup inventoryGroup){
        if(inventoryGroup!= null){
            String inventoryGroupName = inventoryGroup.getName();
            InventoryGroup inventoryGroupFound = inventoryGroupRepository.findInventoryGroupByName(inventoryGroupName);
            if(inventoryGroupFound!=null){
                throw new IllegalStateException("Name already taken");
            }
            return inventoryGroupRepository.save(inventoryGroup);
        }
        throw new IllegalStateException("Cannot create a null group");
    }

    @Transactional
    public InventoryGroup addItemToGroup(Long groupId, Long itemId) {
        InventoryGroup inventoryGroup = inventoryGroupRepository.findInventoryGroupByGroupId(groupId);
        if (inventoryGroup == null) throw new IllegalStateException("group id not existed");
        InventoryRecord inventoryItem = inventoryRecordRepository.findInventoryRecordByInventoryId(itemId);
        if (inventoryItem == null) throw new IllegalStateException("item id not existed");
        inventoryGroup.addItem(inventoryItem);
        return inventoryGroupRepository.save(inventoryGroup);
    }

    @Transactional
    public InventoryGroup removeItemFromGroup(Long groupId, Long itemId) {
        InventoryGroup inventoryGroup = inventoryGroupRepository.findInventoryGroupByGroupId(groupId);
        if (inventoryGroup == null) throw new IllegalStateException("group id not existed");
        InventoryRecord inventoryItem = inventoryRecordRepository.findInventoryRecordByInventoryId(itemId);
        if (inventoryItem == null) throw new IllegalStateException("item id not existed");
        inventoryGroup.removeItem(inventoryItem);
        return inventoryGroupRepository.save(inventoryGroup);
    }
}