package com.sb.hyh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TestAop {
	/*
	 * 定义一个切入点
	 */
	@Pointcut("execution(* com.sb.hyh.web.IndexController.view*(..))")
	public void excudeService() {
	}

	/*
	 * 通过连接点切入
	 */
	@Before("execution(* view*(..)) &&" + "args(name,..)")
	public void twiceAsOld1(String name) {
		System.out.println("切面@Before,name==" + name);
	}

	/**
	 * 主要执行
	 */
	@Around("excudeService()")
	public void twiceAsOld(ProceedingJoinPoint thisJoinPoint) {
		try {
			System.out.println("切面,方法前");
			// 先执行@Before方法
			thisJoinPoint.proceed();
			System.out.println("切面,方法后");
			// 再执行@After方法
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 切面后处理方法
	 */
	@After("execution(* view*(..)) &&" + "args(name,..)")
	public void aopAfter(String name) {
		System.out.println("切面@After,name==" + name);
	}
}