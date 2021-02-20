/*
 * Copyright Stuff Limited
 */

package com.think.clean.common.mapper.log;

import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.repository.log.LogItemEntity;
import com.think.clean.web.rest.log.LogItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogItemMapper {
    
    LogItemDto domainToDto(LogItem logItem);

    LogItem entityToDomain(LogItemEntity logItemEntity);
    LogItemEntity domainToEntity(LogItem logItem);

}
