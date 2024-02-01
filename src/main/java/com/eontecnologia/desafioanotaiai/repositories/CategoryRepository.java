package com.eontecnologia.desafioanotaiai.repositories;

import com.eontecnologia.desafioanotaiai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
