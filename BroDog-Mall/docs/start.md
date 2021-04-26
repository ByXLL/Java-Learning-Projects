# 前期准备

## 创建Maven多模块项目

> 首先，创建一个Maven项目，作为项目的父模块，在创建完成后，将`src`目录删除
>
> 再创建`mall-admin`和`mall-common`模块，在创建的时候依然选择`Maven`项目

![image-20210423093409722](.\images\image-20210423093409722.png)

## 在父`pom`文件中添加项目需要的包

> 在`properties`标签中声明包版本，`dependencyManagement`标签中声明全局的包，子模块可以按需导入，并且可以忽略版本
>
> 在`dependencies`标签中声明的全局强制继承的包，子模块回自动继承导入该包

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.brodog</groupId>
    <artifactId>BroDog-Mall</artifactId>
    <packaging>pom</packaging>
    <version>1.0</version>
    <!-- 声明子模块 -->
    <modules>
        <module>mall-admin</module>
        <module>mall-common</module>
    </modules>

    <!--  自定义配置  -->
    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <spring.core.version>5.3.5</spring.core.version>
        <springboot.version>2.4.4</springboot.version>
        <spring.tx.version>5.3.5</spring.tx.version>
        <lombok.version>1.18.18</lombok.version>
        <mysql.connector.version>8.0.23</mysql.connector.version>
        <mybatis.plus.version>3.0.5</mybatis.plus.version>
        <velocity.engine.version>2.3</velocity.engine.version>
        <druid.version>1.2.5</druid.version>
        <druid.spring.boot.starter.version>1.2.5</druid.spring.boot.starter.version>
        <commons.lang3.version>3.11</commons.lang3.version>
        <swagger.version>2.1.7</swagger.version>
        <swagger.annotations.version>1.5.20</swagger.annotations.version>
        <log4j.version>1.2.17</log4j.version>
    </properties>
    <!--  全局共用包管理 子模块可以按需导入并且可以忽略版本  -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-core</artifactId>
                <version>${spring.core.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
                <version>${springboot.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
                <version>${springboot.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-test</artifactId>
                <version>${springboot.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-validation</artifactId>
                <version>${springboot.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-tx</artifactId>
                <version>${spring.tx.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
                <version>${spring.core.version}</version>
            </dependency>


            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.connector.version}</version>
            </dependency>
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>${mybatis.plus.version}</version>
            </dependency>
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-core</artifactId>
                <version>${mybatis.plus.version}</version>
            </dependency>
            <dependency>
                <groupId>org.apache.velocity</groupId>
                <artifactId>velocity-engine-core</artifactId>
                <version>${velocity.engine.version}</version>
            </dependency>
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>

            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid-spring-boot-starter</artifactId>
                <version>${druid.spring.boot.starter.version}</version>
            </dependency>

            <!--    判断是否为空 工具包    -->
            <dependency>
                <groupId>org.apache.commons</groupId>
                <artifactId>commons-lang3</artifactId>
                <version>${commons.lang3.version}</version>
            </dependency>

            <dependency>
                <groupId>io.swagger</groupId>
                <artifactId>swagger-annotations</artifactId>
                <version>${swagger.annotations.version}</version>
            </dependency>

            <dependency>
                <groupId>log4j</groupId>
                <artifactId>log4j</artifactId>
                <version>${log4j.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <!--  全局共用包管理 子模块强制继承  -->
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
        </dependency>
    </dependencies>

</project>
```



# Mall-Common 模块

> 本模块用于对整个项目中公用的模块进行抽离，其中包括 `entity` 、`util`，`config`等
>
> 用于设置实体、全局异常处理、全局`MyBatis-Plus`的配置等

## 注意

> 在 `MyBatisPlusConfig` 配置类中，需要声明 `@MapperScan("com.brodog.mall.**.mapper")` 注解，用于扫描多模块下的所有的`mapper`

# Mall-Admin 模块

> 本模块用于创建商城的后台服务，基于`Spring Boot`提供服务
>
> 在前期中我们构建了这个模块，但是没有加这个模块设置为 `Spring`  应用，需要在 `pom` 文件中导入

## 导入`common`模块

> 在 `pom` 文件中需要将公用层模块进行导入

``` xml
<dependencies>
    <dependency>
        <groupId>com.brodog</groupId>
        <artifactId>mall-common</artifactId>
        <version>1.0</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

## 构建 Spring 应用

> 在 `java`包下新建一个 `com.brodog.mall.admin` 包，创建 `MallAdminApplication` 启动类
>
>  









# 细节处理

## 雪花id

> 在项目中，我们使用的是雪花ID，为 `Long` 类型，在返回给前端的时候，未将 `int` 类型转换为 `string` 超过16位后，将出现精度丢失的问题
>
> 这个时候，我们需要在 `vo` 中对 `id` 字段添加 `@JsonSerialize(using= ToStringSerializer.class)` 注解，将返回给前端的数据类型转为 `string`

## 时间类型

> 在使用 `MyBatis-Plus` 自动化构建中，数据库字段为 `datetime`，而构建出来的实体类型是 `Timestamp` 类型，需要注意一下
>
> 否则将会出现类型转换失败的报错