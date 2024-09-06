package com.yao.app.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

/**
 * @author yaolei313@gmail.com
 * @data 2022/9/29
 */
@Configuration
public class OASConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("springboot-study")
            .pathsToMatch("/**")
            .build();
    }

    /**
     * https://springdoc.org/index.html#how-can-i-deploy-springdoc-openapi-ui-behind-a-reverse-proxy
     * @link org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration#ForwardedHeaderFilterConfiguration 中会创建ForwardedHeaderFilter bean。
     */
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("SpringBoot Study API")
                .description("Spring boot study application")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0").url("http://app.yao.com")))
            .externalDocs(new ExternalDocumentation()
                .description("Wiki Documentation")
                .url("https://yaolei313.github.io/"));
    }
}
