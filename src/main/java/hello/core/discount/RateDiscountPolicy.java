package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("rateDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountRate = 10;
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP)
            return price * discountRate / 100;
        return 0;
    }
}
