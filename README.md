# 全栈开发项目 - 极简图床 & 联系人系统

**课程作业**：刘春老师 Web全栈开发课程  
**技术栈**：Vue.js + Spring Boot + JMeter测试  

项目已开源，如果对您有帮助欢迎 ⭐Star 支持！

## 🧱 项目结构

src/

├── main/

│  ├── java/

│  │  ├── com.example.webapp/

│  │  │  ├── config/     # Spring Boot 配置类

│  │  │  ├── exception/     # 一些自定义的异常+全局异常处理

│  │  │  ├── controller/   # 控制器层

│  │  │  ├── model/      # 数据模型（实体类）

│  │  │  ├── service/     # 业务逻辑层

│  │  │  ├── mapper/     # MyBatis Mapper 接口

│  │  │  └── WebappApplication.java # 启动类

│  └── resources/

│    ├── mapper/       # MyBatis XML 映射文件

│    ├── static/       # 静态资源

│    ├── application.properties # 配置文件

│    └── application.yml   # 可选 YAML 配置

pom.xml             # Maven 依赖管理

## 🌟 项目亮点
1. **双系统融合**：同时实现图床服务+联系人管理系统
2. **完整异常处理**：规范化后端异常返回结构
3. **压力测试**：使用JMeter进行API性能测试
4. **极简设计**：保持核心功能的最小化实现

## 🛠️ 核心功能
- **图床服务**  
  - 极简图片上传/存储功能
  - 作者信息返回接口

- **联系人管理**  
  - 完整的CRUD功能（增删改查）
  - 批量获取联系人接口

- **用户系统**  
  - 登录/注册/密码修改闭环
  - 统一异常处理（HTTP状态码+错误信息体）

## ⚙️ 技术实现
```text
├─ 前后端分离架构
├─ RESTful API设计
├─ JMeter压力测试
└─ 分层异常处理体系