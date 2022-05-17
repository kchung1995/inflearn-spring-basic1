package com.tistory.katfun.core.singleton;

import com.tistory.katfun.core.AppConfig;
import com.tistory.katfun.core.member.MemberRepository;
import com.tistory.katfun.core.member.MemberServiceImpl;
import com.tistory.katfun.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // 순수한 클라스라면 아래와 같이 출력되어야 한다.
        // bean = class com.tistory.katfun.core.AppConfig
        // bean = class com.tistory.katfun.core.AppConfig$$EnhancerBySpringCGLIB$$af945e9f
        // CGLIB: 바이트코드 조작 라이브러리 - 임의의 다른 클라스를 만들어 스프링 빈으로 등록
        // CGLIB가 싱글톤이 되도록 보장해 준다.
        // appConfig@CGLIB는 appConfig의 자식 타입이므로 appConfig으로 조회해도 뜬 것이다
        // @Configuration을 사용하지 않고 @Bean만 사용하면, 예상했던 대로 여러 번 호출된다.
    }
}
