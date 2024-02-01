package com.eontecnologia.desafioanotaiai.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private String category;
}
