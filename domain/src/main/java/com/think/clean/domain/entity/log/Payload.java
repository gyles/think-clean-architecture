/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.entity.log;

import lombok.Data;

@Data
public class Payload {

    private String id;
    private final String itemId;
    private final Integer amount;

}
