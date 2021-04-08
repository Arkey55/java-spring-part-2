package ru.romankuznetsov.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return String.format("id: %s, name: %s", id, name);
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
