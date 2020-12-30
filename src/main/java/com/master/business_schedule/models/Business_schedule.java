package com.master.business_schedule.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.master.business.models.Business_type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "schedule")
public class Business_schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long businessId;
    private String day;
    private Integer state;

    @OneToMany( mappedBy = "scheduleHours",cascade = CascadeType.ALL )
    @JsonIgnoreProperties("scheduleHours")
    private Set<ScheduleHours> hours = new HashSet<>();

    public Business_schedule() { }

    public Business_schedule(Long id, Long businessId, String day, Integer state) {
        this.id = id;
        this.businessId = businessId;
        this.day = day;
        this.state = state;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBusinessId() { return businessId; }
    public void setBusinessId(Long businessId) { this.businessId = businessId; }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public Integer getState() { return state; }
    public void setState(Integer state) { this.state = state; }

    public Set<ScheduleHours> getHours() { return hours; }

    public void setHours(Set<ScheduleHours> hours) {
        this.hours = hours;
        for(ScheduleHours h : hours){
            h.setScheduleHours(this);
        }
    }
}