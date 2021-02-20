/*
 * Copyright Stuff Limited
 */

package com.think.clean.service.log;

import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.domain.port.log.LogGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LogService implements LogGateway<Page<LogItem>, Pageable, String> {

    @Override
    public Optional<LogItem> getLogById(String id) {
        return Optional.empty();
    }

    @Override
    public Page<LogItem> getLogs(Pageable request, String filter) {
        return null;
    }

    @Override
    public void saveLogs(List<LogItem> logs) {

    }

}
