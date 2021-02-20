/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.usecase.log;

import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.domain.entity.log.Payload;
import com.think.clean.domain.port.log.LogGateway;
import com.think.clean.domain.usecase.exception.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
public class SaveLogsTest {

    private SaveLogs<List<LogItem>, String, String> useCase;

    @Mock
    private LogGateway<List<LogItem>, String, String> logGateway;

    @BeforeEach
    void prepareUseCase() {
        useCase = new SaveLogs<>(logGateway);
    }

    @Nested
    class Validation {

        @Test
        void testThatGivenNoLogItemWhenSavingLogsThenShouldThrowADomainException() {
            assertThrows(DomainException.class, () -> useCase.saveLogs(List.of()), "Cannot save empty logs.");
            then(logGateway).should(never()).saveLogs(any());
        }

    }

    @Nested
    class SuccessCase {

        @Captor
        private ArgumentCaptor<List<LogItem>> listArgumentCaptor;

        @Test
        void testThatGivenLogItemsWhenSavingLogsThenShouldAllowSave() {
            List<LogItem> logs = List.of(
                new LogItem(Instant.now(), UUID.randomUUID().toString(),
                    "GET", "/order/32e1bbc1-74f9-42bb-8ee5-c1efd819ce66"),
                new LogItem(Instant.now(), UUID.randomUUID().toString(),
                    "POST", "/order", new Payload(UUID.randomUUID().toString(), 5))
            );

            useCase.saveLogs(logs);

            then(logGateway).should().saveLogs(listArgumentCaptor.capture());
            assertThat(listArgumentCaptor.getValue()).isEqualTo(logs);
        }

    }

}
