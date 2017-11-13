package org.zhuonima.bitskins.websocket.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public abstract class ItemResponse {
    @JsonProperty("app_id")
    private String appId;

    @JsonProperty("context_id")
    private String contextId;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("class_id")
    private String classId;

    @JsonProperty("instance_id")
    private String instanceId;

    private String image;

    @JsonProperty("market_hash_name")
    private String marketHashName;

    private String price;

    private String discount;

    @JsonProperty("event_type")
    private String eventType;

    @JsonProperty("broadcasted_at")
    private Double broadcastedAt;
}
