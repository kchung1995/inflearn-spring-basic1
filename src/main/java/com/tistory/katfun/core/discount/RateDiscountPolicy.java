package com.tistory.katfun.core.discount;

import com.tistory.katfun.core.member.Grade;
import com.tistory.katfun.core.member.Member;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Qualifier("mainDiscountPolicy")
=======
import org.springframework.stereotype.Component;

@Component
>>>>>>> ec076fdfbb79226b3a821fe070b74da90e033abc
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
