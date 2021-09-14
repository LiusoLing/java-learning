package com.example.javalearning.spring.step_01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liugenlai
 * @since 2021/9/7 10:23
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
