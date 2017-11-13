package org.zhuonima.bitskins.websocket;

import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionStateChange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.zhuonima.bitskins.configuration.BitskinProperties;

@Slf4j
public class PushBeanPostProcessor implements BeanPostProcessor {

    private final BitskinProperties bitskinProperties;

    public PushBeanPostProcessor(BitskinProperties bitskinProperties) {
        this.bitskinProperties = bitskinProperties;
    }


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

            channel.bind("listed", (String channelName, String eventName, String data) -> {
                log.info(String.format("[%s 触发 %s], 获取数据: %s", channelName, eventName, data));
            });

        }

        return bean;
    }
}
