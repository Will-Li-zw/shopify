package com.demo.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.inventory.dao.InventoryRecordRepository;
import com.demo.inventory.model.InventoryRecord;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
@Service
public class InventoryRecordService {
    @Autowired
    private InventoryRecordRepository inventoryRecordRepository;

    /**
     * create Inventory with the input parameters
     * @return InventoryRecord
     * @author Zhiwei Li
     * @throws IllegalArgumentException
     */
    @Transactional
    public InventoryRecord createInventory(@NonNull  String name, String desc, @NonNull Integer stock) throws IllegalArgumentException{
        String error="";
        InventoryRecord inventoryRecord= new InventoryRecord(name, desc, stock);
        System.out.print("What happend?");
        inventoryRecordRepository.save(inventoryRecord);
        return inventoryRecord;
    }

    /**
     * update car with input plate number with the given parameters

     * @return inventory
     * @author Zhiwei Li
     * @throws IllegalArgumentException
     */
    @Transactional
    public InventoryRecord updateInventory(@NonNull Long id, @NonNull  String name, String desc, @NonNull Integer stock) throws IllegalArgumentException{
        InventoryRecord inventoryRecord= inventoryRecordRepository.findInventoryRecordByInventoryId(id);
        inventoryRecord.setInventoryName(name);
        inventoryRecord.setDesc(desc);
        inventoryRecord.setStock(stock);
        inventoryRecordRepository.save(inventoryRecord);
        return inventoryRecord;
    }

    /**
     * delete car with input plate number
     * @param id
     * @return
     * @author Zhiwei Li
     * @throws IllegalArgumentException
     */
    @Transactional
    public String deleteInventory(@NonNull String name)  throws IllegalArgumentException{
        String error = "";
        if(inventoryRecordRepository.findInventoryRecordByInventoryName(name)==null){
            error="No such inventory";
        }
        if (error.length() > 0) {
            throw new IllegalArgumentException(error.trim());
        }
        inventoryRecordRepository.deleteInventoryRecordByInventoryName(name);
        return "delete succeed";
    }



    /**
     * get list of cars associated with the input customer
     * @param
     * @return All inventories
     * @author Zhiwei Li
     */
    @Transactional
    public List<InventoryRecord> getAllInventories(){
        return  inventoryRecordRepository.findAll();
    }

    @Transactional
    public InventoryRecord getInventoryByName(String name){
        return  inventoryRecordRepository.findInventoryRecordByInventoryName(name);
    }


}