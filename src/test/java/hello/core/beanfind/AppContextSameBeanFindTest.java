package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AppContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은타입이 둘 이상 있으면, 중복 오류 발생")
    void findBeanByTypeDuplaction(){
        //MemberRepository bean = ac.getBean(MemberRepository.class);

        assertThrows(NoUniqueBeanDefinitionException.class,()-> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입이 둘이상이면 빈 이름을 지정")
    void findBeanByName(){
        MemberRepository bean = ac.getBean("memberRepository1",MemberRepository.class);

        org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(MemberRepository.class);
        //Assertions.assertThrows(NoUniqueBeanDefinitionException.class,()-> ac.getBean(MemberRepository.class));
    }
    @Test
    @DisplayName("특정타입 모두 조회하기")
    void findAllBeanByType(){

        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key="+key+" value= "+beansOfType.get(key));
        }

        System.out.println("beansOfType="+beansOfType);
    }

    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
