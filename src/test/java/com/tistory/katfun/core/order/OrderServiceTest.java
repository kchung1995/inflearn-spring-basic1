package com.tistory.katfun.core.order;

import com.tistory.katfun.core.member.Grade;
import com.tistory.katfun.core.member.Member;
import com.tistory.katfun.core.member.MemberService;
import com.tistory.katfun.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertEquals(order.getDiscountPrice(), 1000);

    }
}
