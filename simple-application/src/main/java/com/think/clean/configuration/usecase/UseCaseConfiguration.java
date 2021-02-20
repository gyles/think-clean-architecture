/*
 * Copyright Stuff Limited
 */

package com.think.clean.configuration.usecase;

import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.domain.port.log.LogGateway;
import com.think.clean.domain.usecase.log.SearchLogs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public SearchLogs<Page<LogItem>, Pageable, String> searchLogs(
        LogGateway<Page<LogItem>, Pageable, String> logGateway) {
        return new SearchLogs<>(logGateway);
    }

}
