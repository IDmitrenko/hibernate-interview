package ru.dias.hibernate.persistence.entities;

import lombok.*;
import ru.dias.hibernate.persistence.entities.utils.PersistableEntity;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends PersistableEntity {

    @Size(max=128)
    @NonNull
    private String name;

    @Min(value = 2)
    @Max(value = 5)
    private int mark;
}
