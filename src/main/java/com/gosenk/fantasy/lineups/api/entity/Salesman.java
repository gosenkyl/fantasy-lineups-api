package com.gosenk.fantasy.lineups.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salesman")
public class Salesman extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
