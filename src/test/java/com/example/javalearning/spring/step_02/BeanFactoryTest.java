package com.example.javalearning.spring.step_02;

import com.example.javalearning.spring.step_01.bean.UserService;
import com.example.javalearning.spring.step_02.config.BeanDefinition;
import com.example.javalearning.spring.step_02.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

/**
 * @author liugenlai
 * @since 2021/9/7 15:11
 */
class BeanFactoryTest {

    @Test
    public void test_BeanFactory() {
        // 1、初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2、注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3、使用 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4、使用单例 bean
        UserService singletonUserService = (UserService) beanFactory.getBean("userService");
        singletonUserService.queryUserInfo();
    }
}