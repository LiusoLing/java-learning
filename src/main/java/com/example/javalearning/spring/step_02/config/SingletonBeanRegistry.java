package com.example.javalearning.spring.step_02.config;

/**
 * @author liugenlai
 * @since 2021/9/7 11:29
 */
public interface SingletonBeanRegistry {
    /**
     * 获取单例对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
