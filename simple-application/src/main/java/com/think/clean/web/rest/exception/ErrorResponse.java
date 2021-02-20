/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = false)
public class ErrorResponse extends RepresentationModel<ErrorResponse> {

    private Instant timestamp = Instant.now();
    private String uri;
    private Integer code;
    private String reason;
    private String message;

}
