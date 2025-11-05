package ru.javabruse.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tag extends EntityAbstract {

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Название тега не может быть пустым")
    @Size(max = 50, message = "Название тега не может превышать 50 символов")
    private String name;
}