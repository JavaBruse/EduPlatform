package ru.javabruse.entities;

import jakarta.persistence.*;
import java.time.Instant;

@MappedSuperclass
public abstract class EntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false, updatable = false)
    protected Instant createdAt = Instant.now();

    @Column(nullable = false)
    protected Instant updatedAt = Instant.now();

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }
}
