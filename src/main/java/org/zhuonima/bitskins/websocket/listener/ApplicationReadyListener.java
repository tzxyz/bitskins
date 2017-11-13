package org.zhuonima.bitskins.websocket.listener;

import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationReadyListener {

    private final Pusher pusher;
    private final ItemListedSubscriptionEventListener itemListedSubscriptionEventListener;
    private final ItemPriceChangedSubscriptionEventListener itemPriceChangedSubscriptionEventListener;

    public ApplicationReadyListener(Pusher pusher,
                                    ItemListedSubscriptionEventListener itemListedSubscriptionEventListener,
                                    ItemPriceChangedSubscriptionEventListener itemPriceChangedSubscriptionEventListener) {
        this.pusher = pusher;
        this.itemListedSubscriptionEventListener = itemListedSubscriptionEventListener;
        this.itemPriceChangedSubscriptionEventListener = itemPriceChangedSubscriptionEventListener;
    }

    @EventListener
    public void onApplicationReadyEvent(final ApplicationReadyEvent event) {

        log.info(event.getSource().toString());

        pusher.connect();

        Channel channel = pusher.subscribe("inventory_changes");

        channel.bind("listed", itemListedSubscriptionEventListener);
        channel.bind("price_changed", itemPriceChangedSubscriptionEventListener);

    }

}
