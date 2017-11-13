package org.zhuonima.bitskins.websocket;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhuonima.bitskins.configuration.BitskinProperties;

@Configuration
public class PusherConfiguration {

    @Bean
    public PusherOptions options(BitskinProperties properties) {
        PusherOptions options = new PusherOptions();
        options.setEncrypted(properties.isEncrypted());
        options.setWsPort(properties.getWsPort());
        options.setWssPort(properties.getWssPort());
        options.setHost(properties.getHost());
        return options;
    }

    @Bean
    public Pusher pusher(PusherOptions options, BitskinProperties properties) {
        return new Pusher(properties.getAppId(), options);
    }

    @Bean
    public PushBeanPostProcessor processor() {
        return new PushBeanPostProcessor();
    }
}
