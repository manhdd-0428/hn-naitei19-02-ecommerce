package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

    private String image;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable=false, updatable=false)
    private Product product;

    @Column(name = "product_id")
    private Long productId;
    public ProductImage(String image, Long productId) {
        this.image = image;
        this.productId = productId;
    }
}
