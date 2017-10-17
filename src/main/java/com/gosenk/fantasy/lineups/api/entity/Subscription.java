package com.gosenk.fantasy.lineups.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "salesman_id", nullable = false)
    private String salesmanId;

    @Column(name = "active", nullable = false)
    private boolean active;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
