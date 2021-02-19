/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.usecase.log;

import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.domain.port.log.LogGateway;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
public class SearchLogs<T extends Iterable<LogItem>, U, V> {

    private final LogGateway<T, U , V> logGateway;

    public Optional<LogItem> searchLogById(String uuid) {
        return logGateway.getLogById(uuid);
    }

    public T searchByQuery(U request, V query) {
        return logGateway.getLogs(request, query);
    }

}
