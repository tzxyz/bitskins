package org.zhuonima.bitskins.websocket.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.zhuonima.bitskins.items.services.ItemService;
import org.zhuonima.bitskins.websocket.models.ItemPriceChangeResponse;

import java.io.IOException;

@Slf4j(topic = "ItemPriceChange")
@Component
public class ItemPriceChangedSubscriptionEventListener extends ItemSubscriptionEventListener {

    @Autowired
    private ItemService itemService;

    @Override
    protected void processResponseData(String data) {
        try {
            ItemPriceChangeResponse itemPriceChange = mapper.readValue(data, ItemPriceChangeResponse.class);
            itemService.saveToDBFromResponse(ItemBuilder.from(itemPriceChange));
        } catch (DataIntegrityViolationException e) {
            // ignore
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error(e.getClass().getName());
        }
    }
}
