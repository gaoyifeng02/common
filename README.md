# Common模块

## 简介

Common模块是一个通用工具模块，提供了项目中共享的基础组件、工具类和配置。该模块旨在减少代码重复，提高开发效率，并确保整个项目中的一致性。

## 主要功能

- **统一响应处理**：Result和ResultCode类用于API响应的标准化封装
- **跨域配置**：提供全局CORS配置
- **其他基础设施**：包含项目中共享的基础组件和工具类

## 最近改进

### 版本 0.0.3-SNAPSHOT


#### Result和ResultCode类改进

#### 核心改进

1. **增强了Result类的功能和健壮性**
   - 实现了Serializable接口，支持序列化
   - 将字段声明为final，确保不可变性
   - 修复了泛型使用不一致的问题
   - 添加了equals()、hashCode()和toString()方法

2. **扩展了ResultCode枚举**
   - 添加了常用HTTP状态码（400、401、403、404等）
   - 添加了业务相关状态码（10001-10008）
   - 将字段声明为final，确保不可变性
   - 添加了getByCode()工具方法

#### API改进

1. **Result类新增工厂方法**
   - `success()` - 不带数据的成功结果
   - `success(String message, T data)` - 自定义消息的成功结果
   - `fail()` - 不带数据的失败结果（400错误码）
   - `fail(ResultCode resultCode)` - 使用指定结果代码的失败结果
   - `fail(ResultCode resultCode, String message)` - 使用指定结果代码和自定义消息的失败结果
   - `fail(String code, String message)` - 使用自定义代码和消息的失败结果
   - `isSuccess()` - 判断结果是否成功

2. **ResultCode类新增状态码**
   - 客户端错误：400、401、403、404、405、408、429
   - 服务器错误：500、501、502、503、504
   - 业务错误：参数错误、业务处理失败、未授权、禁止访问等

## 使用示例

### 返回成功结果

```java
// 返回带数据的成功结果
public Result<User> getUser(Long id) {
    User user = userService.findById(id);
    return Result.success(user);
}

// 返回不带数据的成功结果
public Result<Void> deleteUser(Long id) {
    userService.delete(id);
    return Result.success();
}

// 返回自定义消息的成功结果
public Result<User> createUser(User user) {
    User savedUser = userService.save(user);
    return Result.success("用户创建成功", savedUser);
}
```

### 返回失败结果

```java
// 返回默认的失败结果（400错误）
public Result<User> getUser(Long id) {
    if (id == null) {
        return Result.fail();
    }
    // ...
}

// 返回指定状态码的失败结果
public Result<User> getUser(Long id) {
    User user = userService.findById(id);
    if (user == null) {
        return Result.fail(ResultCode._404);
    }
    return Result.success(user);
}

// 返回自定义消息的失败结果
public Result<User> updateUser(Long id, User user) {
    if (!userService.exists(id)) {
        return Result.fail(ResultCode._404, "用户ID " + id + " 不存在");
    }
    // ...
}
```

### 判断结果是否成功

```java
Result<User> result = userService.getUser(id);
if (result.isSuccess()) {
    // 处理成功情况
    User user = result.getData();
    // ...
} else {
    // 处理失败情况
    String errorCode = result.getCode();
    String errorMessage = result.getInfo();
    // ...
}
```