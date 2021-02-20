/*
 * Copyright Stuff Limited
 */

package com.think.clean.web.rest.log;

import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.domain.usecase.log.SearchLogs;
import com.think.clean.web.rest.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogController implements LogOperations {

    private final SearchLogs<Page<LogItem>, Pageable, String> searchLogs;
    private final LogItemAssembler logItemAssembler;
    private final PagedResourcesAssembler<LogItem> pagedResourcesAssembler;

    @Override
    public ResponseEntity<LogItemDto> getLogById(String id) {
        LogItem logItem = searchLogs.searchLogById(id)
            .orElseThrow(() -> new EntityNotFoundException(LogItem.class));

        return ResponseEntity.ok(logItemAssembler.toModel(logItem));
    }

    @Override
    public ResponseEntity<PagedModel<LogItemDto>> getLogs(Pageable pageable, String filter) {
        Page<LogItem> logItems = searchLogs.searchByQuery(pageable, filter);

        return ResponseEntity.ok(pagedResourcesAssembler.toModel(logItems, logItemAssembler));
    }

}
