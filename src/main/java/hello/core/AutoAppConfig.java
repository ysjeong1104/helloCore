package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


//컴포넌트스캔 예제
@Configuration
@ComponentScan (
   //     basePackages = "hello.core.member", //탐색할 패키지의 시작위치
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter (type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
