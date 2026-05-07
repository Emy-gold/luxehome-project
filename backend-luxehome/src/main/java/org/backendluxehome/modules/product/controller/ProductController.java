package org.backendluxehome.modules.product.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.backendluxehome.modules.product.dto.ProductRequest;
import org.backendluxehome.modules.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Tag(name = "Product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> saveProduct(
            @Valid @RequestBody ProductRequest request,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(productService.save(request, connectedUser));
    }
}
