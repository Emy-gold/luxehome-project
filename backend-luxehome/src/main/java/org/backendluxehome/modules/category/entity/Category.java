package org.backendluxehome.modules.category.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.backendluxehome.modules.commun.BaseEntity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="categories")
@SuperBuilder
public class Category extends BaseEntity {


    @Column(nullable = false)
    private String name;

}
