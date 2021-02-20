/*
 * Copyright Stuff Limited
 */

package com.think.clean.configuration.rsql;

import io.github.perplexhub.rsql.RSQLJPASupport;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import java.time.Instant;

@Configuration
public class RsqlJpaConfiguration {

    @EventListener(ApplicationReadyEvent.class)
    public void registerCustomConverters() {
        RSQLJPASupport.addConverter(Instant.class, Instant::parse);
    }

}
