package cn.henghuasoft.config;/**
 * @author shkstart
 * @create 2023-04-24 13:39
 */

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class Knife4jConfig {

    private static final String splitor = ";";

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("系统中心接口文档")
                .description("系统中心接口文档，仅限内部使用")
                .termsOfServiceUrl("http://www.henghuasoft.cn")
                .contact(new Contact("jarvis", "www.henghuasoft.cn", "swords_man12@163.com"))
                .version("1.0")
                .build();
    }

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 分组名称
                // .groupName("系统管理接口")
                .select()
                // 指定controller（接口）扫描的包路径
                // .apis(RequestHandlerSelectors.basePackage("com.wb.api.controller"))
                .apis(basePackage("cn.henghuasoft.controller" + splitor))
                .paths(PathSelectors.any())
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

}
