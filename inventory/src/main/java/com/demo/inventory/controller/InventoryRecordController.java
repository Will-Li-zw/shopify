package com.demo.inventory.controller;
import com.demo.inventory.dao.InventoryRecordRepository;
import com.demo.inventory.model.InventoryRecord;
import com.demo.inventory.service.InventoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


@CrossOrigin(origins = "*")
@RestController
public class InventoryRecordController {
    @Autowired
    InventoryRecordService inventoryRecordService;
    @PostMapping(value = {"/inventory", "/inventory/"})
    public InventoryRecord createInventory(
            @RequestParam("name")  String name,
            @RequestParam("desc") String desc,
            @RequestParam("stock") Integer  stock
//            @RequestParam("creationDate") Date creationDate
    ){
        InventoryRecord inventoryRecord = inventoryRecordService.createInventory(name, desc, stock);
        return inventoryRecord;
    }

    @PutMapping(value = {"/updateInventory", "/updateInventory/"})
    public InventoryRecord updateInventory(
            @RequestParam("id")  Long id,
            @RequestParam("name")  String name,
            @RequestParam("desc") String desc,
            @RequestParam("stock") Integer  stock
    ){
        InventoryRecord inventoryRecord = inventoryRecordService.updateInventory(id,name, desc, stock);
        return inventoryRecord;
    }

    @GetMapping(value = {"/getInventoryByName", "/getInventoryByName/"})
    public InventoryRecord  getInventoryByName(
            @RequestParam("name")  String name
    ){
        return inventoryRecordService.getInventoryByName(name);
    }

    @GetMapping(value = {"/getAllInventory", "/getAllInventory/"})
    public List<InventoryRecord> getAllInventory(
    ){
        return inventoryRecordService.getAllInventories();
    }
    @DeleteMapping(value = {"/deleteInventoryByName", "/deleteInventoryByName/"})
    public String deleteInventoryByName(
            @RequestParam("name")  String name
    ){
        return inventoryRecordService.deleteInventory(name);
    }

}
