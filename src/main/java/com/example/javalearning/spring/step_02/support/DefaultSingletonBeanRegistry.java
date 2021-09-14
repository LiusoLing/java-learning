package com.example.javalearning.spring.step_02.support;

import com.example.javalearning.spring.step_02.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liugenlai
 * @since 2021/9/7 11:44
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 获取单例对象
     *
     * @param beanName
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object object) {
        singletonObjects.put(beanName, object);
    }
}
