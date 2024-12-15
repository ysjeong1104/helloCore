package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return this.discountFixAmount;
        }
        return 0;
    }
}
