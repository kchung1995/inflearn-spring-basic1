package com.tistory.katfun.core;

import com.tistory.katfun.core.discount.DiscountPolicy;
import com.tistory.katfun.core.discount.RateDiscountPolicy;
import com.tistory.katfun.core.member.MemberRepository;
import com.tistory.katfun.core.member.MemberService;
import com.tistory.katfun.core.member.MemberServiceImpl;
import com.tistory.katfun.core.member.MemoryMemberRepository;
import com.tistory.katfun.core.order.OrderService;
import com.tistory.katfun.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixedDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
