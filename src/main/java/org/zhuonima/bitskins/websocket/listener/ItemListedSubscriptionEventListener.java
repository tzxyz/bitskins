package org.zhuonima.bitskins.websocket.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pusher.client.channel.SubscriptionEventListener;
import lombok.extern.slf4j.Slf4j;
import org.zhuonima.bitskins.model.ItemListedResponse;

import java.io.IOException;

@Slf4j(topic = "ItemListed")
public class ItemListedSubscriptionEventListener implements SubscriptionEventListener {

    private final static ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onEvent(String channelName, String eventName, String data) {
        log.info(String.format("[%s 触发 %s], 获取数据: %s", channelName, eventName, data));
        processResponseData(data);
    }

    private void processResponseData(String data) {
        try {
            ItemListedResponse itemListed = mapper.readValue(data, ItemListedResponse.class);
            log.info(itemListed.toString());
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
