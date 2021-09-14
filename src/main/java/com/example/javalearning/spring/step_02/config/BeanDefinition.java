package com.example.javalearning.spring.step_02.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liugenlai
 * @since 2021/9/7 11:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanDefinition {
    private Class beanClass;
}
