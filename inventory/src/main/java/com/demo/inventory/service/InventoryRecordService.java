package com.demo.inventory.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.inventory.dao.InventoryRecordRepository;
import com.demo.inventory.model.InventoryRecord;
import java.util.List;
@Service
public class InventoryRecordService {
    @Autowired
    private InventoryRecordRepository inventoryRecordRepository;

    /**
     * create Inventory with the input parameters, cannot create duplicated name items
     * @return InventoryRecord created
     * @author Zhiwei Li
     * @throws IllegalArgumentException
     */
    @Transactional
    public InventoryRecord createInventory(@NonNull  String name, String desc, @NonNull Integer stock) throws IllegalArgumentException{
        InventoryRecord inventoryRecord= new InventoryRecord(name, desc, stock);
        inventoryRecordRepository.save(inventoryRecord);
        return inventoryRecord;
    }

    /**
     * update car with input plate number with the given parameters, remains the same if not provided
     * @return inventory updated
     * @author Zhiwei Li
     * @throws IllegalArgumentException
     */
    @Transactional
    public InventoryRecord updateInventory(@NonNull Long id, @NonNull  String name, String desc, @NonNull Integer stock) throws IllegalArgumentException{
        InventoryRecord inventoryRecord= inventoryRecordRepository.findInventoryRecordByInventoryId(id);
        if (name!=null) inventoryRecord.setInventoryName(name);
        if (desc!=null) inventoryRecord.setDesc(desc);
        if (stock!=null)inventoryRecord.setStock(stock);
        inventoryRecordRepository.save(inventoryRecord);
        return inventoryRecord;
    }

    /**
     * delete inventory with its name,
     * @param
     * @return "delete succeed" if successfully deleted
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