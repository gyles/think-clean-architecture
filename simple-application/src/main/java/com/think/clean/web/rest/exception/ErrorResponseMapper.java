/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.exception;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ErrorResponseMapper {

    @Mapping(source = "request.requestURI", target = "uri")
    @Mapping(target = "code", expression = "java(status.value())")
    @Mapping(source = "status.reasonPhrase", target = "reason")
    @Mapping(source = "message", target = "message")
    ErrorResponse toErrorResponse(HttpServletRequest request, HttpStatus status, String message);

}
