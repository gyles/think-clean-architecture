/*
 * Copyright Stuff Limited
 */

package com.think.clean.service.log;

import com.think.clean.common.mapper.log.LogItemMapper;
import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.domain.port.log.LogGateway;
import com.think.clean.repository.log.LogItemEntity;
import com.think.clean.repository.log.LogItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static io.github.perplexhub.rsql.RSQLJPASupport.toSpecification;

@Service
@RequiredArgsConstructor
public class LogService implements LogGateway<Page<LogItem>, Pageable, String> {

    private final LogItemRepository logItemRepository;
    private final LogItemMapper logItemMapper;

    @Override
    public Optional<LogItem> getLogById(String id) {
        Optional<LogItemEntity> entity = logItemRepository.findById(id);

        return entity.map(logItemMapper::entityToDomain);
    }

    @Override
    public Page<LogItem> getLogs(Pageable pageable, String filter) {
        Page<LogItemEntity> entities = logItemRepository.findAll(toSpecification(filter), pageable);

        return entities.map(logItemMapper::entityToDomain);
    }

    @Override
    @Transactional
    public void saveLogs(List<LogItem> logs) {
        logItemRepository.saveAll(
            logs.stream()
                .map(logItemMapper::domainToEntity)
                .collect(Collectors.toList())
        );
    }

}
