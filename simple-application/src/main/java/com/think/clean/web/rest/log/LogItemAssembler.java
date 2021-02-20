/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.log;

import com.think.clean.domain.entity.log.LogItem;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class LogItemAssembler extends RepresentationModelAssemblerSupport<LogItem, LogItemDto> {

    private final LogItemMapper logItemMapper;

    public LogItemAssembler(LogItemMapper logItemMapper) {
        super(LogController.class, LogItemDto.class);
        this.logItemMapper = logItemMapper;
    }

    @Override
    public LogItemDto toModel(LogItem logItem) {
        return logItemMapper.toDto(logItem);
    }

}
