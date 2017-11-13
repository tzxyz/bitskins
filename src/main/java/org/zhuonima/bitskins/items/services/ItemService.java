package org.zhuonima.bitskins.items.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zhuonima.bitskins.items.models.Item;

public interface ItemService {

    Page<Item> findAll(Pageable pageable);

    Item saveToDBFromResponse(Item item);

}