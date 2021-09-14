package com.example.javalearning.spring.step_03.support;

import com.example.javalearning.spring.step_03.BeansException;
import com.example.javalearning.spring.step_03.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author liugenlai
 * @since 2021/9/7 16:37
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException {
        Object object = null;
        try {
            object = createBeanInstance(beanName, beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, object);
        return object;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws NoSuchMethodException {
        Constructor constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 该 Class 所有已声明的构造函数
        Constructor<?>[] declaredConstructor = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructor) {
            if (null != ctor && ctor.getParameterTypes().length == args.length) {
                // 根据参数
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, constructor, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}
