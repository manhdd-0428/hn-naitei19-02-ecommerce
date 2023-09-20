package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "cart_details")
public class CartDetail extends BaseEntity {

    private Integer quantity;

    private Integer price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", insertable=false, updatable=false)
    private Cart cart;

    @Column(name = "cart_id")
    private Long cartId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "product_id")
    private Long productId;

    public CartDetail(Integer quantity, Integer price, Long cartId, Long productId) {
        this.quantity = quantity;
        this.price = price;
        this.cartId = cartId;
        this.productId = productId;
    }
}
