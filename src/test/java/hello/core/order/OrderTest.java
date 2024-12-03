package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    void createOrder(){
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        OrderService orderService = new OrderServiceImpl(memberService,new FixDiscountPolicy());

        Long memberId = 1L;
        Member member = new Member(memberId, "memA", Grade.VIP);
        memberService.join(member);

        Order order  = orderService.createOrder(memberId,"itemA",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
