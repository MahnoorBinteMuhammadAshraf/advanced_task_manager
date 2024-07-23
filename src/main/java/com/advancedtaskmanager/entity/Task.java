package com.advancedtaskmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task implements Comparator<Task> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message = "Title is mandatory")
    String title;

    @NotBlank(message = "Description is mandatory")
    String description;

    boolean completed;

    Integer priority;

    @Valid
    LocalDate scheduledDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Valid
    Category category;

    @Override
    public int compare(Task o1, Task o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return completed == task.completed && Objects.equals(title, task.title) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, completed);
    }
}
