package com.demo.inventory.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "InventoryRecord")
@Table(
        name = "InventoryRecord",
        uniqueConstraints = {
                @UniqueConstraint(name = "inventory_name_unique", columnNames = "name")
        }
)
public class InventoryRecord {
    @Id
    @SequenceGenerator(
            name = "InventoryRecord_sequence",
            sequenceName = "InventoryRecord_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "InventoryRecord_sequence"
    )
    @Column(
            name = "inventory_id",
            updatable = false
    )
    private Long inventoryId;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String inventoryName;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String desc;

    @Column(
            name = "creation_date"
    )
    private Date creationDate;


    @Column(
            name = "update_date"
    )
    private Date updateDate;

    @Column(
            name = "stock"
    )
    private Integer stock;


    public InventoryRecord(String inventoryName, String desc, Date creationDate, Date updateDate, Integer stock) {
        this.inventoryName = inventoryName;
        this.desc = desc;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.stock = stock;
    }

    public InventoryRecord() {

    }

    public InventoryRecord(String inventoryName, String desc, Integer stock) {
        this.inventoryName = inventoryName;
        this.desc = desc;
        this.stock = stock;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "InventoryRecord{" +
                "inventoryId=" + inventoryId +
                ", inventoryName='" + inventoryName + '\'' +
                ", desc='" + desc + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", stock=" + stock +
                '}';
    }
}
