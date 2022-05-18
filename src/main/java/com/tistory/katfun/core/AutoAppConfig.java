package com.tistory.katfun.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.tistory.katfun.core.member",
        basePackageClasses = AutoAppConfig.class,
        // 지정하지 않으면 default에 따라 componentscan이 속한 패키지부터 뒤진다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// @Component가 붙은 모든 클라스를 찾아서 bean으로 등록해 준다.
// excludeFilters - 기존 AppConfig 관련 내용이 등록되지 않도록 해제
public class AutoAppConfig {

}
