package guru.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket dispatchApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("dispatchApi")
                .select()
                .apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
                .paths(regex("/dispatch.*"))
                .build()
                .apiInfo(metaData());
    }
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("onlinestore")
                .select()
                .apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
                .paths(regex("/product.*"))
                .build()
                .apiInfo(metaDataOnline());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Dispatch ",
                "API",
                "1.0",
                "Terms of service",
                new Contact("Ramesh Venkatesh", "", "venkateshr@schnider.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
    private ApiInfo metaDataOnline() {
        ApiInfo apiInfo = new ApiInfo(
                "Prodduct ",
                "API",
                "1.0",
                "Terms of service",
                new Contact("Ramesh Venkatesh", "", "venkateshr@schnider.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
