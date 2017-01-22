package com.ibase.server;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("加载 dubboxSpring begin");
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-registry.xml","spring-mybatis.xml" });
		context.start();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						sleep(500L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
//		PropertyConfigurator.configure(App.class
//				.getClassLoader().getResource("log4jtcp.properties"));
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"DubboSpringAll.xml");
//		// context.refresh();
//		// context.start();
//		// 守护线程守护
//		new Thread() {
//			@Override
//			public void run() {
//				while (true) {
//					try {
//						sleep(500L);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}.start();
		System.out.println("加载 dubboxSpring end");
    }
}
