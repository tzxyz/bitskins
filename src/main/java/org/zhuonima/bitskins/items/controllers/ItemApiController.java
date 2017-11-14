package org.zhuonima.bitskins.items.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.zhuonima.bitskins.items.models.Item;
import org.zhuonima.bitskins.items.requests.ItemQuery;
import org.zhuonima.bitskins.items.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemApiController {

    private final ItemService itemService;

    public ItemApiController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Page<Item> findAll(@RequestParam(required = false) String appId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false, defaultValue = "0") int page,
                              @RequestParam(required = false, defaultValue = "20") int size) {

        return itemService.findAll(new ItemQuery(appId, name, page, size));
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable("id") Long id, Item item) {
        return null;
    }
}
