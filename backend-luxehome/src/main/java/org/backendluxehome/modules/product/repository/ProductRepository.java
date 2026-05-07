package org.backendluxehome.modules.product.repository;

import org.backendluxehome.modules.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {


}
