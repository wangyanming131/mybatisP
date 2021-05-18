package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置类,受限通过@EnableSwagger2注解启用Swagger2,然后配置一个DockerBean,
 * 这个bean中,配置映射路径和要扫描的接口位置,在apiinfo中配置Swagger2文档网站的信息,
 * 例如网站的title,网站的描述,联系人的信息,使用的协议等等
 * 访问地址:/demo/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket creatRestApi() {
        Contact contact = new Contact("naruto", "http://www.blog.csdn.net", "1580870593@qq.com");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("SpringBoot整合Swagger2")
                .description("SpringBoot整合Swagger2,详细信息...")
                .version("9.0")
                .contact(contact)
                .license("The Apache Licence")
                .licenseUrl("https://weibo.com")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.restApi"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo);
        return docket;
    }

}
