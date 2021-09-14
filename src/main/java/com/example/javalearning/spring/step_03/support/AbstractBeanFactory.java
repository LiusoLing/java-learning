package com.example.javalearning.spring.step_03.support;

import com.example.javalearning.spring.step_03.BeanFactory;
import com.example.javalearning.spring.step_03.BeansException;
import com.example.javalearning.spring.step_03.config.BeanDefinition;

/**
 * @author liugenlai
 * @since 2021/9/7 16:20
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    /**
     * 方法参数前面加final关键字就是为了防止数据在方法体中被修改
     * 基本类型：参数的值在方法体内是不能被修改的，即不能被重新赋值
     * 引用类型：可以改变值，但是不能重新赋值。stu = new Student 不被允许
     * @param beanName
     * @param args
     * @param <T>
     * @return
     */
    protected <T> T doGetBean(final String beanName, final Object[] args) {
        Object object = getSingleton(beanName);
        if (object != null) {
            return (T) object;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException;
}
