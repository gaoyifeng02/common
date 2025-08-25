# Common 公共组件库

## 项目简介
本项目提供通用的基础组件和工具类，供其他微服务模块使用。

## 目录结构
- config：
    - corsconfig 全局配置跨域允许
    - jwtconfig 全局配置jwt支持
    - logconfig 全局配置自定义log
- commom：
    - Result 所有的API接口的通用返回
    - ResultCode 所有的API接口的通用返回码
    - PageRequest 所有API接口分页相关的请求对象
    - PageResult 所有API接口分页相关的返回对象
- util：
    - LoggerFactory 获取日志类
    - JwtUtil jwt工具类