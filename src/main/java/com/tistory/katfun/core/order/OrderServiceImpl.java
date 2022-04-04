package com.tistory.katfun.core.order;

import com.tistory.katfun.core.discount.DiscountPolicy;
import com.tistory.katfun.core.discount.FixedDiscountPolicy;
import com.tistory.katfun.core.discount.RateDiscountPolicy;
import com.tistory.katfun.core.member.Member;
import com.tistory.katfun.core.member.MemberRepository;
import com.tistory.katfun.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
