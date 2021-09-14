package com.example.javalearning.spring.step_02.support;

import com.example.javalearning.spring.step_02.config.BeanDefinition;

/**
 * @author liugenlai
 * @since 2021/9/7 11:41
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
