/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.entity.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogItem {

    private String id;
    private Instant created;
    private String userId;
    private String action;
    private String url;
    private Payload payload;

    public LogItem(Instant created, String userId, String action, String url) {
        this(created, userId, action, url, null);
    }

    public LogItem(Instant created, String userId, String action, String url, Payload payload) {
        this(null, created, userId, action, url, payload);
    }

}
