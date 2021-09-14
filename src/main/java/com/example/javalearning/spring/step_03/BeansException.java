package com.example.javalearning.spring.step_03;

/**
 * @author liugenlai
 * @since 2021/9/7 15:39
 */
public class BeansException extends RuntimeException{

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
