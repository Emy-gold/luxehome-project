package org.backendluxehome.modules.product.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.backendluxehome.modules.category.entity.Category;
import org.backendluxehome.modules.category.repository.CategoryRepository;
import org.backendluxehome.modules.commun.PageResponse;
import org.backendluxehome.modules.product.dto.ProductRequest;
import org.backendluxehome.modules.product.dto.ProductResponse;
import org.backendluxehome.modules.product.entity.Product;
import org.backendluxehome.modules.product.mapper.ProductMapper;
import org.backendluxehome.modules.product.repository.ProductRepository;
import org.backendluxehome.modules.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Integer save(ProductRequest request, Authentication connectedUser){
        //Get the user from authentication object
        User user = ((User) connectedUser.getPrincipal());
        Product product = productMapper.toProduct(request);
        product.setOwner(user);

        Category category =
                categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        product.setCategory(category);
        return productRepository.save(product).getId();
    }

    public ProductResponse findById(Integer productId){
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("No product found with the id : " + productId));
    }

    public PageResponse<ProductResponse> findAllProducts(int page, int size, Authentication connectedUser){
        User user = ((User) connectedUser.getPrincipal());
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdBy").descending());
        Page<Product> products = productRepository.findAllDisplayableProducts(pageable, user.getId());
        List<ProductResponse> productResponse = products.stream()
                .map(productMapper::toProductResponse)
                .toList();
        return new PageResponse<>(
                productResponse,
                products.getNumber(),
                products.getSize(),
                products.getTotalElements(),
                (long) products.getTotalPages(),
                products.isFirst(),
                products.isLast()
        );
    }
}
