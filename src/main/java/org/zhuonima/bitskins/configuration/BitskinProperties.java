package org.zhuonima.bitskins.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "bitskins")
public class BitskinProperties {

    private String appId;

    private String apiKey;

    private String host;

    private int wsPort;

    private int wssPort;

    private boolean encrypted;
}
