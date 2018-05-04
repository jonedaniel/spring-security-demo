# plainttest
1. 集成redis，注入redisService可使用相关功能
2. userContext 获取用户相关信息
3. 引入 bootstrap与 layer,jquery-ui前端插件
4. 使用 ControllerAspect 打印日志

## spring security schedule
1. 集成springsecurity基础功能
2. 关闭数据库密码加密
3. 开启remember-me
4. session策略设置为只允许用户在单个地点登陆，在别处登陆，之前的自动失效
5. 使用SpringSocial允许qq用户登陆  X 没有qq互联权限

## 备注
1. 该项目基于springboot。
2. 创建 dev 数据库，将data.sql的数据写入。
3. 如果报错连接错误,**请确认你的mysql与redis配置正确**
4. 使用spring social登陆qq，请自行到qq互联申请配置
