package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBeans(){

        String[] beanDefinitionName = ac.getBeanDefinitionNames();

        for (String beanName : beanDefinitionName) {

            Object bean = ac.getBean(beanName);

            System.out.println("name= "+beanName+" object = "+bean);
        }
    }

    @Test
    @DisplayName("app빈 출력")
    void findAllApplicationBeans(){

        String[] beanDefinitionName = ac.getBeanDefinitionNames();

        for (String beanName : beanDefinitionName) {

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);
            //BeanDefinition.ROLE_APPLICATION 사용자가 정의한 빈
            //BeanDefinition.ROLE_INFRASTRUCTURE 스프링내부에서 사용하는 빈

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanName);

                System.out.println("name= " + beanName + " object = " + bean);
            }
        }
    }


}
