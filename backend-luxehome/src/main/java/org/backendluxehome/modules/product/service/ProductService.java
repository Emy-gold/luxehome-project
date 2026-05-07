package org.backendluxehome.modules.product.service;

import lombok.RequiredArgsConstructor;
import org.backendluxehome.modules.product.dto.ProductRequest;
import org.backendluxehome.modules.product.entity.Product;
import org.backendluxehome.modules.product.mapper.ProductMapper;
import org.backendluxehome.modules.product.repository.ProductRepository;
import org.backendluxehome.modules.user.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public Integer save(ProductRequest request, Authentication connectedUser){
        //Get the user from authentication object
        User user = ((User) connectedUser.getPrincipal());
        Product product = productMapper.toProduct(request);
        product.setOwner(user);
        return productRepository.save(product).getId();
    }

}
