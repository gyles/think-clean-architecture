/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.usecase.log;

import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.domain.port.log.LogGateway;
import com.think.clean.domain.usecase.exception.DomainException;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class SaveLogs {

    private final LogGateway logGateway;

    public void saveLogs(List<LogItem> logs) {
        if (logs.isEmpty()) {
            throw new DomainException("Cannot save empty logs.");
        }
        logGateway.saveLogs(logs);
    }

}
