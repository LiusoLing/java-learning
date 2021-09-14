package com.example.javalearning.spring.step_03.support;

import com.example.javalearning.spring.step_03.BeansException;
import com.example.javalearning.spring.step_03.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author liugenlai
 * @since 2021/9/7 17:21
 */
public interface InstantiationStrategy {

    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) throws BeansException;
}
