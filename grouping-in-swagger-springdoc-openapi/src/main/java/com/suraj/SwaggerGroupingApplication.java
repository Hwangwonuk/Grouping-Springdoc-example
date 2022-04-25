package com.suraj;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwaggerGroupingApplication {

  public static void main(String[] args) {
    SpringApplication.run(SwaggerGroupingApplication.class, args);
  }

  @Bean
  GroupedOpenApi userApis() {
    return GroupedOpenApi
        .builder()
        .group("user")
        .pathsToMatch("/**/user/**")
        .addOpenApiCustomiser(userApiCustom())
        .build();
  }

  @Bean
  GroupedOpenApi adminApis() {
    return GroupedOpenApi
        .builder()
        .group("admin")
        .pathsToMatch("/**/admin/**")
        .addOpenApiCustomiser(adminApiCustom())
        .build();
  }

  @Bean
  GroupedOpenApi opsApis() {
    return GroupedOpenApi
        .builder()
        .group("operation")
        .pathsToMatch("/**/operation/**")
        .addOpenApiCustomiser(opsApiCustom())
        .build();
  }

  public Info userInfo() {
    return new Info()
        .title("user")
        .version("1.0")
        .description("유저 description")
        .contact(new Contact()
            .url("www.wonuk.com")
            .email("wonuk_hwang@bigin.io"))
        .license(new License().url("https://test.com"))
        .termsOfService("apiTermsOfServiceUrl");
  }

  public Info adminInfo() {
    return new Info()
        .title("admin")
        .version("1.0")
        .description("admin description")
        .contact(new Contact()
            .url("www.wonuk.com")
            .email("wonuk_hwang@bigin.io"))
        .license(new License().url("https://test.com"))
        .termsOfService("apiTermsOfServiceUrl");
  }

  public Info opsInfo() {
    return new Info()
        .title("ops")
        .version("1.0")
        .description("ops description")
        .contact(new Contact()
            .url("www.wonuk.com")
            .email("wonuk_hwang@bigin.io"))
        .license(new License().url("https://test.com"))
        .termsOfService("apiTermsOfServiceUrl");
  }

  public OpenApiCustomiser userApiCustom() {
    return new OpenApiCustomiser() {
      @Override
      public void customise(OpenAPI openApi) {
        openApi
            .info(userInfo())
            .components(new Components()
                .addSchemas("key", new Schema())
            );
      }
    };
  }

  public OpenApiCustomiser adminApiCustom() {
    return new OpenApiCustomiser() {
      @Override
      public void customise(OpenAPI openApi) {
        openApi.info(adminInfo());
      }
    };
  }

  public OpenApiCustomiser opsApiCustom() {
    return new OpenApiCustomiser() {
      @Override
      public void customise(OpenAPI openApi) {
        openApi.info(opsInfo());
      }
    };
  }

}
