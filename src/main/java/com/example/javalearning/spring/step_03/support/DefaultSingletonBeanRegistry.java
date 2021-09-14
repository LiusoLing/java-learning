package com.example.javalearning.spring.step_03.support;

import com.example.javalearning.spring.step_03.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liugenlai
 * @since 2021/9/7 16:16
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> objectMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return objectMap.get(beanName);
    }

    public void addSingleton(String beanName, Object object) {
        objectMap.put(beanName, object);
    }
}
