package com.ecommerce.model;

import com.ecommerce.dto.BaseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {
    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PENDING(0),
        ACCEPTED(1),
        REJECTED(2),
        CANCELLED(3),
        SHIPPING(4),
        COMPLETED(5);
        private final int value;
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Column(name = "total_price")
    private Integer totalPrice;
    @Column(name = "shipping_status")
    private String shippingStatus;
    @Column(name = "shipping_fee")
    private Long shippingFee;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", insertable = false, updatable = false)
    private Receiver receiver;

    @Column(name = "receiver_id")
    private Long receiverId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Account user;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @OneToOne(mappedBy = "order")
    private RejectCause rejectCause;

    public Order(BaseDTO dto) {
        super(dto);
    }

    public Order(Integer totalPrice, String shippingStatus, Long shippingFee, Long receiverId, Long userId, Integer status) {
        this.totalPrice = totalPrice;
        this.shippingStatus = shippingStatus;
        this.shippingFee = shippingFee;
        this.receiverId = receiverId;
        this.userId = userId;
        this.status = Status.values()[status];
    }

    public Order(Integer totalPrice, String shippingStatus, Long shippingFee, Long receiverId, Long userId, Status status) {
        this.totalPrice = totalPrice;
        this.shippingStatus = shippingStatus;
        this.shippingFee = shippingFee;
        this.receiverId = receiverId;
        this.userId = userId;
        this.status = status;
    }
}
