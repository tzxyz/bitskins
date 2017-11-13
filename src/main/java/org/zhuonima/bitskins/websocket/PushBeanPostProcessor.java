package org.zhuonima.bitskins.websocket;

import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.zhuonima.bitskins.websocket.listener.ItemListedSubscriptionEventListener;
import org.zhuonima.bitskins.websocket.listener.ItemPriceChangedSubscriptionEventListener;

@Slf4j
public class PushBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof Pusher) {
            Pusher pusher = (Pusher) bean;

            pusher.connect();

            Channel channel = pusher.subscribe("inventory_changes");

            channel.bind("listed", new ItemListedSubscriptionEventListener());
            channel.bind("price_changed", new ItemPriceChangedSubscriptionEventListener());

        }

        return bean;
    }
}
