package com.tistory.katfun.core;

import com.tistory.katfun.core.member.MemberRepository;
import com.tistory.katfun.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
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

    // 수동 등록 빈이 자동 등록 빈에 비해 우선권을 가진다.
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//    // 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을 바꾸었다.
//    // 스프링 부트인 'CoreApplication' 을 실행하면 알 수 있다.
}
