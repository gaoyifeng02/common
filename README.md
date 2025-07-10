# Common 公共组件库

## 项目简介
本项目提供通用的基础组件和工具类，供其他微服务模块使用。

## 核心组件

### Result 统一响应封装类
提供标准化的API响应格式，支持泛型类型。

#### 主要方法
- `success()`: 创建成功响应
- `success(T data)`: 创建带数据的成功响应
- `success(String message, T data)`: 创建带自定义消息的成功响应
- `fail()`: 创建失败响应
- `fail(String message)`: 创建带自定义消息的失败响应（支持泛型）
- `fail(ResultCode resultCode)`: 使用预定义错误码创建失败响应
- `fail(ResultCode resultCode, String message)`: 使用预定义错误码和自定义消息创建失败响应

#### 泛型支持示例
```java
// 成功响应
Result<User> successResult = Result.success(user);

// 失败响应
Result<User> failResult = Result.fail("用户名不能为空");
```

## 使用示例
```java
// 成功响应示例
return Result.success("操作成功", data);

// 失败响应示例
return Result.fail(ResultCode.PARAM_ERROR, "参数校验失败");
```