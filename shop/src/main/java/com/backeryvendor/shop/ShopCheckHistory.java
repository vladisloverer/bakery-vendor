package com.backeryvendor.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShopCheckHistory {
    @Id
    @SequenceGenerator(
            name = "shop_id_sequence",
            sequenceName = "shop_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shop_id_sequence"
    )
    private Integer id;
    private Integer customerId;
    private Boolean isShopper;
    private LocalDateTime createdAt;
}
