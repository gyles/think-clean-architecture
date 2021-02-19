/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.port.log;

import com.think.clean.domain.entity.log.LogItem;
import java.util.List;
import java.util.Optional;

public interface LogGateway<T extends Iterable<LogItem>, U, V> {

    Optional<LogItem> getLogById(String id);

    T getLogs(U request, V filter);

    void saveLogs(List<LogItem> logs);

}
