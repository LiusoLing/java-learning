package com.example.javalearning.spring.step_02.support;

import com.example.javalearning.spring.step_02.BeansException;
import com.example.javalearning.spring.step_02.config.BeanDefinition;

/**
 * @author liugenlai
 * @since 2021/9/7 14:29
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException{
        Object object = null;
        try {
            object = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, object);
        return object;
    }
}
