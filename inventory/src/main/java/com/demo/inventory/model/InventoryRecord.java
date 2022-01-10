package com.demo.inventory.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "InventoryRecord")
public class InventoryRecord {
    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "inventory_sequence"
    )
    private Long id;
    @Column(
            name = "name",
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "create_time"
    )
    private Date createTime;

    @Column(
            name = "update_time"
    )
    private Date updateTime;

    @Column(
            name = "desc",
            columnDefinition = "TEXT"
    )
    private String desc;

    @Column(
            name = "quantity"
    )
    private Integer quantity;

    public InventoryRecord(String name, Date createTime, Date updateTime, String desc, Integer quantity) {
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.desc = desc;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InventoryRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", desc='" + desc + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
