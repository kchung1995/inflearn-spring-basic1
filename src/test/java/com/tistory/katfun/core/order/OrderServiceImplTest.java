package com.tistory.katfun.core.order;

import com.tistory.katfun.core.discount.FixedDiscountPolicy;
import com.tistory.katfun.core.member.Grade;
import com.tistory.katfun.core.member.Member;
import com.tistory.katfun.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixedDiscountPolicy());
        Order order = orderService.createOrder(1L, "name", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}