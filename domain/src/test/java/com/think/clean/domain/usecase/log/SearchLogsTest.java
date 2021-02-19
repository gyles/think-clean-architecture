/*
 * Copyright Stuff Limited
 */

package com.think.clean.domain.usecase.log;

import com.think.clean.domain.entity.log.LogItem;
import com.think.clean.domain.port.log.LogGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class SearchLogsTest {

    private SearchLogs<List<LogItem>, String, String> useCase;

    @Mock
    private LogGateway<List<LogItem>, String, String> logGateway;

    @BeforeEach
    void prepareUseCase() {
        useCase = new SearchLogs<>(logGateway);
    }

    @Nested
    class SearchById {

        @Captor
        private ArgumentCaptor<String> argumentCaptor;

        @Test
        void testThatGivenLogItemWhenSearchingByIdThenShouldGetItemByItem() {
            useCase.searchLogById(UUID.randomUUID().toString());

            then(logGateway).should().getLogById(argumentCaptor.capture());
            assertThat(argumentCaptor.getValue()).isNotEmpty();
        }

    }

    @Nested
    class SearchByQuery {

        @Captor
        private ArgumentCaptor<String> requestCaptor;

        @Captor
        private ArgumentCaptor<String> queryCaptor;

        @Test
        void testThatGivenLogItemWhenSearchingByIdThenShouldGetItemByItem() {
            String request = "request";
            String query = "userId==5087d5bf-4f78-413b-b700-620a24306d56";
            useCase.searchByQuery(request, query);

            then(logGateway).should().getLogs(requestCaptor.capture(), queryCaptor.capture());
            assertThat(requestCaptor.getValue()).isEqualTo(request);
            assertThat(queryCaptor.getValue()).isEqualTo(query);
        }

    }

}
