package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class TimeSlotEntityPK implements Serializable {
    @Column(name = "time_slot_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String timeSlotId;
    @Column(name = "day")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String day;
    @Column(name = "start_hr")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger startHr;
    @Column(name = "start_min")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger startMin;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlotEntityPK that = (TimeSlotEntityPK) o;
        return Objects.equals(timeSlotId, that.timeSlotId) && Objects.equals(day, that.day) && Objects.equals(startHr, that.startHr) && Objects.equals(startMin, that.startMin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeSlotId, day, startHr, startMin);
    }
}
