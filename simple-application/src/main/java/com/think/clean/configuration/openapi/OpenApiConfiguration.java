/*
 * Copyright Stuff Limited
 */

package com.think.clean.configuration.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfiguration {

    private final OpenApiConfigurationProperties properties;

    @Bean
    public OpenAPI openApi() {
        OpenApiConfigurationProperties.Bearer bearer = properties.getSecurityScheme().getBearer();

        return new OpenAPI()
            .info(new Info()
                .title(properties.getTitle())
                .version(properties.getVersion())
                .description(properties.getDescription()))
            .components(new Components()
//                .addSecuritySchemes(oauth.getName(), new SecurityScheme()
//                    .name(oauth.getName())
//                    .type(SecurityScheme.Type.OAUTH2)
//                    .extensions(Map.of("x-tokenName", "id_token"))
//                    .flows(new OAuthFlows()
//                        .authorizationCode(new OAuthFlow()
//                            .authorizationUrl(oauth.getAuthorizationUrl())
//                            .tokenUrl(oauth.getTokenUrl())
//                            .scopes(new Scopes())
//                        )
//                    ))
                .addSecuritySchemes(bearer.getName(), new SecurityScheme()
                    .name(bearer.getName())
                    .scheme(bearer.getScheme())
                    .type(SecurityScheme.Type.HTTP)
                    .in(SecurityScheme.In.HEADER)))
            .security(List.of(new SecurityRequirement().addList(bearer.getName())));
    }

    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> openApi.getPaths().values().forEach(pathItem ->
            pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();
                apiResponses.addApiResponse("401", new ApiResponse()
                    .description("Unauthorized. Missing credentials to access this resource"));
                apiResponses.addApiResponse("403", new ApiResponse()
                    .description("Forbidden. Missing permissions to access this resource."));
            })
        );
    }

}
