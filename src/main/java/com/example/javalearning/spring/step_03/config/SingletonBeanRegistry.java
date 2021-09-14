package com.example.javalearning.spring.step_03.config;

/**
 * @author liugenlai
 * @since 2021/9/7 15:40
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
