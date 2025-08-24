package com.gaoyifeng.common.infrastructure.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础日志工具类
 * 提供便捷的日志记录方法
 *
 * @author gaoyifeng
 */
public class BaseLogger {

    private final Logger logger;

    /**
     * 构造函数
     *
     * @param clazz 类对象
     */
    public BaseLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    /**
     * 构造函数
     *
     * @param name Logger名称
     */
    public BaseLogger(String name) {
        this.logger = LoggerFactory.getLogger(name);
    }

    /**
     * 获取Logger实例
     *
     * @return Logger实例
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * 记录信息日志
     *
     * @param message 日志消息
     * @param args 参数
     */
    public void info(String message, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(message, args);
        }
    }

    /**
     * 记录调试日志
     *
     * @param message 日志消息
     * @param args 参数
     */
    public void debug(String message, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug(message, args);
        }
    }

    /**
     * 记录警告日志
     *
     * @param message 日志消息
     * @param args 参数
     */
    public void warn(String message, Object... args) {
        if (logger.isWarnEnabled()) {
            logger.warn(message, args);
        }
    }

    /**
     * 记录错误日志
     *
     * @param message 日志消息
     * @param throwable 异常对象
     */
    public void error(String message, Throwable throwable) {
        if (logger.isErrorEnabled()) {
            logger.error(message, throwable);
        }
    }

    /**
     * 记录错误日志
     *
     * @param message 日志消息
     * @param args 参数
     */
    public void error(String message, Object... args) {
        if (logger.isErrorEnabled()) {
            logger.error(message, args);
        }
    }

    /**
     * 记录方法进入日志
     *
     * @param methodName 方法名
     * @param args 方法参数
     */
    public void enterMethod(String methodName, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug("进入方法: {} 参数: {}", methodName, args);
        }
    }

    /**
     * 记录方法退出日志
     *
     * @param methodName 方法名
     * @param result 返回结果
     */
    public void exitMethod(String methodName, Object result) {
        if (logger.isDebugEnabled()) {
            logger.debug("退出方法: {} 返回值: {}", methodName, result);
        }
    }

    /**
     * 记录方法执行时间
     *
     * @param methodName 方法名
     * @param startTime 开始时间
     */
    public void logExecutionTime(String methodName, long startTime) {
        if (logger.isInfoEnabled()) {
            long executionTime = System.currentTimeMillis() - startTime;
            logger.info("方法 {} 执行耗时: {}ms", methodName, executionTime);
        }
    }
}