package org.zhuonima.bitskins.websocket.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pusher.client.channel.SubscriptionEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.zhuonima.bitskins.items.models.Item;
import org.zhuonima.bitskins.websocket.models.ItemResponse;

@Slf4j
public abstract class ItemSubscriptionEventListener implements SubscriptionEventListener {

    protected final static ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onEvent(String channelName, String eventName, String data) {
        log.info(String.format("[%s 触发 %s]", channelName, eventName));
    }

    protected abstract void processResponseData(String data);

    protected static class ItemBuilder {
        public static Item from(ItemResponse response) {
            Item item = new Item();
            BeanUtils.copyProperties(response, item);
            return item;
        }
    }
}
