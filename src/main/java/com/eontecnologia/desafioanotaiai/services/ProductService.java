package com.eontecnologia.desafioanotaiai.services;

import com.eontecnologia.desafioanotaiai.domain.category.Category;
import com.eontecnologia.desafioanotaiai.domain.category.exceptions.CategoryNotFoundException;
import com.eontecnologia.desafioanotaiai.domain.product.Product;
import com.eontecnologia.desafioanotaiai.domain.product.ProductDTO;
import com.eontecnologia.desafioanotaiai.domain.product.exceptions.ProductNotFoundException;
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

    public Product insert(ProductDTO productData){
        Category category = this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product update(String id, ProductDTO productData){
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.categoryService.getById(productData.categoryId())
                .ifPresent(product::setCategory);

        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null)) product.setPrice(productData.price());

        this.productRepository.save(product);

        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        this.productRepository.delete(product);
    }
}
