package org.zhuonima.bitskins.items.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.zhuonima.bitskins.items.models.Item;
import org.zhuonima.bitskins.items.models.ItemSpecification;

@Data
@AllArgsConstructor
public class ItemQuery {
    private String appId;
    private String name;
    private int page;
    private int size;

    public Specification<Item> toSpecification() {
        return Specifications
                .where(ItemSpecification.appIdEqual(appId))
                .and(ItemSpecification.nameEqual(name));
    }
}
