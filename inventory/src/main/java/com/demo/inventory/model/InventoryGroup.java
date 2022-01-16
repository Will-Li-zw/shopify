package com.demo.inventory.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "InventoryGroup")
@Table(
        name = "InventoryGroup",
        uniqueConstraints = {
                @UniqueConstraint(name = "inventory_group_unique", columnNames = "name")
        }
)
public class InventoryGroup {
    @Id
    @SequenceGenerator(
            name = "group_sequence",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "group_sequence"
    )
    @Column(
            name = "group_id",
            updatable = false
    )
    private Long groupId;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @ManyToMany
    @JoinTable(
            name = "items_in_groups",
            joinColumns = @JoinColumn(name = "groupId"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id")
    )
    private Set<InventoryRecord> groupItems = new HashSet<>();

    public InventoryGroup() {

    }


    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<InventoryRecord> getGroupItems() {
        return groupItems;
    }

    public void setGroupItems(Set<InventoryRecord> groupItems) {
        this.groupItems = groupItems;
    }

    public void addItem(InventoryRecord inventoryItem) {
        groupItems.add(inventoryItem);
        inventoryItem.getGroups().add(this);
    }

    public void removeItem(InventoryRecord inventoryItem) {
        groupItems.remove(inventoryItem);
        inventoryItem.getGroups().remove(this);
    }
}