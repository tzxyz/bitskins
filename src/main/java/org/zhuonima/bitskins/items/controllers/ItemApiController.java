package org.zhuonima.bitskins.items.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhuonima.bitskins.items.models.Item;
import org.zhuonima.bitskins.items.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemApiController {

    private final ItemService itemService;

    public ItemApiController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Page<Item> findAll() {
        return itemService.findAll(new PageRequest(0, 10));
    }
}
