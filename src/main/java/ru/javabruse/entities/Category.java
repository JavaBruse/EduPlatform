package ru.javabruse.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends EntityAbstract {

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Название категории не может быть пустым")
    @Size(max = 255, message = "Название категории не может превышать 255 символов")
    private String name;
}