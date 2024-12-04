package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {
    public static void main(String[] args) {

      //  AppConfig appConfig = new AppConfig();
       // MemberService memberService = appConfig.memberService();
       // OrderService orderService = appConfig.orderService();

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = appContext.getBean("memberService", MemberService.class);
        OrderService orderService = appContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",20000);

        System.out.println("order = "+order.toString());
        System.out.println("order cal = "+order.calculatePrice());

    }
}
