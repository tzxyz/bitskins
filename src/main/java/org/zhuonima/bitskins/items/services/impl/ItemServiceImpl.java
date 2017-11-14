package org.zhuonima.bitskins.items.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.zhuonima.bitskins.items.models.Item;
import org.zhuonima.bitskins.items.repositories.ItemRepository;
import org.zhuonima.bitskins.items.requests.ItemQuery;
import org.zhuonima.bitskins.items.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Page<Item> findAll(ItemQuery query) {
        return itemRepository.findAll(
                query.toSpecification(),
                new PageRequest(query.getPage(), query.getSize())
        );
    }

    @Override
    public Item saveToDBFromResponse(Item item) {
        return itemRepository.save(item);
    }
}