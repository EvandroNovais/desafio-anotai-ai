package com.eontecnologia.desafioanotaiai.services;

import com.eontecnologia.desafioanotaiai.domain.category.Category;
import com.eontecnologia.desafioanotaiai.domain.category.CategoryDTO;
import com.eontecnologia.desafioanotaiai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData){
        Category newCategory = new Category(categoryData);
        this.repository.save(newCategory);
        return newCategory;
    }

    public List<Category> getAll(){
        return this.repository.findAll();
    }

    public  Category update(String id, CategoryDTO categoryData){
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::New);
        Category updatedCategory = new Category(categoryData);
        this.repository.save(updatedCategory);
        return updatedCategory;
    }
}
