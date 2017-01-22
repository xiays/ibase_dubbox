package com.ibase.server.util;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 执行dao方法之前的切面
 * 获取datasource对象之前往HandleDataSource中指定当前线程数据源路由的key
 * @author Administrator
 *
 */
public class DataSourceAspect {
	
   
	/**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
     * 
     * @param point
     * @throws Exception
     */
    public void before(JoinPoint point) throws Exception {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        // 默认使用目标类型的注解，如果没有则使用其实现接口的注解
        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
    }

    /**
     * 提取目标对象方法注解和类型注解中的数据源标识
     * 
     * @param clazz
     * @param method
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                DataSource source = clazz.getAnnotation(DataSource.class);
                DataSourceHolder.setDbType(source.dbType());
            }
            // 方法注解可以覆盖类型注解
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getAnnotation(DataSource.class);                
                DataSourceHolder.setDbType(source.dbType());
            }
        } catch (Exception e) {
            System.out.println(clazz + ":" + e.getMessage());
        }
    }
	
//    /**
//	 * 在dao层方法之前获取datasource对象之前在切面中指定当前线程数据源路由的key
//	 */
//     public void before(JoinPoint point)       
//     {	
//		 Object target = point.getTarget();
//         System.out.println(target.toString());
//         String method = point.getSignature().getName();
//         System.out.println(method);
//         System.out.println("xxppp");
//         Class<?>[] classz = target.getClass().getInterfaces();
//         Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
//                 .getMethod().getParameterTypes();
//         try {
//             Method m = classz[0].getMethod(method, parameterTypes);
//             System.out.println(m.getName());
//             if (m != null && m.isAnnotationPresent(DataSource.class)) {
//                 DataSource data = m.getAnnotation(DataSource.class);
//                 System.out.println("用户选择数据库库类型："+data.dbType());
//                 DataSourceHolder.setDbType(data.dbType());
//             }
//             
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
}