package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AppContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName () {

        MemberService memberService = ac.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByType () {

        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("구현체 타입으로 조회")
    void findBeanByType2 () {
        //클래스는 역할 먼저 정의 interface - > class로 구현 implements
        // 변수의 타입은 interface로 생성은 구현체 class로 assign
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회가 안될때")
    void findBeanByTypeX () {

        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxx", MemberService.class));

    }

}
