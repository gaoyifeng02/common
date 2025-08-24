package com.gaoyifeng.common.infrastructure.config;

import com.gaoyifeng.common.infrastructure.util.BaseLogger;
import com.gaoyifeng.common.infrastructure.util.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 配置类加载日志记录器
 * 用于在Spring配置类被加载时打印日志信息
 * 
 * @author gaoyifeng
 */
@Configuration
public class ConfigLoadLogger implements BeanPostProcessor {
    
    private final BaseLogger logger = LoggerFactory.getBaseLogger(ConfigLoadLogger.class);
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 检查bean是否是配置类
        if (isConfigurationBean(bean)) {
            // 使用AopUtils.getTargetClass获取真实的类名，而不是代理类名
            String className = AopUtils.getTargetClass(bean).getName();
            // 只记录com.gaoyifeng包下的配置类
            if (className.startsWith("com.gaoyifeng")) {
                logger.info("common项目的配置类 {} 已装配", className);
            }
        }
        return bean;
    }
    
    /**
     * 判断bean是否是配置类
     * 
     * @param bean 要检查的bean
     * @return 如果是配置类返回true，否则返回false
     */
    private boolean isConfigurationBean(Object bean) {
        // 使用AopUtils.getTargetClass获取真实的类，而不是代理类
        return AnnotationUtils.findAnnotation(AopUtils.getTargetClass(bean), Configuration.class) != null;
    }
}