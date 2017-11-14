package org.zhuonima.bitskins.items.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zhuonima.bitskins.items.models.Item;
import org.zhuonima.bitskins.items.requests.ItemQuery;

public interface ItemService {

    Page<Item> findAll(ItemQuery query);

    Item saveToDBFromResponse(Item item);

}