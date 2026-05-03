package org.backendluxehome.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="categories")
@SuperBuilder
public class Category extends BaseEntity{


    @Column(nullable = false)
    private String name;

}
