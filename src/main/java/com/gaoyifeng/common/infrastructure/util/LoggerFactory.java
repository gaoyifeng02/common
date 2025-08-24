package com.gaoyifeng.common.infrastructure.util;

import org.slf4j.Logger;

/**
 * 日志工厂类
 * 提供统一的Logger实例创建方法
 * 
 * @author gaoyifeng
 */
public class LoggerFactory {
    
    /**
     * 获取指定类的Logger实例
     * 
     * @param clazz 类对象
     * @return Logger实例
     */
    public static Logger getLogger(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(clazz);
    }
    
    /**
     * 获取指定名称的Logger实例
     * 
     * @param name Logger名称
     * @return Logger实例
     */
    public static Logger getLogger(String name) {
        return org.slf4j.LoggerFactory.getLogger(name);
    }
    
    /**
     * 获取BaseLogger实例
     * 
     * @param clazz 类对象
     * @return BaseLogger实例
     */
    public static BaseLogger getBaseLogger(Class<?> clazz) {
        return new BaseLogger(clazz);
    }
    
    /**
     * 获取BaseLogger实例
     * 
     * @param name Logger名称
     * @return BaseLogger实例
     */
    public static BaseLogger getBaseLogger(String name) {
        return new BaseLogger(name);
    }
}