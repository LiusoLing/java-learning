package com.example.javalearning.spring.step_02;

/**
 * @author liugenlai
 * @since 2021/9/7 11:38
 */
public class BeansException extends RuntimeException{

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
