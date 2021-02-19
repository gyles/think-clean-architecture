/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.entity.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class LogItem {

    private final Instant created;
    private final String userId;
    private final String action;
    private final String url;
    private Payload payload;

}
