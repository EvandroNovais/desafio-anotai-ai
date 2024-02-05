package com.eontecnologia.desafioanotaiai.services;

import com.eontecnologia.desafioanotaiai.domain.category.Category;
import com.eontecnologia.desafioanotaiai.domain.category.CategoryDTO;
import com.eontecnologia.desafioanotaiai.domain.category.exceptions.CategoryNotFoundException;
import com.eontecnologia.desafioanotaiai.domain.product.Product;
import com.eontecnologia.desafioanotaiai.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private CategoryService categoryService;
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository, CategoryService categoryService){
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Category insert(CategoryDTO categoryData){
        Product newProduct = new Product(productData);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product update(String id, CategoryDTO categoryData){
        Product product = this.productRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        if(!categoryData.title().isEmpty()) product.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) product.setDescription(categoryData.description());

        this.productRepository.save(product);

        return product;
    }

    public void delete(String id) {
        Category product = this.productRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        this.productRepository.delete(product);
    }
}
