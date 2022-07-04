package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "classroom", schema = "college", catalog = "")
@IdClass(ClassroomEntityPK.class)
public class ClassroomEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "building")
    private String building;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "room_number")
    private String roomNumber;
    @Basic
    @Column(name = "capacity")
    private BigDecimal capacity;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    @OneToMany(mappedBy = "classroom")
    private Set<SectionEntity> section;
    public Set<SectionEntity> getSections() {
        return section;
    }
    public void setSections(Set<SectionEntity> section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomEntity that = (ClassroomEntity) o;
        return Objects.equals(building, that.building) && Objects.equals(roomNumber, that.roomNumber) && Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, roomNumber, capacity);
    }
}
