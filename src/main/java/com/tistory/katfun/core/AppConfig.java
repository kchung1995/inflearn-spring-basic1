package com.tistory.katfun.core;

import com.tistory.katfun.core.discount.DiscountPolicy;
import com.tistory.katfun.core.discount.FixedDiscountPolicy;
import com.tistory.katfun.core.member.MemberRepository;
import com.tistory.katfun.core.member.MemberService;
import com.tistory.katfun.core.member.MemberServiceImpl;
import com.tistory.katfun.core.member.MemoryMemberRepository;
import com.tistory.katfun.core.order.OrderService;
import com.tistory.katfun.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixedDiscountPolicy();
    }
}
