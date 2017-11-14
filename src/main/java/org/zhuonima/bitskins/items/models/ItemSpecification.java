package org.zhuonima.bitskins.items.models;

import org.springframework.data.jpa.domain.Specification;

public class ItemSpecification {

    public static Specification<Item> appIdEqual(String appId) {
        return appId == null ? null : (root, cq, cb) -> cb.equal(root.get("appId"), appId);
    }

    public static Specification<Item> nameEqual(String name) {
        return name == null ? null : (root, cq, cb) -> cb.equal(root.get("name"), name);
    }
}
