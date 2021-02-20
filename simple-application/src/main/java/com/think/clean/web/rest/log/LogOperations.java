/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.log;

import com.think.clean.web.rest.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/logs", produces = MediaTypes.HAL_JSON_VALUE)
public interface LogOperations {

    @GetMapping("/{id}")
    @Operation(summary = "Get logs by id.", responses = {
        @ApiResponse(responseCode = "200", description = "OK."),
        @ApiResponse(responseCode = "404", description = "Not Found.", content = @Content(
            mediaType = MediaTypes.HAL_JSON_VALUE,
            schema = @Schema(implementation = ErrorResponse.class)))
    })
    ResponseEntity<LogItemDto> getLogById(@PathVariable String id);

    @GetMapping
    @PageableAsQueryParam
    @Operation(summary = "Get logs.")
    ResponseEntity<PagedModel<LogItemDto>> getLogs(
        @Parameter(hidden = true) Pageable pageable,
        @RequestParam(name = "q", required = false)
        @Parameter(description = "RSQL query") String filter);

}
