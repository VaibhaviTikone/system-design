package com.example.urlshortner.service;

import com.example.urlshortner.pojo.Product;
import com.example.urlshortner.repository.ProductRepository;
import com.example.urlshortner.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product saveProduct = productRepository.save(product);
        return convertToDto(saveProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        Product saveProduct = productRepository.save(product);
        return convertToDto(saveProduct);
    }

    @Override
    public Optional<ProductDTO> getProduct(Long id) {
        return productRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.id());
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        return product;
    }

    private ProductDTO convertToDto(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
