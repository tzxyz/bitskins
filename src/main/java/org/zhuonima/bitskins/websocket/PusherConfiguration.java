package org.zhuonima.bitskins.websocket;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhuonima.bitskins.configuration.BitskinProperties;

@Configuration
public class PusherConfiguration {

    @Bean
    public PusherOptions options() {
        PusherOptions options = new PusherOptions();
        options.setEncrypted(true);
        options.setWsPort(443);
        options.setWssPort(443);
        options.setHost("notifier.bitskins.com");
        return options;
    }

    @Bean
    public Pusher pusher(PusherOptions options, BitskinProperties properties) {
        return new Pusher(properties.getApiKey(), options);
    }

    @Bean
    public PushBeanPostProcessor processor(BitskinProperties properties) {
        return new PushBeanPostProcessor(properties);
    }
}
