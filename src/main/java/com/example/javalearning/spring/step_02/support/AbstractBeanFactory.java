package com.example.javalearning.spring.step_02.support;

import com.example.javalearning.spring.step_02.BeanFactory;
import com.example.javalearning.spring.step_02.BeansException;
import com.example.javalearning.spring.step_02.config.BeanDefinition;

/**
 * @author liugenlai
 * @since 2021/9/7 11:59
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        Object object = getSingleton(beanName);
        if (object != null) {
            return object;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
