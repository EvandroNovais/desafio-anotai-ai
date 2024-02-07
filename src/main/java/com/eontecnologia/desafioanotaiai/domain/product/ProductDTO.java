package com.eontecnologia.desafioanotaiai.domain.product;

import com.eontecnologia.desafioanotaiai.domain.category.Category;

public record ProductDTO(String title, String description, String ownerId, Integer price, String categoryId) {
}
