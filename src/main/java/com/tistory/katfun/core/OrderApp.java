package com.tistory.katfun.core;

import com.tistory.katfun.core.member.Grade;
import com.tistory.katfun.core.member.Member;
import com.tistory.katfun.core.member.MemberService;
import com.tistory.katfun.core.order.Order;
import com.tistory.katfun.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
        // System.out.println("order = " + order.calculatePrice());

    }
}
