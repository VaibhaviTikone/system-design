package com.example.urlshortner.service;

import com.example.urlshortner.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public ProductDTO saveProduct(ProductDTO productDTO);
    public ProductDTO updateProduct(Long id, ProductDTO productDTO);
    public Optional<ProductDTO> getProduct(Long id);
    public List<ProductDTO> getAllProducts();
    public void deleteProduct(Long id);
}
