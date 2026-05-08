package org.backendluxehome.modules.category.repository;

import org.backendluxehome.modules.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
