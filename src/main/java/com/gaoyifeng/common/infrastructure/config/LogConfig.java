package com.gaoyifeng.common.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 统一日志配置类
 * 提供日志工具方法和配置
 * 
 * @author gaoyifeng
 */
@Configuration
public class LogConfig {
    
    /**
     * 获取指定类的Logger实例
     * 
     * @param clazz 类对象
     * @return Logger实例
     */
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
    
    /**
     * 获取指定名称的Logger实例
     * 
     * @param name Logger名称
     * @return Logger实例
     */
    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }
    
    /**
     * 记录信息日志
     * 
     * @param logger Logger实例
     * @param message 日志消息
     * @param args 参数
     */
    public static void info(Logger logger, String message, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(message, args);
        }
    }
    
    /**
     * 记录调试日志
     * 
     * @param logger Logger实例
     * @param message 日志消息
     * @param args 参数
     */
    public static void debug(Logger logger, String message, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug(message, args);
        }
    }
    
    /**
     * 记录警告日志
     * 
     * @param logger Logger实例
     * @param message 日志消息
     * @param args 参数
     */
    public static void warn(Logger logger, String message, Object... args) {
        if (logger.isWarnEnabled()) {
            logger.warn(message, args);
        }
    }
    
    /**
     * 记录错误日志
     * 
     * @param logger Logger实例
     * @param message 日志消息
     * @param throwable 异常对象
     */
    public static void error(Logger logger, String message, Throwable throwable) {
        if (logger.isErrorEnabled()) {
            logger.error(message, throwable);
        }
    }
    
    /**
     * 记录错误日志
     * 
     * @param logger Logger实例
     * @param message 日志消息
     * @param args 参数
     */
    public static void error(Logger logger, String message, Object... args) {
        if (logger.isErrorEnabled()) {
            logger.error(message, args);
        }
    }
}