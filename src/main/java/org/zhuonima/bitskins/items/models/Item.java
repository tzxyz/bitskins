package org.zhuonima.bitskins.items.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "t_items")
@EntityListeners(AuditingEntityListener.class)
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

    @Column(columnDefinition = "TINYINT(2) DEFAULT '0'")
    private boolean enable;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date created;

    @LastModifiedDate
    @Column(columnDefinition = "INT(11) DEFAULT '0'")
    private long timestamp;

    @Version
    @Column(columnDefinition = "TINYINT(2) DEFAULT '0'")
    private byte version;
}
