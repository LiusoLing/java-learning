package com.example.javalearning.spring.step_03.support;

import com.example.javalearning.spring.step_03.config.BeanDefinition;

import java.util.Map;

/**
 * @author liugenlai
 * @since 2021/9/7 15:42
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
