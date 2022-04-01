package com.tistory.katfun.core.discount;

import com.tistory.katfun.core.member.Grade;
import com.tistory.katfun.core.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy {

    private int discountFixedAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixedAmount;
        }
        else return 0;
    }
}
