package org.zhuonima.bitskins.websocket.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.zhuonima.bitskins.items.services.ItemService;
import org.zhuonima.bitskins.websocket.models.ItemListedResponse;

import java.io.IOException;

@Slf4j(topic = "ItemListed")
@Component
public class ItemListedSubscriptionEventListener extends ItemSubscriptionEventListener {

    @Autowired
    private ItemService itemService;

    @Override
    public void onEvent(String channelName, String eventName, String data) {
        log.info(String.format("[%s 触发 %s]", channelName, eventName));
        processResponseData(data);
    }

    @Override
    protected void processResponseData(String data) {
        assert data != null;
        try {
            ItemListedResponse itemListed = mapper.readValue(data, ItemListedResponse.class);
            log.info(itemListed.toString());
            itemService.saveToDBFromResponse(ItemBuilder.from(itemListed));
        } catch (DataIntegrityViolationException e) {
            // ignore
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
