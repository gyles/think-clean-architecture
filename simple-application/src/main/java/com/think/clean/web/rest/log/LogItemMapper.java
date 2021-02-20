/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.log;

import com.think.clean.domain.entity.log.LogItem;
import org.mapstruct.Mapper;

@Mapper
public interface LogItemMapper {
    
    LogItemDto toDto(LogItem logItem);

}
