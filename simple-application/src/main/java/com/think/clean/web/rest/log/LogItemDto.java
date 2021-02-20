/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "items")
public class LogItemDto extends RepresentationModel<LogItemDto> {

    private Instant created;
    private String userId;
    private String action;
    private String url;
    private PayloadDto payload;

    @Data
    public static class PayloadDto {
        private String itemId;
        private Integer amount;
    }

}
