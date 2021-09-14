package com.example.javalearning.spring.step_03;

/**
 * @author liugenlai
 * @since 2021/9/7 15:38
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;
}
