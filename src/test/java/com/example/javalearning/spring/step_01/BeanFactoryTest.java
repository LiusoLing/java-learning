package com.example.javalearning.spring.step_01;

import com.example.javalearning.spring.step_01.bean.UserService;
import org.junit.jupiter.api.Test;

/**
 * @author liugenlai
 * @since 2021/9/7 10:29
 */
class BeanFactoryTest {

    @Test
    public void test_BeanFactory() {
        // 1、创建 beanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2、注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3、使用 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}