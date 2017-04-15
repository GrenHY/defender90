package com.tarena.annotation;

/**
 *	用于标识DAO组件，将其纳入到Spring容器中。
 *	MapperScannerConfigurer会使用该注解，它会
 *	扫描指定包下带有当前注解的接口或类，将其
 *	实例化放入Spring容器。
 */
public @interface MyBatisRepository {

}
