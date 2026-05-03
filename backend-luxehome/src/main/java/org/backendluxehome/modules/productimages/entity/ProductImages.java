package org.backendluxehome.modules.productimages.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.backendluxehome.modules.commun.BaseEntity;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products_images")
public class ProductImages extends BaseEntity {

    @Column(nullable = false)
    private String url;
}
