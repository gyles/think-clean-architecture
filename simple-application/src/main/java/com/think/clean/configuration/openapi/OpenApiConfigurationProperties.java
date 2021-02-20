/*
 * Copyright Stuff Limited
 */

package com.think.clean.configuration.openapi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openapi")
@Data
public class OpenApiConfigurationProperties {

    private String title;
    private String description;
    private String version;
    private SecurityScheme securityScheme;

    @Data
    public static class SecurityScheme {
        private Bearer bearer;
    }

    @Data
    public static class Bearer {
        private String name;
        private String scheme;
    }

}
