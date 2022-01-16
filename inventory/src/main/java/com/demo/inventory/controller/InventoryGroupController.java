package com.demo.inventory.controller;
import com.demo.inventory.model.InventoryGroup;
import com.demo.inventory.service.InventoryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/inventory_group")
public class InventoryGroupController {
    private final InventoryGroupService inventoryGroupService;

    @Autowired
    public InventoryGroupController(InventoryGroupService inventoryGroupService) {
        this.inventoryGroupService = inventoryGroupService;
    }

    @PostMapping
    public InventoryGroup addGroup(@RequestBody InventoryGroup inventoryGroup){
        return inventoryGroupService.addGroup(inventoryGroup);
    }

    @PutMapping("/addItem/{itemId}/to/{groupId}")
    public InventoryGroup putItemToGroup(@PathVariable Long groupId, @PathVariable Long itemId){
        return inventoryGroupService.addItemToGroup(groupId, itemId);
    }

    @DeleteMapping("/deleteItem/{itemId}/from/{groupId}")
    public InventoryGroup removeItemFromGroup(@PathVariable Long groupId, @PathVariable Long itemId){
        return inventoryGroupService.removeItemFromGroup(groupId, itemId);
    }
}