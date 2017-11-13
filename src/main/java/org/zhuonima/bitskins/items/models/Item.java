package org.zhuonima.bitskins.items.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appId;

    private String appName;

    @Column(unique = true)
    private String marketHashName;

    @Column(length = 512)
    private String image;

    @Min(0)
    @Max(300)
    private BigDecimal limitedPrice;
}
