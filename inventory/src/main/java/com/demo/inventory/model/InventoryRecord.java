package com.demo.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import static javax.persistence.GenerationType.SEQUENCE;
import java.util.HashSet;
import java.util.Set;
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

    @JsonIgnore
    @ManyToMany(mappedBy = "groupItems")
    private Set<InventoryGroup> groups = new HashSet<>();

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
            name = "stock"
    )
    private Integer stock;



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



    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Set<InventoryGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<InventoryGroup> groups) {
        this.groups = groups;
    }
}
