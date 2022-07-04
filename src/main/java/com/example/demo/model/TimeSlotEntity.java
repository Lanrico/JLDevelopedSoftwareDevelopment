package com.example.demo.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "time_slot", schema = "college", catalog = "")
@IdClass(TimeSlotEntityPK.class)
public class TimeSlotEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "time_slot_id")
    private String timeSlotId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "day")
    private String day;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "start_hr")
    private BigInteger startHr;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "start_min")
    private BigInteger startMin;
    @Basic
    @Column(name = "end_hr")
    private BigInteger endHr;
    @Basic
    @Column(name = "end_min")
    private BigInteger endMin;

    public String getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(String timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public BigInteger getStartHr() {
        return startHr;
    }

    public void setStartHr(BigInteger startHr) {
        this.startHr = startHr;
    }

    public BigInteger getStartMin() {
        return startMin;
    }

    public void setStartMin(BigInteger startMin) {
        this.startMin = startMin;
    }

    public BigInteger getEndHr() {
        return endHr;
    }

    public void setEndHr(BigInteger endHr) {
        this.endHr = endHr;
    }

    public BigInteger getEndMin() {
        return endMin;
    }

    public void setEndMin(BigInteger endMin) {
        this.endMin = endMin;
    }

    @OneToMany(mappedBy = "timeSlot")
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
        TimeSlotEntity that = (TimeSlotEntity) o;
        return Objects.equals(timeSlotId, that.timeSlotId) && Objects.equals(day, that.day) && Objects.equals(startHr, that.startHr) && Objects.equals(startMin, that.startMin) && Objects.equals(endHr, that.endHr) && Objects.equals(endMin, that.endMin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeSlotId, day, startHr, startMin, endHr, endMin);
    }
}
